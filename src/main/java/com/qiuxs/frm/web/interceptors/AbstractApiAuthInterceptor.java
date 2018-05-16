package com.qiuxs.frm.web.interceptors;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qiuxs.frm.base.bean.UserLite;
import com.qiuxs.frm.base.utils.ListUtils;
import com.qiuxs.frm.base.utils.RequestUtils;

/***
 * 
 * 功能描述: 接口认证基类<br/>
 * 新增原因: TODO<br/>
 * 新增日期: 2018年4月23日 下午11:03:09 <br/>
 * 
 * @author qiuxs
 * @version 1.0.0
 */
public abstract class AbstractApiAuthInterceptor extends AbstractHandlerInterceptor {

	public static final String DEFAULT_LOGIN_API_PATH = "/api/login";

	@Override
	public final boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		this.getUserLite(request, RequestUtils.getRequestParams(request));
		return super.preHandle(request, response, handler);
	}

	@Override
	public final int getOrder() {
		return AbstractHandlerInterceptor.PRIORITY_MIDDLE;
	}

	/**
	 * 获取登陆api地址，用于对登陆接口忽略权限及会话验证
	 * 
	 * @author qiuxs
	 * @return
	 */
	protected String getLoginApiPath() {
		return DEFAULT_LOGIN_API_PATH;
	}

	@Override
	public final Optional<List<String>> getExcludes() {
		return ListUtils.genList(getLoginApiPath());
	}

	protected abstract UserLite getUserLite(HttpServletRequest request, Map<String, String> params);
}
