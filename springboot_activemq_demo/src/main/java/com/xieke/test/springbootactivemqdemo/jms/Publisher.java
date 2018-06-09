package com.xieke.test.springbootactivemqdemo.jms;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * 发布/订阅模式
 *
 * 发布话题
 */
@Service
public class Publisher {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;  

    public void publish(String destinationName, final String message){

        Destination destination = new ActiveMQTopic(destinationName);

        System.out.println("===========发布topic消息：" + message);

        jmsTemplate.convertAndSend(destination, message);  
    }

}  