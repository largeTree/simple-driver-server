package com.qiuxs.sdriver.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.BaseController;
import com.qiuxs.sdriver.biz.dao.TestUserDao;
import com.qiuxs.sdriver.biz.entity.User;

@RestController
@RequestMapping(value = "/test", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class TestController extends BaseController {

	@Resource
	private TestUserDao testUerDao;

	@GetMapping("/get/{id}")
	public String getUserById(@PathVariable("id") Long id) {
		User selectByPrimaryKey = this.testUerDao.selectByPrimaryKey(id);
		return super.responseRes(selectByPrimaryKey);
	}

}
