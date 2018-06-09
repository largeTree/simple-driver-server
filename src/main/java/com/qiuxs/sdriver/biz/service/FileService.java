package com.qiuxs.sdriver.biz.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiuxs.cuteframework.core.persistent.modal.BaseField;
import com.qiuxs.cuteframework.core.persistent.modal.PropertyWrapper;
import com.qiuxs.cuteframework.core.persistent.service.AbstractDataService;
import com.qiuxs.cuteframework.core.persistent.service.filter.IServiceFilter;
import com.qiuxs.cuteframework.core.persistent.service.filter.impl.IdGenerateFilter;
import com.qiuxs.sdriver.biz.dao.FileDao;
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

	public FileService() {
		super(Long.class, File.class, TABLE_NAME);
	}

	@Resource
	private FileDao fileDao;

	@Override
	protected FileDao getDao() {
		return this.fileDao;
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
