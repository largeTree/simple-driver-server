package com.qiuxs.salbum.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qiuxs.salbum.entity.Photo;

@Repository
public interface PhotoDao extends CrudRepository<Photo, Long> {
	
}
