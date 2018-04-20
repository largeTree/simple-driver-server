package com.qiuxs.frm.base.utils;

import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.qiuxs.frm.base.ex.LogicException;

public class ExceptionUtils {

	public static final int DEFAULT_ERROR_CODE = -10;

	/**
	 * 使用指定的错误代码抛出逻辑异常
	 * @param errorCode
	 * @param msg
	 */
	public static void throwLogicalException(int errorCode, String msg) {
		throw new LogicException(errorCode, msg);
	}

	/**
	 * 抛出逻辑异常
	 * 
	 * @param msg
	 */
	public static void throwLogicalException(String msg) {
		throwLogicalException(DEFAULT_ERROR_CODE, msg);
	}

	/**
	 * 记录错误日志
	 * 
	 * @param log
	 * @param e
	 * @return
	 */
	public static JSONObject logError(Logger log, Throwable e) {
		JSONObject error = buildError(e);
		if (log != null) {
			log.error(error.getString("error_code"), e);
		}
		return error;
	}

	/**
	 * 获取错误详情
	 * 
	 * @param e
	 * @return
	 */
	public static JSONObject buildError(Throwable e) {
		JSONObject error = new JSONObject();
		e = getRtootThrowable(e);
		if (e instanceof LogicException) {
			error.put("error_code", ((LogicException) e).getErrorCode());
			error.put("msg", e.getLocalizedMessage());
		} else {
			int errorCode = genErrorCode();
			error.put("msg", "服务端错误：" + errorCode);
		}
		return error;
	}

	/**
	 * 生成错误代码
	 * 
	 * @return
	 */
	private static int genErrorCode() {
		return (int) ((Math.random() * 9 + 1) * 100000);
	}

	/**
	 * 获取最原始的异常对象
	 * 
	 * @param e
	 * @return
	 */
	private static Throwable getRtootThrowable(Throwable e) {
		if (e.getCause() == null) {
			return e;
		}
		for (;;) {
			if (e.getCause() == null) {
				return e;
			} else {
				e = e.getCause();
			}
		}
	}

}
