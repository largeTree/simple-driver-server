package com.qiuxs.sdriver.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.frm.web.controller.AbstractDataController;
import com.qiuxs.sdriver.biz.dao.UserDao;
import com.qiuxs.sdriver.biz.entity.User;
import com.qiuxs.sdriver.biz.service.UserService;

@RestController
@RequestMapping(value = "/user", produces = "application/json; charset=UTF-8")
public class UserController extends AbstractDataController<Long, User, UserDao, UserService> {

	@Resource
	private UserService userService;

	@Override
	protected UserService getService() {
		return this.userService;
	}

}
