package com.qiuxs.frm.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.qiuxs.frm.context.ApplicationContextHolder;
import com.qiuxs.frm.web.interceptors.AbstractApiAuthInterceptor;
import com.qiuxs.frm.web.interceptors.AbstractHandlerInterceptor;
import com.qiuxs.frm.web.interceptors.ThreadLocalVariableInterceptor;

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
		// 线程变量拦截器
		ThreadLocalVariableInterceptor threadLocalVariableInterceptor = new ThreadLocalVariableInterceptor();
		registry.addInterceptor(threadLocalVariableInterceptor).addPathPatterns("/**").order(threadLocalVariableInterceptor.getOrder());
		// 添加会话拦截器
		Optional<AbstractApiAuthInterceptor> apiAuthInterceptor = Optional.ofNullable(ApplicationContextHolder.getBean(AbstractApiAuthInterceptor.class));
		apiAuthInterceptor.ifPresent((interceptor) -> {
			registry.addInterceptor(interceptor).addPathPatterns("/api/**").excludePathPatterns(interceptor.getLoginApiPath()).order(interceptor.getOrder());
		});

		Optional<List<AbstractHandlerInterceptor>> customerHandlerInterceptors = getCustomerHandlerInterceptors();
		customerHandlerInterceptors.ifPresent((interceptors) -> {
			
		});
	}

	private Optional<List<AbstractHandlerInterceptor>> getCustomerHandlerInterceptors() {
		String[] handlerInterceptorNames = ApplicationContextHolder.getBeanNamesForType(AbstractHandlerInterceptor.class);
		List<AbstractHandlerInterceptor> handlerInterceptors = null;
		int size = handlerInterceptorNames.length;
		if (size > 0) {
			handlerInterceptors = new ArrayList<>(size);
			for (String name : handlerInterceptorNames) {
				handlerInterceptors.add((AbstractHandlerInterceptor) ApplicationContextHolder.getBean(name));
			}
		}
		return Optional.ofNullable(handlerInterceptors);
	}

}
