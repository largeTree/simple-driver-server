package com.qiuxs.sdriver.biz.entity;

import com.qiuxs.cuteframework.core.persistent.entity.impl.AbstractEntity;

public class User extends AbstractEntity<Long> {
	
	private static final long serialVersionUID = -7299851880162666341L;
	
	private String name;
	private String password;

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

}
