package com.qiuxs.salbum.frm.persistent.service;

import java.io.Serializable;

import com.qiuxs.salbum.frm.persistent.entiry.IBaseEntity;

/**  
 * 功能描述: <br/>  
 * 新增原因: TODO<br/>  
 * 新增日期: 2018年4月18日 下午10:29:22 <br/>  
 *  
 * @author qiuxs   
 * @version 1.0.0
 */
public abstract class AbstractPropertyService<PK extends Serializable, T extends IBaseEntity<PK>> implements IPropertyService<PK, T> {

	private Class<T> pojoClass;

	private Class<PK> pkClass;

	public AbstractPropertyService(Class<PK> pkClass, Class<T> pojoClass) {
		this.pkClass = pkClass;
		this.pojoClass = pojoClass;
	}

	public Class<T> getPojoClass() {
		return pojoClass;
	}

	public Class<PK> getPkClass() {
		return pkClass;
	}

}
