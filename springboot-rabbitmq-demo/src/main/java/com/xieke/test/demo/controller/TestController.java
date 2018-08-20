package com.xieke.test.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xieke.test.demo.sender.Sender;

@RestController
public class TestController {

    @Autowired
    private Sender sender;

	@GetMapping("/hello")
    public String helloTest(){
        sender.send();
        return "success";
    }

}