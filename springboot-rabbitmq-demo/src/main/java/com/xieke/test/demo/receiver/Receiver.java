package com.xieke.test.demo.receiver;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "message")
public class Receiver {

	private Logger logger = LoggerFactory.getLogger(Receiver.class);

    @RabbitHandler
	public void process(String context) {
		logger.info("接收消息时间：" + new Date());
		logger.info("消息内容：" + context);
    }

}