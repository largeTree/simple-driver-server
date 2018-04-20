package com.qiuxs.salbum.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.frm.web.controller.AbstractDataController;
import com.qiuxs.salbum.biz.dao.UserDao;
import com.qiuxs.salbum.biz.entity.User;
import com.qiuxs.salbum.biz.service.UserService;

@RestController
@RequestMapping(value = "/api/user", produces = "application/json; charset=UTF-8")
public class UserController extends AbstractDataController<Long, User, UserDao, UserService> {

	@Resource
	private UserService userService;

	@Override
	protected UserService getService() {
		return this.userService;
	}

}
