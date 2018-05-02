package com.qiuxs.frm.context;

import com.qiuxs.frm.ThreadLocalVariableHolder;
import com.qiuxs.frm.base.bean.UserLite;
import com.qiuxs.frm.base.utils.ExceptionUtils;

/**
 * 
 * 功能描述: 回话上下文<br/>  
 * 新增原因: TODO<br/>  
 * 新增日期: 2018年4月23日 下午10:42:09 <br/>  
 *  
 * @author qiuxs   
 * @version 1.0.0
 */
public class UserContext {

	private static final String TL_USER_LITE = "tl_user_lite";

	/**
	 * 设置当前线程的会话信息
	 *  
	 * @author qiuxs  
	 * @param userLite
	 */
	public static void setUserLite(UserLite userLite) {
		ThreadLocalVariableHolder.setVariable(TL_USER_LITE, userLite);
	}

	/**
	 * 获取当前线程的会话信息
	 *  
	 * @author qiuxs  
	 * @return
	 */
	public static UserLite getUserList() {
		return getUserLite(false);
	}

	/**
	 * 获取当前线程回话信息
	 *  
	 * @author qiuxs  
	 * @param ignoreException
	 * 		会话无效时是否抛出异常
	 * @return
	 */
	public static UserLite getUserLite(boolean ignoreException) {
		UserLite userLite = getUserLiteInner();
		if (!ignoreException && userLite == null) {
			ExceptionUtils.throwLoginException();
		}
		return userLite;
	}

	/**
	 * 内部调用
	 *  
	 * @author qiuxs  
	 * @return
	 */
	private static UserLite getUserLiteInner() {
		return ThreadLocalVariableHolder.getVariable(TL_USER_LITE);
	}
}
