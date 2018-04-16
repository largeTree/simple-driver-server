package com.qiuxs.salbum.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qiuxs.salbum.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
}
