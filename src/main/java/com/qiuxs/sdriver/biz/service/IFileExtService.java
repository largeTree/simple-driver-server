package com.qiuxs.sdriver.biz.service;

import com.qiuxs.cuteframework.core.persistent.database.service.ifc.IDataPropertyService;
import com.qiuxs.sdriver.biz.dao.FileExtDao;
import com.qiuxs.sdriver.biz.entity.FileExt;

public interface IFileExtService extends IDataPropertyService<Long, FileExt, FileExtDao> {

}
