package com.qiuxs.sdriver.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.frm.web.controller.BaseController;

@RestController
@RequestMapping(value = "/api", produces = "application/json; charset=UTF-8")
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
