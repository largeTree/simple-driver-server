package com.qiuxs.salbum.biz.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiuxs.frm.persistent.service.AbstractDataService;
import com.qiuxs.salbum.biz.dao.AlbumDao;
import com.qiuxs.salbum.biz.entity.Album;

@Service
public class AlbumService extends AbstractDataService<Long, Album, AlbumDao> {

	public AlbumService() {
		super(Long.class, Album.class);
	}

	@Resource
	private AlbumDao albumDao;

	@Override
	protected AlbumDao getDao() {
		return this.albumDao;
	}

}
