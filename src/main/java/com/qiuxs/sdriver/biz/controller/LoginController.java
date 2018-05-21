package com.qiuxs.sdriver.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.BaseController;

@RestController
@RequestMapping(value = "/api", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class LoginController extends BaseController {

	/**
	 * 登陆接口
	 * 
	 * @param userCode
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String userCode, String password) {
		return null;
	}

}
