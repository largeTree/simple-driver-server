package com.qiuxs.frm.persistent.entiry;

import java.io.Serializable;
import java.util.Date;

public interface IBaseEntity<PK> extends Serializable {

	public PK getId();

	public void setId(PK id);

	public Date getCreatedTime();

	public void setCreatedTime(Date createdTime);

	public Date getUpdatedTime();

	public void setUpdatedTime(Date updatedTime);

}
