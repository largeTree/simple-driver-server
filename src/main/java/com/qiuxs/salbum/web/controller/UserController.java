package com.qiuxs.salbum.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.salbum.dao.UserDao;
import com.qiuxs.salbum.entity.User;
import com.qiuxs.salbum.frm.web.controller.BaseController;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {

	private static Logger log = LogManager.getLogger(UserController.class);

	@Resource
	private UserDao userDao;

	@GetMapping(value = "/list")
	public List<User> list() {
		List<User> users = this.userDao.findAll();
		log.error("abc");
		return users;
	}

	@PostMapping("/create")
	public String create(Map<String, String> params) {
		return super.responseRes(0L);
	}

}
