package com.qiuxs.frm.base.ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class LoginException extends RuntimeException {

	private static final long serialVersionUID = 8097214045978299511L;

	/** 异常代码 */
	private int code;

	public LoginException() {
		super("无效会话，请重新登陆");
		this.code = ErrorCodeConstants.SESSION_INVALID;
	}

	public LoginException(int code, String msg) {
		super(msg);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
