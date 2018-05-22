package com.qiuxs.sdriver.biz.dao;

import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.qiuxs.sdriver.biz.entity.User;

@Repository
public interface UserDao {

	@SelectProvider(type = DynamicSqlProvider.class, method = "dynamicSQL")
	public User get(Long id);

}
