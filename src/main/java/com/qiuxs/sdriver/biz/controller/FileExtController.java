package com.qiuxs.sdriver.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

import com.qiuxs.sdriver.biz.dao.FileExtDao;
import com.qiuxs.sdriver.biz.entity.FileExt;
import com.qiuxs.sdriver.biz.service.FileExtService;

/**
 * 控制器
 *
 * @author qiuxs
 *
 */
@RestController
@RequestMapping(value = "/api/fileext", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class FileExtController extends AbstractDataController<Long, FileExt, FileExtDao, FileExtService> {

	@Resource
	private FileExtService fileextService;

	@Override
	protected FileExtService getService() {
		return this.fileextService;
	}

}
