package com.qiuxs.sdriver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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
// SpringBoot 默认仅扫面当前包及子包下的类，如果在其他包下存在需要扫面的类 则需要手动指定
@ComponentScan(basePackages = { "com.qiuxs" })
@MapperScan(basePackages = { "com.qiuxs" })
public class SimpleAlbumApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleAlbumApplication.class, args);
	}
}
