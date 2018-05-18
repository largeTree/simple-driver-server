package com.qiuxs.frm.base.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtils {

	public static JSONObject toJSONObject(Object obj) {
		return (JSONObject) JSON.toJSON(obj);
	}

	public static JSONArray toJSONArray(Object arr) {
		return (JSONArray) JSON.toJSON(arr);
	}

	public static String toJSONString(Object obj) {
		return JSONObject.toJSONString(obj,
		        SerializerFeature.IgnoreNonFieldGetter,
		        SerializerFeature.WriteNonStringKeyAsString,
		        SerializerFeature.WriteDateUseDateFormat, // 日期输出成"yyyy-MM-dd HH:mm:ss"格式
		        SerializerFeature.DisableCircularReferenceDetect);
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

	public static Object genJSON(Object... obj) {
		if (obj == null || obj.length == 0) {
			return null;
		}
		JSONObject json = new JSONObject();
		for (int i = 0; i < obj.length; i += 2) {
			json.put(String.valueOf(obj[i]), obj[+1]);
		}
		return json;
	}
}
