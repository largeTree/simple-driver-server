package com.qiuxs.sdriver.biz.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.qiuxs.cuteframework.core.basic.utils.BitUtils;
import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.basic.utils.JsonUtils;
import com.qiuxs.cuteframework.core.basic.utils.NumberUtils;
import com.qiuxs.cuteframework.core.basic.utils.StringUtils;
import com.qiuxs.cuteframework.core.persistent.database.modal.BaseField;
import com.qiuxs.cuteframework.core.persistent.database.modal.PropertyWrapper;
import com.qiuxs.cuteframework.core.persistent.database.service.AbstractDataService;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.IServiceFilter;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.impl.IdGenerateFilter;
import com.qiuxs.cuteframework.core.persistent.database.service.ifc.IDataPropertyService;
import com.qiuxs.sdriver.biz.dao.FileDao;
import com.qiuxs.sdriver.biz.dto.FileExtDTO;
import com.qiuxs.sdriver.biz.dto.FileFullFDTO;
import com.qiuxs.sdriver.biz.dto.IBaseFileExtDTO;
import com.qiuxs.sdriver.biz.entity.File;
import com.qiuxs.sdriver.biz.service.IFileExtService;
import com.qiuxs.sdriver.biz.service.IFileService;
import com.qiuxs.sdriver.biz.service.IUserService;

/**
 * 服务类
 *
 * @author qiuxs
 *
 */
@Service
public class FileServiceImpl extends AbstractDataService<Long, File, FileDao> implements IFileService {

	private static final String TABLE_NAME = "file";

	private static final Map<Long, Class<? extends IBaseFileExtDTO>> capabilityDtoMap = new HashMap<>();
	static {
		capabilityDtoMap.put(File.FILE, FileExtDTO.class);
	}

	@SuppressWarnings("rawtypes")
	private Map<Long, IDataPropertyService> capServiceMap;

	@Resource
	private FileDao fileDao;

	@Resource
	private IFileExtService fileExtService;
	
	@Resource
	private IUserService userService;

	public FileServiceImpl() {
		super(Long.class, File.class, TABLE_NAME);
	}

	protected FileDao getDao() {
		return this.fileDao;
	}

	@Override
	public void saveFull(FileFullFDTO fileFullDto) {
		File file = fileFullDto.getFile();
		if (file.getId() == null) {
			this.createFull(fileFullDto);
		} else {
			this.updateFull(fileFullDto);
		}
	}

	@Override
	@Transactional
	public void createFull(FileFullFDTO fileFullDto) {
		File file = fileFullDto.getFile();
		// 因为需要设置levelCode，所以先设置好ID
		this.setId(file);
		this.create(file);
		// 保存扩展表
		this.saveExt(fileFullDto);
	}

	@Override
	@Transactional
	public void updateFull(FileFullFDTO fileFullDto) {
		File file = fileFullDto.getFile();
		this.update(file);
		// 保存扩展表
		this.saveExt(fileFullDto);
	}

	@SuppressWarnings("unchecked")
	private void saveExt(FileFullFDTO fileFullDto) {
		File file = fileFullDto.getFile();
		Map<Long, IBaseFileExtDTO> extMap = fileFullDto.getExtMap();
		for (Iterator<Map.Entry<Long, IBaseFileExtDTO>> iter = extMap.entrySet().iterator(); iter.hasNext();) {
			Entry<Long, IBaseFileExtDTO> entry = iter.next();
			Long capability = entry.getKey();
			IBaseFileExtDTO extDto = entry.getValue();

			@SuppressWarnings("rawtypes")
			IDataPropertyService extService = getExtService(capability);
			extDto.setId(file.getId());
			extService.save(extDto);
		}
	}

	@SuppressWarnings("rawtypes")
	private IDataPropertyService getExtService(Long cap) {
		if (this.capServiceMap == null) {
			Map<Long, IDataPropertyService> capServiceMapTemp = new HashMap<>();
			capServiceMapTemp.put(File.FILE, this.fileExtService);

			this.capServiceMap = capServiceMapTemp;
		}
		return this.capServiceMap.get(cap);
	}

	@Override
	public FileFullFDTO fromJSONDTO(String jsonData) {
		FileFullFDTO fileFullDto = JsonUtils.parseObject(jsonData, FileFullFDTO.class);
		JSONObject jFileFullDto = JsonUtils.parseJSONObject(jsonData);
		Long capability = fileFullDto.getFile().getCapability();
		List<Long> bits = BitUtils.splitBits(capability);
		Map<Long, IBaseFileExtDTO> fileExtMap = new HashMap<>();
		for (Long bit : bits) {
			// 能力位为目录(1)时不需要扩展表
			if (NumberUtils.equals(bit, File.DIRECTORY)) {
				continue;
			}
			String jsonStr = jFileFullDto.getString(bit.toString());
			Class<? extends IBaseFileExtDTO> extClz = capabilityDtoMap.get(bit);
			if (extClz != null && StringUtils.isBlank(jsonStr)) {
				ExceptionUtils.throwLogicalException("file_capability_obj_is_required");
			}
			IBaseFileExtDTO extDto = JsonUtils.parseObject(jsonStr, extClz);
			fileExtMap.put(bit, extDto);
		}
		fileFullDto.setExtMap(fileExtMap);
		return fileFullDto;
	}

	@Override
	protected void preSave(File oldBean, File newBean) {
		super.preSave(oldBean, newBean);
		if (newBean != null) {
			if (newBean.getParentId() > 0L) {
				File parent = this.getById(newBean.getParentId());
				newBean.setLevel(parent.getLevel() + 1);
				newBean.setLevelCode(parent.getLevelCode() + newBean.getId() + ".");
			} else {
				newBean.setLevel(0);
				newBean.setLevelCode("." + newBean.getId() + ".");
			}
		}
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, File>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "主键", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("name", "文件名", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("parentId", "父级ID", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("capability", "能力位", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("createdBy", "创建人", Long.class), this.userService);
		props.add(prop);
		
		prop = new PropertyWrapper<Date>(new BaseField("createdTime", "创建日期", Date.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("updatedBy", "更新人", Long.class), this.userService);
		props.add(prop);
		
		prop = new PropertyWrapper<Date>(new BaseField("updatedTime", "更新日期", Date.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("level", "深度", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("levelCode", "深度编码", String.class), null);
		props.add(prop);

	}

}
