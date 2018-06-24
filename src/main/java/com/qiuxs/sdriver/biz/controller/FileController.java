package com.qiuxs.sdriver.biz.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;
import com.qiuxs.sdriver.biz.dao.FileDao;
import com.qiuxs.sdriver.biz.dto.FileFullFDTO;
import com.qiuxs.sdriver.biz.entity.File;
import com.qiuxs.sdriver.biz.service.IFileService;

/**
 * 控制器
 *
 * @author qiuxs
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/file", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class FileController extends AbstractDataController<Long, File, FileDao, IFileService> {

	@Resource
	private IFileService fileService;

	@Override
	protected IFileService getService() {
		return this.fileService;
	}

	@PostMapping("/createFull")
	public String saveFull(Map<String, String> params, @RequestParam("jsonParam") String jsonData) {
		FileFullFDTO fileFullDto = this.getService().fromJSONDTO(jsonData);
		this.getService().createFull(fileFullDto);
		return super.responseVal(fileFullDto.getFile().getId());
	}

}
