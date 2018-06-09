package com.qiuxs.sdriver.biz.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.qiuxs.cuteframework.core.basic.utils.BitUtils;
import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.basic.utils.JsonUtils;
import com.qiuxs.cuteframework.core.basic.utils.StringUtils;
import com.qiuxs.cuteframework.core.persistent.modal.BaseField;
import com.qiuxs.cuteframework.core.persistent.modal.PropertyWrapper;
import com.qiuxs.cuteframework.core.persistent.service.AbstractDataService;
import com.qiuxs.cuteframework.core.persistent.service.filter.IServiceFilter;
import com.qiuxs.cuteframework.core.persistent.service.filter.impl.IdGenerateFilter;
import com.qiuxs.sdriver.biz.dao.FileDao;
import com.qiuxs.sdriver.biz.dto.FileExtDTO;
import com.qiuxs.sdriver.biz.dto.FileFullFDTO;
import com.qiuxs.sdriver.biz.dto.IBaseFileExtDTO;
import com.qiuxs.sdriver.biz.entity.File;

/**
 * 服务类
 *
 * @author qiuxs
 *
 */
@Service
public class FileService extends AbstractDataService<Long, File, FileDao> {

	private static final String TABLE_NAME = "file";

	private static final Map<Long, Class<? extends IBaseFileExtDTO>> capabilityDtoMap = new HashMap<>();
	static {
		capabilityDtoMap.put(File.FILE, FileExtDTO.class);
	}

	public FileService() {
		super(Long.class, File.class, TABLE_NAME);
	}

	@Resource
	private FileDao fileDao;

	@Override
	protected FileDao getDao() {
		return this.fileDao;
	}

	public void saveFull(FileFullFDTO fileFullDto) {

	}

	public FileFullFDTO fromJSONDTO(String jsonData) {
		FileFullFDTO fileFullDto = JsonUtils.parseObject(jsonData, FileFullFDTO.class);
		JSONObject jFileFullDto = JsonUtils.parseJSONObject(jsonData);
		Long capability = fileFullDto.getFile().getCapability();
		List<Long> bits = BitUtils.splitBits(capability);
		Map<Long, IBaseFileExtDTO> fileExtMap = new HashMap<>();
		for (Long bit : bits) {
			String jsonStr = jFileFullDto.getString(bit.toString());
			if (StringUtils.isBlank(jsonStr)) {
				ExceptionUtils.throwLogicalException("file_capability_obj_is_required");
			}
			IBaseFileExtDTO extDto = JsonUtils.parseObject(jsonStr, capabilityDtoMap.get(bit));
			fileExtMap.put(bit, extDto);
		}
		fileFullDto.setExtMap(fileExtMap);
		return fileFullDto;
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, File>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "主键", "Long"), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("name", "文件名", "String"), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("parentId", "父级ID", "Long"), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("capability", "能力位", "Integer"), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("createdTime", "创建日期", "Date"), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("updatedTime", "更新日期", "Date"), null);
		props.add(prop);

	}

}
