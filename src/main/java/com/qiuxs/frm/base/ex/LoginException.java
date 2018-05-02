package com.qiuxs.frm.base.ex;

public class LoginException extends RuntimeException {

	private static final long serialVersionUID = 8097214045978299511L;

	/** 异常代码 */
	private int code;

	public LoginException() {
		super("无效会话，请重新登陆");
		this.code = ErrorCodeConstants.SESSION_INVALID;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
