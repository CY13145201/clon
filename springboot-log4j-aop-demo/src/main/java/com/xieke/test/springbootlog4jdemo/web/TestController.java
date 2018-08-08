package com.xieke.test.springbootlog4jdemo.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

	private final static Logger logger = Logger.getLogger(TestController.class);

	@RequestMapping("/index1")
	@ResponseBody
	public String index1() {
		logger.info("=====================index1 info=======================");
		return "index1";
	}

	@RequestMapping("/index2")
	@ResponseBody
	public String index2() {
		logger.error("=====================index2 error=======================");
		return "index2";
	}

}