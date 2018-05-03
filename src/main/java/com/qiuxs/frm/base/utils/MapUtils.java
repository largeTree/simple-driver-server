package com.qiuxs.frm.base.utils;

import java.util.Map;

public class MapUtils {

	/**
	 * 获取String值
	 * 
	 * @param map
	 * @param key
	 * @return
	 */
	public static String getString(Map<String, ?> map, String key) {
		return (String) map.get(key);
	}

	/**
	 * 获取String值，不存在时抛出异常
	 * @param map
	 * @param key
	 * @return
	 */
	public static String getStringMust(Map<String, ?> map, String key) {
		String val = getString(map, key);
		if (val == null) {
			ExceptionUtils.throwLogicalException("params [" + key + "] is required");
		}
		return val;
	}

}
