package com.xieke.test.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("/one")
    public String testOne() {
        return "世界你好！";
    }
    @GetMapping("/two")
    public String testTwo() {
        return "我很好！";
    }
}
