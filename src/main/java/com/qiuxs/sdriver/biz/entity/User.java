package com.qiuxs.sdriver.biz.entity;

import com.qiuxs.frm.persistent.entiry.AbstractEntity;

/**
 * 用户类
 * 
 * @author qiuxs
 *
 */
public class User extends AbstractEntity<Long> {

	private static final long serialVersionUID = -9006846567127786189L;

	/** 用户名 */
	private String name;
	/** 密码 */
	private String password;
	/** 签名 */
	private String sign;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
