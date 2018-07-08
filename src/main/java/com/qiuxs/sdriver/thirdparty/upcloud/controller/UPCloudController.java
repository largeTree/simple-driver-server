package com.qiuxs.sdriver.thirdparty.upcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.core.basic.utils.JsonUtils;
import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.BaseController;
import com.qiuxs.sdriver.thirdparty.upcloud.config.UPCloudConfiguration;

@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/upcloud", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class UPCloudController extends BaseController {

	@Resource
	private UPCloudConfiguration upcloudConfig;

	@GetMapping("/exportcfg")
	public String exportConfig() {
		return JsonUtils.toJSONString(this.upcloudConfig);
	}
	
}
