package com.qiuxs.salbum.biz.dao;

import org.springframework.stereotype.Repository;

import com.qiuxs.frm.persistent.dao.IBaseDao;
import com.qiuxs.salbum.biz.entity.Album;

@Repository
public interface AlbumDao extends IBaseDao<Long, Album> {

}
