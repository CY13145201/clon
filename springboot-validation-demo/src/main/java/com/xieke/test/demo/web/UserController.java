package com.xieke.test.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xieke.test.demo.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/save")
	@ResponseBody
	public List<String> saveUser(@Validated
	User user, BindingResult bindingResult) {
		List<String> errorlList = new ArrayList<>();
        if(bindingResult.hasErrors()){
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errorlList.add(fieldError.getField() + "：" + fieldError.getDefaultMessage());
            }
        }
		return errorlList;
    }

}