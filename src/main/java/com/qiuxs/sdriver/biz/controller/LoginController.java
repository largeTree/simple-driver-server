package com.qiuxs.sdriver.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.core.basic.bean.UserLite;
import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.BaseController;
import com.qiuxs.sdriver.biz.service.IUserAuthService;

@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX, produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class LoginController extends BaseController {

	@Resource
	private IUserAuthService userService;

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
		return super.responseRes(userLite);
	}

}
