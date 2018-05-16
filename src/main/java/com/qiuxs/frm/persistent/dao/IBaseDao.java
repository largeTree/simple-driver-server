package com.qiuxs.frm.persistent.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.qiuxs.frm.persistent.PageInfo;
import com.qiuxs.frm.persistent.entiry.IBaseEntity;

/**
 * 基础Dao
 * @author qiuxs
 *
 * @param <PK>
 * @param <T>
 */
public interface IBaseDao<PK extends Serializable, T extends IBaseEntity<PK>> {

	/**
	 * 根据ID删除
	 * @param id
	 */
	void deleteById(PK id);

	/**
	 * 根据ID获取行
	 * @param id
	 * @return
	 */
	T get(PK id);

	/**
	 * 根据ID集合获取多行记录
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Collection<PK> ids);

	/**
	 * 查询列表
	 * @param params
	 * @param pageInfo
	 * @return
	 */
	List<T> list(Map<String, Object> params, PageInfo pageInfo);
	
	/**
	 * 新增行
	 * @param bean
	 */
	void insert(T bean);
	
	/**
	 * 更新行
	 * @param bean
	 */
	void update(T bean);

}
