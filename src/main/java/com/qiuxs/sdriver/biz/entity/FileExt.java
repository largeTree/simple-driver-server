package com.qiuxs.sdriver.biz.entity;


import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;
import com.qiuxs.sdriver.biz.dto.IBaseFileExtDTO;

/**
 * 实体类
 *	for table file_ext
 * @author qiuxs
 *
 */

public class FileExt extends AbstractEntity<Long> implements IBaseFileExtDTO {

	private static final long serialVersionUID = -3405929277354712504L;

	/** 文件扩展名 */
	private String extName;

	/** 文件大小 */
	private Long size;


	/**
	 * get the 文件扩展名
	 * @return extName
	 */
	public String getExtName() {
		return this.extName;
	}

	/**
	 * set the 文件扩展名
	 * @param extName
	 */
	public void setExtName(String extName) {
		this.extName = extName;
	}

	/**
	 * get the 文件大小
	 * @return size
	 */
	public Long getSize() {
		return this.size;
	}

	/**
	 * set the 文件大小
	 * @param size
	 */
	public void setSize(Long size) {
		this.size = size;
	}

}