package com.qiuxs.salbum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qiuxs.salbum.entity.Photo;

@Repository
public interface PhotoDao extends JpaRepository<Photo, Long> {
	
}
