package com.qiuxs.frm.persistent.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.qiuxs.frm.persistent.PageInfo;
import com.qiuxs.frm.persistent.entiry.IBaseEntity;

public interface IBaseDao<PK extends Serializable, T extends IBaseEntity<PK>> {

	void deleteById(PK id);

	T get(PK id);

	List<T> getByIds(Collection<PK> ids);

	List<T> list(Map<String, Object> params, PageInfo pageInfo);
	
	void insert(T bean);
	
	void update(T bean);

}
