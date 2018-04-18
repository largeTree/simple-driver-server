package com.qiuxs.salbum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qiuxs.salbum.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	
}
