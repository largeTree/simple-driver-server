package com.qiuxs.salbum.frm.web.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

	@ExceptionHandler
	public String handlerException(Throwable e) {
		return "";
	}

}
