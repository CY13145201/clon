package com.xieke.test.springbootshirodemo;

import com.xieke.test.springbootshirodemo.util.PasswordEncoder;
import org.junit.Test;

public class PasswordEncoderTest {

    @Test
    public void testEncode(){
        String salt = PasswordEncoder.createSalt(32);
        System.out.println("salt:"+salt);
        PasswordEncoder passwordEncoder = new PasswordEncoder(salt);
        String pwd = passwordEncoder.encode("123456");
        System.out.println("pwd:"+pwd);
        System.out.println("验证结果:"+passwordEncoder.isPasswordValid(pwd,"123456"));
    }

}