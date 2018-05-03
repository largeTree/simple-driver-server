package com.qiuxs.frm.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.qiuxs.frm.context.ThreadLocalVariableHolder;

/**
 * 功能描述: 请求开始和结束时清理一下线程变量<br/>  
 * 新增原因: TODO<br/>  
 * 新增日期: 2018年4月23日 下午9:59:38 <br/>  
 *  
 * @author qiuxs   
 * @version 1.0.0
 */
public class ThreadLocalVariableInterceptor extends AbstractHandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		ThreadLocalVariableHolder.clear();
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		ThreadLocalVariableHolder.clear();
	}

	@Override
	public int getOrder() {
		// 优先级设置为高
		return AbstractHandlerInterceptor.PRIORITY_HIGH;
	}

}
