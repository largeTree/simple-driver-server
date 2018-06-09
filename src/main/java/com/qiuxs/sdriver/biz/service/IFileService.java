package com.qiuxs.sdriver.biz.service;

import com.qiuxs.cuteframework.core.persistent.service.ifc.IDataPropertyService;
import com.qiuxs.sdriver.biz.dao.FileDao;
import com.qiuxs.sdriver.biz.dto.FileFullFDTO;
import com.qiuxs.sdriver.biz.entity.File;

public interface IFileService extends IDataPropertyService<Long, File, FileDao> {

	FileFullFDTO fromJSONDTO(String jsonData);

	void saveFull(FileFullFDTO fileFullDto);

}
