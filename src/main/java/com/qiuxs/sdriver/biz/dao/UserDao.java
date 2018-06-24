package com.qiuxs.sdriver.biz.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qiuxs.cuteframework.core.persistent.database.dao.IBaseDao;
import com.qiuxs.sdriver.biz.entity.User;

/**
 * Dao接口
 *
 * @author qiuxs
 *
 */
@Repository
public interface UserDao extends IBaseDao<Long, User> {

	User getByBizKeys(@Param("code") String code);

}
