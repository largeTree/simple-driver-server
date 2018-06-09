package com.qiuxs.sdriver.biz.dao;

import org.springframework.stereotype.Repository;

import com.qiuxs.cuteframework.core.persistent.dao.IBaseDao;
import com.qiuxs.sdriver.biz.entity.File;

/**
 * Dao接口
 *
 * @author qiuxs
 *
 */
@Repository
public interface FileDao extends IBaseDao<Long, File> {

}
