package com.qiuxs.salbum.biz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.qiuxs.frm.persistent.entiry.AbstractEntity;

/**
 * 图片
 * 
 * @author qiuxs
 *
 */
@Entity
public class Photo extends AbstractEntity<Long> {

	private static final long serialVersionUID = 4641363577704971844L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** 照片描述 */
	private String description;

	/** 所有者ID */
	private Long ownerId;

	/** 存储路径 */
	private String path;

	/** 所属相册ID */
	private Long albumId;

	/** HashKey */
	private String hashKey;

	/** ID引用链 */
	private String chainId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public String getHashKey() {
		return hashKey;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}

	public String getChainId() {
		return chainId;
	}

	public void setChainId(String chainId) {
		this.chainId = chainId;
	}

}
