package com.qiuxs.salbum.frm.persistent.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.qiuxs.salbum.frm.persistent.PageInfo;

public interface IDataService<PK, T, D> {

	public void save(T bean);

	public T getById(PK id);

	public List<T> getByIds(Collection<PK> ids);

	public List<T> findByMap(final Map<String, Object> params, PageInfo pageInfo);

}
