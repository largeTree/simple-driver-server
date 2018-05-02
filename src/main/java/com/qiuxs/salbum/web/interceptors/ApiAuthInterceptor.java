package com.qiuxs.salbum.web.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.qiuxs.frm.base.bean.UserLite;
import com.qiuxs.frm.web.interceptors.AbstractApiAuthInterceptor;

/**
 * 权限控制拦截器
 * @author qiuxs
 *
 */
@Component
public class ApiAuthInterceptor extends AbstractApiAuthInterceptor {

	@Override
	protected UserLite getUserLite(HttpServletRequest request, Map<String, String> params) {
		return null;
	}

}
