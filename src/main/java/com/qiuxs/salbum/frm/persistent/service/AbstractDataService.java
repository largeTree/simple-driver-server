package com.qiuxs.salbum.frm.persistent.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;

import com.qiuxs.salbum.frm.persistent.PageInfo;
import com.qiuxs.salbum.frm.persistent.dao.IBaseDao;
import com.qiuxs.salbum.frm.persistent.entiry.IBaseEntity;

/**
 * 
 * 功能描述: <br/>  
 * 新增原因: TODO<br/>  
 * 新增日期: 2018年4月18日 下午9:16:44 <br/>  
 *  
 * @author qiuxs   
 * @version 1.0.0
 */
public abstract class AbstractDataService<PK extends Serializable, T extends IBaseEntity<PK>, D extends IBaseDao<PK, T>> extends AbstractPropertyService<PK, T> implements IDataService<PK, T, D> {

	public AbstractDataService(Class<PK> pkClass, Class<T> pojoClass) {
		super(pkClass, pojoClass);
	}

	/**
	 * 获取Dao对象
	 *  
	 * @author qiuxs  
	 * @return
	 */
	protected abstract D getDao();

	/**
	 * 根据ID获取一行记录
	 *  
	 * @author qiuxs  
	 * @param id
	 * @return
	 */
	public T getById(PK id) {
		return this.getDao().getOne(id);
	}

	/**
	 * 根据ID获取多行记录
	 *  
	 * @author qiuxs  
	 * @param ids
	 * @return
	 */
	public List<T> getByIds(Collection<PK> ids) {
		return this.getDao().findAllById(ids);
	}

	/**
	 * 使用Map作为参数查询
	 *  
	 * @author qiuxs  
	 * @param params
	 * @return
	 */
	public List<T> findByMap(final Map<String, Object> params, PageInfo pageInfo) {
		Page<T> page = this.getDao().findAll(new Example<T>() {

			@Override
			public T getProbe() {
				return null;
			}

			@Override
			public ExampleMatcher getMatcher() {
				return null;
			}
		}, pageInfo);
		return page.getContent();
	}

	/**
	 * 保存对象
	 *  
	 * @author qiuxs  
	 * @param bean
	 */
	public void save(T bean) {
		if (preSave(bean)) {
			this.getDao().save(bean);
		}
		postSave(bean);
	}

	/**
	 * 保存前操作
	 *  
	 * @author qiuxs  
	 * @param bean
	 * @return
	 */
	protected boolean preSave(T bean) {
		return true;
	}

	/**
	 * 保存后操作
	 *  
	 * @author qiuxs  
	 * @param bean
	 */
	protected void postSave(T bean) {
	}

}
