package com.qiuxs.sdriver.biz.entity;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table user
 * @author qiuxs
 *
 */

public class User extends AbstractEntity<Long> {

	private static final long serialVersionUID = 3827250711917269327L;

	/** 登陆名 */
	private String code;

	/** 用户名 */
	private String name;

	/** 密码 */
	private String password;

	/** 个性签名 */
	private String sign;


	/**
	 * get the 登陆名
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * set the 登陆名
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * get the 用户名
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * set the 用户名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the 密码
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * set the 密码
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * get the 个性签名
	 * @return sign
	 */
	public String getSign() {
		return this.sign;
	}

	/**
	 * set the 个性签名
	 * @param sign
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

}