package com.qiuxs.salbum.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.frm.web.controller.AbstractDataController;
import com.qiuxs.salbum.biz.dao.AlbumDao;
import com.qiuxs.salbum.biz.entity.Album;
import com.qiuxs.salbum.biz.service.AlbumService;

@RestController
public class AlbumController extends AbstractDataController<Long,Album,AlbumDao,AlbumService> {
	
	@Resource
	private AlbumService albumService;

	@Override
	protected AlbumService getService() {
		return this.albumService;
	}

}
