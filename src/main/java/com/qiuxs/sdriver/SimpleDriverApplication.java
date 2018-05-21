package com.qiuxs.sdriver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qiuxs.cuteframework.core.AbstractApplicationStarter;

/**
 * 
 * 功能描述: 程序入口类<br/>
 * 新增原因: TODO<br/>
 * 新增日期: 2018年4月23日 下午10:25:07 <br/>
 * 
 * @author qiuxs
 * @version 1.0.0
 */
@SpringBootApplication
public class SimpleDriverApplication extends AbstractApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(SimpleDriverApplication.class, args);
	}
}
