package com.qiuxs.sdriver.biz.dao;

import org.springframework.stereotype.Repository;

import com.qiuxs.sdriver.biz.entity.User;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TestUserDao extends Mapper<User> {

}
