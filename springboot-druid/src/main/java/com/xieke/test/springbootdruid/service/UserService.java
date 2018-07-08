package com.xieke.test.springbootdruid.service;

import com.xieke.test.springbootdruid.entity.User;
import com.xieke.test.springbootdruid.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepositoty userRepositoty;

    public User findUserByName(String name){
        User user = null;
        try{
            user = userRepositoty.findByUserName(name);
        } catch (Exception e){

        }
        return user;
    }

    public User  findUserById (Long id){
        User user = null;
        try{
            user = userRepositoty.getOne(id);
        } catch (Exception e){

        }
        return user;
    }
}