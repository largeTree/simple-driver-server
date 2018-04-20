package com.qiuxs.frm.persistent.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.qiuxs.frm.persistent.PageInfo;

public interface IDataService<PK, T, D> {

	public void create(T bean);

	public void save(T bean);

	public void update(T newBean);

	public T getById(PK id);

	public List<T> getByIds(Collection<PK> ids);

	public List<T> findByMap(final Map<String, Object> params, PageInfo pageInfo);

	public void deleteById(PK id);
}
