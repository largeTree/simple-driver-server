package com.qiuxs.sdriver.biz.service;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiuxs.frm.base.bean.UserLite;
import com.qiuxs.frm.base.ex.ErrorCodeConstants;
import com.qiuxs.frm.base.utils.Constants;
import com.qiuxs.frm.base.utils.ExceptionUtils;
import com.qiuxs.frm.base.utils.security.MD5Util;
import com.qiuxs.frm.persistent.service.AbstractDataService;
import com.qiuxs.sdriver.biz.dao.UserDao;
import com.qiuxs.sdriver.biz.entity.User;

@Service
public class UserService extends AbstractDataService<Long, User, UserDao> {

	public UserService() {
		super(Long.class, User.class);
	}

	@Resource
	private UserDao userDao;

	@Override
	protected UserDao getDao() {
		return this.userDao;
	}

	@Override
	protected void initCreate(User bean) {
		super.initCreate(bean);
		if (bean.getPassword() != null) {
			bean.setPassword(MD5Util.MD5Encode(bean.getPassword(), Constants.DEFAULT_CHARSET));
		}
	}

	/**
	 * 登陆操作
	 * @param userCode
	 * @param password
	 * @return
	 */
	public UserLite login(String userCode, String password) {
		User user = this.getDao().getByCode(userCode);
		if (user == null) {
			ExceptionUtils.throwLoginException(ErrorCodeConstants.USER_CODE_NOT_EXISTS, "用户" + userCode + "不存在");
		}
		if (user.getPassword().equals(MD5Util.MD5Encode(password, Constants.DEFAULT_CHARSET))) {
			UserLite userLite = new UserLite();
			userLite.setLoginTime(new Date());
			userLite.setName(user.getUserName());
			userLite.setUserId(user.getId());
			userLite.setSessionId(UUID.randomUUID().toString());
			return userLite;
		} else {
			ExceptionUtils.throwLoginException(ErrorCodeConstants.PASSWORD_ERROR, "密码错误");
		}
		return null;
	}

}
