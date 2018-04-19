package com.qiuxs.salbum.biz.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.qiuxs.salbum.frm.persistent.entiry.IBaseEntity;

/**
 * 相册
 * 
 * @author qiuxs
 *
 */
@Entity
public class Album implements IBaseEntity<Long> {

	private static final long serialVersionUID = -3433255130704068846L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** 相册名 */
	private String name;

	/** 描述 */
	private String description;

	/** 相册所有者 */
	private Long ownerId;

	/** 创建日期 */
	private Date createdDate;

	/** 更新日期 */
	private Date updatedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
