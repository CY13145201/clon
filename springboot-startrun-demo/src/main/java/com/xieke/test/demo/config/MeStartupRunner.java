package com.xieke.test.demo.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.xieke.test.demo.service.TestService;

/**
 * 服务启动执行
 * 
 * 多个通过指定order的值来确定执行顺序
 * 
 * @author jun hu
 * 
 */
@Component
@Order(1)
public class MeStartupRunner implements CommandLineRunner {
	@Autowired
	private TestService testService;
	
	public void run(String... arg0) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>MeStartupRunner 服务启动执行start<<<<<<<<<<<<<");
		System.out.println(testService.queryBy("MeStartupRunner 服务启动执行成功！"));
		System.out.println(">>>>>>>>>>>>>>>MeStartupRunner 服务启动执行  end <<<<<<<<<<<<<");
	}
 
}