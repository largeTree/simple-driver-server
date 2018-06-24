package com.qiuxs.sdriver.biz.dao;

import org.springframework.stereotype.Repository;

import com.qiuxs.cuteframework.core.persistent.database.dao.IBaseDao;
import com.qiuxs.sdriver.biz.entity.FileExt;

/**
 * Dao接口
 *
 * @author qiuxs
 *
 */
@Repository
public interface FileExtDao extends IBaseDao<Long, FileExt> {

}
