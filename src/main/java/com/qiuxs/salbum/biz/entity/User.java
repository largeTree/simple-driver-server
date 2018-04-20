package com.qiuxs.salbum.biz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** 账号 */
	private String code;

	/** 用户名 */
	private String userName;

	/** 密码 */
	private String password;

	/** 个性签名 */
	private String sign;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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