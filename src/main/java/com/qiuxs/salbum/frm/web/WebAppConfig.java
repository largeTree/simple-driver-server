package com.qiuxs.salbum.frm.web;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 *
 * 功能描述: Web配置工具类<br/>  
 * 新增原因: TODO<br/>  
 * 新增日期: 2018年4月15日 下午8:53:52 <br/>  
 *  
 * @author qiuxs   
 * @version 1.0.0
 */
public class WebAppConfig extends WebMvcConfigurationSupport {

	private static List<InterceptorWrapper> interceptors = new LinkedList<>();

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		if (interceptors.size() > 0) {
			for (InterceptorWrapper wrapper : interceptors) {
				InterceptorRegistration registration = registry.addInterceptor(wrapper.getInterceotor());
				if (wrapper.getPathPatterns() == null || wrapper.getPathPatterns().length == 0) {
					continue;
				}
				registration.addPathPatterns(wrapper.getPathPatterns());
				if (wrapper.getExcludePathPatterns() != null) {
					registration.excludePathPatterns(wrapper.getExcludePathPatterns());
				}
			}
		}
	}

	public static class InterceptorWrapper {
		private HandlerInterceptor interceotor;
		private String[] pathPatterns;
		private String[] excludePathPatterns;

		public InterceptorWrapper(HandlerInterceptor interceptor, String[] pathPatterns) {
			this.interceotor = interceptor;
			this.pathPatterns = pathPatterns;
		}

		public InterceptorWrapper(HandlerInterceptor interceptor, String[] pathPatterns, String[] excludePathPatterns) {
			this.interceotor = interceptor;
			this.pathPatterns = pathPatterns;
			this.excludePathPatterns = excludePathPatterns;
		}

		public HandlerInterceptor getInterceotor() {
			return interceotor;
		}

		public void setInterceotor(HandlerInterceptor interceotor) {
			this.interceotor = interceotor;
		}

		public String[] getPathPatterns() {
			return pathPatterns;
		}

		public void setPathPatterns(String[] pathPatterns) {
			this.pathPatterns = pathPatterns;
		}

		public String[] getExcludePathPatterns() {
			return excludePathPatterns;
		}

		public void setExcludePathPatterns(String[] excludePathPatterns) {
			this.excludePathPatterns = excludePathPatterns;
		}

	}

}
