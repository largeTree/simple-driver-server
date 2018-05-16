package com.qiuxs.frm.persistent.entiry;

import java.util.Date;

public abstract class AbstractEntity<PK> implements IBaseEntity<PK> {

	private static final long serialVersionUID = 6177696431975026769L;

	private PK id;

	/** 创建时间 */
	private Date createdTime;
	/** 更新时间 */
	private Date updatedTime;

	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}

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
