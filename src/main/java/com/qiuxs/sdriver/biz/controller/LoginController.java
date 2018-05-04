package com.qiuxs.sdriver.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.frm.base.bean.UserLite;
import com.qiuxs.frm.context.UserContext;
import com.qiuxs.frm.web.controller.BaseController;
import com.qiuxs.sdriver.biz.service.UserService;

@RestController
@RequestMapping(value = "/api", produces = "application/json; charset=UTF-8")
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
		UserLite userLite = this.userService.login(userCode, password);
		UserContext.addUserLite(userLite);
		return super.responseRes(userLite);
	}

}
