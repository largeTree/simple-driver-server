package com.qiuxs.sdriver.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;
import com.qiuxs.sdriver.biz.dao.UserDao;
import com.qiuxs.sdriver.biz.entity.User;
import com.qiuxs.sdriver.biz.service.IUserService;

/**
 * 控制器
 *
 * @author qiuxs
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/user", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class UserController extends AbstractDataController<Long, User, UserDao, IUserService> {

	@Resource
	private IUserService userService;

	@Override
	protected IUserService getService() {
		return this.userService;
	}

}
