package com.xieke.test.demo.sender;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    private Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send(){
		String context = "世界，你好！";
		logger.info("消息发送时间：" + new Date());
		logger.info("消息内容：" + context);
        amqpTemplate.convertAndSend("message", context);
        return "发送成功";
    }

}