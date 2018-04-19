package com.qiuxs.salbum.biz.dao;

import org.springframework.stereotype.Repository;

import com.qiuxs.salbum.biz.entity.Photo;
import com.qiuxs.salbum.frm.persistent.dao.IBaseDao;

@Repository
public interface PhotoDao extends IBaseDao<Long, Photo> {

}
