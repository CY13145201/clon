package com.xieke.test.springbootactivemqdemo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * 发布/订阅模式
 *
 * 订阅话题
 */
@Service
public class Subscriber {

    @JmsListener(destination = "test.topic" , containerFactory = "myJmsContainerFactory")
    public void subscribe(String text) {
        System.out.println("===========收到订阅的消息：" + text);
    }  
} 