package com.qiuxs.sdriver.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.BaseController;
import com.qiuxs.sdriver.biz.dao.UserDao;

@RestController
@RequestMapping(value = "/test", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class UserController extends BaseController {
	
	@Resource
	private UserDao userDao;

	@GetMapping("/user/{id}")
	public String getUser(@PathVariable("id")Long id) {
		return super.responseRes(userDao.get(id));
	}
	
}
