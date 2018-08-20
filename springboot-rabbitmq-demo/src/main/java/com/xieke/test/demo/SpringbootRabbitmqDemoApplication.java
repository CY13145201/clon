package com.xieke.test.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringbootRabbitmqDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqDemoApplication.class, args);
	}

	/**
	 * 消息队列声明
	 */
	@Bean
	public Queue messageQueue() {
		return QueueBuilder.durable("message").build();
	}

}