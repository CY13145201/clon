package com.xieke.test.springbootjwtdemo.web;

import com.xieke.test.springbootjwtdemo.config.Const;
import com.xieke.test.springbootjwtdemo.util.JwtHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password){

        //模拟登录成功
        String jwt = JwtHelper.createJWT(username, "", "", "", "", Const.EXP_MILLIS, Const.BASE64_SECRET);

        return jwt;
    }

    @RequestMapping("/index")
    @ResponseBody
    public Object index(HttpServletRequest request){

        return request.getAttribute(Const.CLAIMS);
    }

}