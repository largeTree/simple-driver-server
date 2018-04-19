package com.qiuxs.salbum.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.salbum.frm.web.controller.BaseController;

@RestController
@RequestMapping("/api")
public class LoginController extends BaseController {

	/**
	 * 登陆接口
	 * @param userCode
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String userCode, String password) {
		return "";
	}

}
