package com.qiuxs.salbum.biz.dao;

import org.springframework.stereotype.Repository;

import com.qiuxs.frm.persistent.dao.IBaseDao;
import com.qiuxs.salbum.biz.entity.User;

@Repository
public interface UserDao extends IBaseDao<Long, User> {

	/**
	 * 根据code获取一个用户对象
	 * @param userCode
	 * @return
	 */
	public User getByCode(String userCode);

}
