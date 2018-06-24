package com.qiuxs.sdriver.biz.entity;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类 for table file
 * 
 * @author qiuxs
 *
 */

public class File extends AbstractEntity<Long> {

	private static final long serialVersionUID = -8405430686014808753L;

	public static final long DIRECTORY = 1; // 1
	public static final long FILE = 1 << 1; // 2

	/** 文件名 */
	private String name;

	/** 父级ID */
	private Long parentId;

	/** 能力位 */
	private Long capability;

	/** 深度 */
	private Integer level;

	/** 深度编码 */
	private String levelCode;

	/**
	 * get the 文件名
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * set the 文件名
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the 父级ID
	 * 
	 * @return parentId
	 */
	public Long getParentId() {
		return this.parentId;
	}

	/**
	 * set the 父级ID
	 * 
	 * @param parentId
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * get the 能力位
	 * 
	 * @return capability
	 */
	public Long getCapability() {
		return this.capability;
	}

	/**
	 * set the 能力位
	 * 
	 * @param capability
	 */
	public void setCapability(Long capability) {
		this.capability = capability;
	}

	/**
	 * get the 深度
	 * 
	 * @return level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * set the 深度
	 * 
	 * @param level
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * get the 深度编码
	 * 
	 * @return levelCode
	 */
	public String getLevelCode() {
		return levelCode;
	}

	/**
	 * set the 深度编码
	 * 
	 * @param levelCode
	 */
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

}