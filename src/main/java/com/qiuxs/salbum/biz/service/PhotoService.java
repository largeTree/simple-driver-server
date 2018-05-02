package com.qiuxs.salbum.biz.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiuxs.frm.persistent.service.AbstractDataService;
import com.qiuxs.salbum.biz.dao.PhotoDao;
import com.qiuxs.salbum.biz.entity.Photo;

@Service
public class PhotoService extends AbstractDataService<Long, Photo, PhotoDao> {

	@Resource
	private PhotoDao photoDao;

	public PhotoService() {
		super(Long.class, Photo.class);
	}

	@Override
	protected PhotoDao getDao() {
		return this.photoDao;
	}

}
