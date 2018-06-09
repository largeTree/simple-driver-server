package com.qiuxs.sdriver.biz.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiuxs.cuteframework.core.basic.Constants;
import com.qiuxs.cuteframework.core.basic.bean.UserLite;
import com.qiuxs.cuteframework.core.basic.ex.ErrorCodes;
import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.basic.utils.generator.GUIDGenerator;
import com.qiuxs.cuteframework.core.basic.utils.security.MD5Util;
import com.qiuxs.cuteframework.core.context.UserContext;
import com.qiuxs.sdriver.biz.entity.User;
import com.qiuxs.sdriver.biz.service.IUserAuthService;
import com.qiuxs.sdriver.biz.service.IUserService;

@Service
public class UserAuthServiceImpl implements IUserAuthService {

	@Resource
	private IUserService userService;

	@Override
	@Transactional
	public UserLite login(String userCode, String password) {
		User user = this.userService.getByBizKeys(userCode);
		if (user == null) {
			ExceptionUtils.throwLoginException(ErrorCodes.SessionError.USER_CODE_NOT_EXISTS, "user_is_not_exists",
					userCode);
		}
		if (!user.getPassword().equals(MD5Util.MD5Encode(password, Constants.DEFAULT_CHARSET))) {
			ExceptionUtils.throwLoginException(ErrorCodes.SessionError.PASSWORD_ERROR, "password_incorrect");
		}
		UserLite userLite = this.genSession(user);
		UserContext.addUserLite(userLite);
		return userLite;
	}

	private UserLite genSession(User user) {
		UserLite userLite = new UserLite();
		userLite.setLoginTime(new Date());
		userLite.setLoginId(user.getCode());
		userLite.setName(user.getName());
		userLite.setUserId(user.getId());
		userLite.setSessionId(new GUIDGenerator().toString());
		return userLite;
	}

}
