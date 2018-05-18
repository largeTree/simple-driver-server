package com.qiuxs.sdriver.web.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.qiuxs.frm.base.bean.UserLite;
import com.qiuxs.frm.base.utils.MapUtils;
import com.qiuxs.frm.context.UserContext;
import com.qiuxs.frm.web.interceptors.AbstractApiAuthInterceptor;

/**
 * 权限控制拦截器
 * 
 * @author qiuxs
 *
 */
@Component
public class ApiAuthInterceptor extends AbstractApiAuthInterceptor {

	public static final String SESSION_ID = "sessionId";

	@Override
	protected UserLite getUserLite(HttpServletRequest request, Map<String, String> params) {
		// String sessionId = MapUtils.getStringMust(params, SESSION_ID);
		// UserLite userLite = UserContext.getUserLite(sessionId);
		return new UserLite();
	}

}
