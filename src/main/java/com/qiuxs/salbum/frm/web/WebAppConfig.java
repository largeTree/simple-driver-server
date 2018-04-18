package com.qiuxs.salbum.frm.web;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.qiuxs.salbum.web.interceptors.ApiAuthInterceptor;

/**
 *
 * 功能描述: Web配置工具类<br/>
 * 新增原因: TODO<br/>
 * 新增日期: 2018年4月15日 下午8:53:52 <br/>
 * 
 * @author qiuxs
 * @version 1.0.0
 */
@Component
public class WebAppConfig extends WebMvcConfigurationSupport {

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ApiAuthInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/login");
	}

}
