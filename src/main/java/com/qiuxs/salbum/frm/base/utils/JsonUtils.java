package com.qiuxs.salbum.frm.base.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtils {

	public static JSONObject toJSONObject(Object obj) {
		return (JSONObject) JSON.toJSON(obj);
	}

	public static JSONArray toJSONArray(Object arr) {
		return (JSONArray) JSON.toJSON(arr);
	}

	public static String toJSONString(Object obj) {
		return toJSONObject(obj).toJSONString();
	}

	public static JSONObject parseJSONObject(String str) {
		return JSON.parseObject(str);
	}

	public static JSONArray parseJSONArray(String str) {
		return JSON.parseArray(str);
	}

	public static <T> T parseObject(String str, Class<T> clz) {
		return JSON.parseObject(str, clz);
	}

	public static <T> List<T> parseArray(String str, Class<T> clz) {
		return JSON.parseArray(str, clz);
	}
}
