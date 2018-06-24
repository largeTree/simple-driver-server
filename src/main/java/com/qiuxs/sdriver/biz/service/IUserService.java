package com.qiuxs.sdriver.biz.service;

import com.qiuxs.cuteframework.core.basic.code.provider.ICodeTranslatable;
import com.qiuxs.cuteframework.core.persistent.database.service.ifc.IDataPropertyService;
import com.qiuxs.sdriver.biz.dao.UserDao;
import com.qiuxs.sdriver.biz.entity.User;

public interface IUserService extends IDataPropertyService<Long, User, UserDao>, ICodeTranslatable<Long> {

	User getByBizKeys(String code);

}
