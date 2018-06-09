package com.qiuxs.sdriver.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.core.basic.bean.UserLite;
import com.qiuxs.cuteframework.core.context.UserContext;
import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.BaseController;
import com.qiuxs.sdriver.biz.service.UserService;

@RestController
@RequestMapping(value = "/api", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class LoginController extends BaseController {

	@Resource
	private UserService userService;

	/**
	 * 登陆接口
	 * 
	 * @param userCode
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String userCode, String password) {
		UserLite userLite = userService.login(userCode, password);
		UserContext.addUserLite(userLite);
		return super.responseRes(userLite);
	}

}
