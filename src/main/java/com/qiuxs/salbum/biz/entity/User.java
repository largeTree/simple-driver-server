package com.qiuxs.salbum.biz.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.qiuxs.frm.persistent.entiry.AbstractEntity;

/**
 * 用户
 * 
 * @author qiuxs
 *
 */
@Entity
public class User extends AbstractEntity<Long> {

	private static final long serialVersionUID = 634070881511721130L;

	/** 账号 */
	@NotNull
	private String code;

	/** 用户名 */
	@NotNull
	private String userName;

	/** 密码 */
	@NotNull
	private String password;

	/** 个性签名 */
	private String sign;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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