package com.qiuxs.sdriver.biz.service;

import com.qiuxs.cuteframework.core.persistent.service.ifc.IDataPropertyService;
import com.qiuxs.sdriver.biz.dao.UserDao;
import com.qiuxs.sdriver.biz.entity.User;

public interface IUserService extends IDataPropertyService<Long, User, UserDao> {

	User getByBizKeys(String code);

}
