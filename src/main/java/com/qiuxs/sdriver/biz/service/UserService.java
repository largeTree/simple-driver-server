package com.qiuxs.sdriver.biz.service;

import java.util.List;
import javax.annotation.Resource;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.qiuxs.cuteframework.core.persistent.modal.PropertyWrapper;
import com.qiuxs.cuteframework.core.basic.bean.UserLite;
import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.persistent.modal.BaseField;
import com.qiuxs.cuteframework.core.persistent.service.AbstractDataService;
import com.qiuxs.cuteframework.core.persistent.service.filter.IServiceFilter;
import com.qiuxs.cuteframework.core.persistent.service.filter.impl.IdGenerateFilter;
import com.qiuxs.sdriver.biz.dao.UserDao;
import com.qiuxs.sdriver.biz.entity.User;

/**
 * 服务类
 *
 * @author qiuxs
 *
 */
@Service
public class UserService extends AbstractDataService<Long, User, UserDao> {

	private static final String TABLE_NAME = "user";

	public UserService() {
		super(Long.class, User.class, TABLE_NAME);
	}

	@Resource
	private UserDao userDao;

	@Override
	protected UserDao getDao() {
		return this.userDao;
	}

	public UserLite login(String userCode, String password) {
		User user = this.getByBizKeys(userCode);
		if (user == null) {
			ExceptionUtils.throwLogicalException("user_is_not_exists", userCode);
		}
		return null;
	}

	public User getByBizKeys(String code) {
		return this.getDao().getByBizKeys(code);
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, User>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "主键", "Long"), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("code", "登陆名", "String"), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("name", "用户名", "String"), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("password", "密码", "String"), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("sign", "个性签名", "String"), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("createdTime", "创建日期", "Date"), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("updatedTime", "更新日期", "Date"), null);
		props.add(prop);

	}

}
