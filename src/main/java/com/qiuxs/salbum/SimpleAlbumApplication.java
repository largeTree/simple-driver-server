package com.qiuxs.salbum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

import com.qiuxs.frm.persistent.dao.IBaseDao;

@SpringBootApplication
@ComponentScan(excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, value = IBaseDao.class))
public class SimpleAlbumApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleAlbumApplication.class, args);
	}
}
