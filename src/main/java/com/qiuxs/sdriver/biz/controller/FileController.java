package com.qiuxs.sdriver.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

import com.qiuxs.sdriver.biz.dao.FileDao;
import com.qiuxs.sdriver.biz.entity.File;
import com.qiuxs.sdriver.biz.service.FileService;

/**
 * 控制器
 *
 * @author qiuxs
 *
 */
@RestController
@RequestMapping(value = "/api/file", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class FileController extends AbstractDataController<Long, File, FileDao, FileService> {

	@Resource
	private FileService fileService;

	@Override
	protected FileService getService() {
		return this.fileService;
	}

}