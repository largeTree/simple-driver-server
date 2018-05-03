package com.qiuxs.salbum.biz.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiuxs.frm.base.bean.UserLite;
import com.qiuxs.frm.base.utils.Constants;
import com.qiuxs.frm.base.utils.security.MD5Util;
import com.qiuxs.frm.persistent.service.AbstractDataService;
import com.qiuxs.salbum.biz.dao.UserDao;
import com.qiuxs.salbum.biz.entity.User;

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
			bean.setPassword(MD5Util.MD5Encode(bean.getPassword(), Constants.UTF_8));
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
		if (user != null) {
			
		}
		return null;
	}

}
