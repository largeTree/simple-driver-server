package com.qiuxs.salbum.biz.dao;

import org.springframework.stereotype.Repository;

import com.qiuxs.salbum.biz.entity.User;
import com.qiuxs.salbum.frm.persistent.dao.IBaseDao;

@Repository
public interface UserDao extends IBaseDao<Long, User> {

}
