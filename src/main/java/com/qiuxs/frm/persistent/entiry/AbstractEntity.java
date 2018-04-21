package com.qiuxs.frm.persistent.entiry;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<PK> implements IBaseEntity<PK> {

	private static final long serialVersionUID = 6177696431975026769L;

	/** 创建时间 */
	private Date createdTime;
	/** 更新时间 */
	private Date updatedTime;

	@Override
	public Date getCreatedTime() {
		return this.createdTime;
	}

	@Override
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	@Override
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

}
