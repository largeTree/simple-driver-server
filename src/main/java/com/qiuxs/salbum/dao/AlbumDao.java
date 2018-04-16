package com.qiuxs.salbum.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qiuxs.salbum.entity.Album;

@Repository
public interface AlbumDao extends CrudRepository<Album, Long> {
	
}
