package com.qiuxs.sdriver.biz.service;

import com.qiuxs.cuteframework.core.basic.bean.UserLite;

public interface IUserAuthService {
	public UserLite login(String code, String password);
}
