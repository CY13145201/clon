package com.xieke.test.springbootactivemqdemo.web;

import com.xieke.test.springbootactivemqdemo.jms.Producer;
import com.xieke.test.springbootactivemqdemo.jms.Publisher;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.jms.Destination;

/**
 * 测试ActiveMQ
 *
 * @author: jun hu
 * @date: 2018/6/4 15:00
 * @since: 1.0.0
 */
@RestController
@RequestMapping(value ="/mq")
public class TestMqController {

    @Autowired
    private Producer producer;
    @Autowired
    private Publisher publisher;

    @GetMapping(value = "/test1")
    public String testOne() {
        Destination destination = new ActiveMQQueue("mytest.queue");
        for(int i=0; i<100; i++){
            producer.sendMessage(destination, "my name is xieke！");
        }
        return "发送完成！";
    }

    @GetMapping(value = "/test2")
    public String testTwo() {
        for(int i=0; i<100; i++){
            publisher.publish("test.topic", "my name is xieke！");
        }
        return "发送完成！";
    }

}