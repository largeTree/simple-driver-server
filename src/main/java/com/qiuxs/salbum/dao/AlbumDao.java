package com.qiuxs.salbum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qiuxs.salbum.entity.Album;

@Repository
public interface AlbumDao extends JpaRepository<Album, Long> {
	
}
