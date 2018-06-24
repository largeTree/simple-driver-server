package com.qiuxs.sdriver.biz.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiuxs.cuteframework.core.persistent.database.modal.BaseField;
import com.qiuxs.cuteframework.core.persistent.database.modal.PropertyWrapper;
import com.qiuxs.cuteframework.core.persistent.database.service.AbstractDataService;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.IServiceFilter;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.impl.IdGenerateFilter;
import com.qiuxs.sdriver.biz.dao.UserDao;
import com.qiuxs.sdriver.biz.entity.User;
import com.qiuxs.sdriver.biz.service.IUserService;

/**
 * 服务类
 *
 * @author qiuxs
 *
 */
@Service
public class UserServiceImpl extends AbstractDataService<Long, User, UserDao> implements IUserService {

	private static final String TABLE_NAME = "user";

	public UserServiceImpl() {
		super(Long.class, User.class, TABLE_NAME);
	}

	@Resource
	private UserDao userDao;

	@Override
	protected UserDao getDao() {
		return this.userDao;
	}

	@Override
	public User getByBizKeys(String code) {
		return this.getDao().getByBizKeys(code);
	}
	
	@Override
	public String getCaption(Long code) {
		User user = this.getById(code);
		if (user != null) {
			return user.getName();
		}
		return String.valueOf(code);
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, User>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "主键", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("code", "登陆名", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("name", "用户名", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("password", "密码", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("sign", "个性签名", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("createdTime", "创建日期", Date.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("updatedTime", "更新日期", Date.class), null);
		props.add(prop);

	}

}
