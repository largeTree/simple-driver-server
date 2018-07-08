package com.qiuxs.sdriver.thirdparty.upcloud.config;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.qiuxs.cuteframework.core.basic.Constants;
import com.qiuxs.cuteframework.core.basic.utils.security.MD5Util;
import com.qiuxs.cuteframework.core.basic.utils.security.SecurityUtil;

/**
 * 又拍云帮助类
 * 
 * @author qiuxs
 *
 */

@Component
@ConfigurationProperties(prefix = MybatisProperties.MYBATIS_PREFIX)
public class UPCloudConfiguration {

	public static final String Authorization_PREFIX = "UPYUN";

	public static final String METHOD_HEAD = "HEAD";
	public static final String METHOD_GET = "GET";
	public static final String METHOD_PUT = "PUT";
	public static final String METHOD_POST = "POST";
	public static final String METHOD_DELETE = "DELETE";

	/** 密码Md5值 */
	private String passwordMd5;
	/** 操作员 */
	private String operator;
	/** 密码 */
	private String password;
	/** 服务名 */
	private String bucket;

	/**
	 * 获取操作员
	 * 
	 * @return
	 */
	public String getOperator() {
		return this.operator;
	}

	/**
	 * 获取操作员密码
	 * 
	 * @return
	 */
	private String getPassword() {
		return this.password;
	}

	/**
	 * 获取当前服务
	 * 
	 * @return
	 */
	public String getBucket() {
		return this.bucket;
	}

	/**
	 * 获取密码的Md5值
	 * 
	 * @return
	 */
	public String getPasswordMd5() {
		if (StringUtils.isBlank(passwordMd5)) {
			passwordMd5 = MD5Util.MD5Encode(getPassword(), Constants.UTF_8);
		}
		return passwordMd5;
	}

	/**
	 * 生成参数清单
	 * 
	 * @param bucket
	 * @param saveKey
	 * @param expiration
	 * @param date
	 * @return
	 */
	public String getPolicy(String bucket, String saveKey, String expiration, String date, String contentMd5) {
		JSONObject params = new JSONObject();
		params.put("bucket", bucket);
		params.put("save-key", saveKey);
		params.put("expiration", expiration);
		params.put("date", date);
		if (contentMd5 != null) {
			params.put("content-md5", contentMd5);
		}
		String jsonString = params.toJSONString();
		return Base64.encodeBase64String(jsonString.getBytes(Charset.forName(Constants.UTF_8)));
	}

	/**
	 * 生成Authorization
	 * 
	 * @param method
	 * @param uri
	 * @param date
	 * @param contentMd5
	 * @return
	 */
	public String getAuthorization(String method, String uri, String date, String policy, String contentMd5) {
		return Authorization_PREFIX + " " + getOperator() + ":" + getSignature(method, uri, date, policy, contentMd5);
	}

	/**
	 * 生成签名
	 * 
	 * @param method
	 * @param uri
	 * @param date
	 * @param contentMd5
	 * @return
	 */
	private String getSignature(String method, String uri, String date, String policy, String contentMd5) {
		StringBuilder sb = new StringBuilder();
		sb.append(method)
		  .append("&").append(uri)
		  .append("&").append(date)
		  .append("&").append(policy);
		if (StringUtils.isNotBlank(contentMd5)) {
			sb.append("&").append(contentMd5);
		}
		return Base64.encodeBase64String(SecurityUtil.hmacSHA1EncryptBytes(sb.toString(), getPasswordMd5()));
	}

	/**
	 * 接入点枚举
	 * 
	 * @author qiuxs
	 *
	 */
	public enum ApiDomain {

		/** 自动节点 */
		AUTO("v0.api.upyun.com"),
		/** 中国电信 */
		CHINA_NET("v1.api.upyun.com"),
		/** 联通（网通） */
		LT("v2.api.upyun.com"),
		/** 移动（铁通） */
		TT("v3.api.upyun.com");

		/** 地址值 */
		private String value;

		ApiDomain(String val) {
			this.value = val;
		}

		@Override
		public String toString() {
			return this.value;
		}
	}

}
