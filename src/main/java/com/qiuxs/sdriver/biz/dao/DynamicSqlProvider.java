package com.qiuxs.sdriver.biz.dao;

import org.apache.ibatis.mapping.MappedStatement;

public class DynamicSqlProvider {

	public String dynamicSQL(Object record) {
		return "dynamicSQL";
	}

	public String get(MappedStatement ms) {
		return "select * from user where id = #{id}";
	}
	
}
