package com.qiuxs.sdriver.biz.entity;

import com.qiuxs.cuteframework.core.persistent.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table file
 * @author qiuxs
 *
 */

public class File extends AbstractEntity<Long> {

	private static final long serialVersionUID = -8405430686014808753L;

	/** 文件名 */
	private String name;

	/** 父级ID */
	private Long parentId;

	/** 能力位 */
	private Integer capability;


	/**
	 * get the 文件名
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * set the 文件名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the 父级ID
	 * @return parentId
	 */
	public Long getParentId() {
		return this.parentId;
	}

	/**
	 * set the 父级ID
	 * @param parentId
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * get the 能力位
	 * @return capability
	 */
	public Integer getCapability() {
		return this.capability;
	}

	/**
	 * set the 能力位
	 * @param capability
	 */
	public void setCapability(Integer capability) {
		this.capability = capability;
	}

}