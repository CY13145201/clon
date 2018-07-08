package com.xieke.test.springbootshirodemo.sevice;


import com.xieke.test.springbootshirodemo.entity.UserInfo;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}