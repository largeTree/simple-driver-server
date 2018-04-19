package com.qiuxs.salbum.biz.dao;

import org.springframework.stereotype.Repository;

import com.qiuxs.salbum.biz.entity.Album;
import com.qiuxs.salbum.frm.persistent.dao.IBaseDao;

@Repository
public interface AlbumDao extends IBaseDao<Long, Album> {

}
