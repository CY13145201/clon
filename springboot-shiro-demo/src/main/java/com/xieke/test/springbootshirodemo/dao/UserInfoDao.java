package com.xieke.test.springbootshirodemo.dao;

import com.xieke.test.springbootshirodemo.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao extends CrudRepository<UserInfo,Long> {
    /**通过username查找用户信息;*/
    UserInfo findByUsername(String username);
}