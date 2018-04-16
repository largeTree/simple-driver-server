package com.qiuxs.salbum.web.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qiuxs.salbum.dao.UserDao;
import com.qiuxs.salbum.entity.User;
import com.qiuxs.salbum.frm.web.controller.BaseController;

@RequestMapping("/user")
public class UserController extends BaseController {

	@Resource
	private UserDao userDao;

	@GetMapping(value = "/list")
	public List<User> list() {
		Iterator<User> usersIter = this.userDao.findAll().iterator();
		List<User> users = new LinkedList<>();
		while (usersIter.hasNext()) {
			users.add(usersIter.next());
		}
		return users;
	}

}
