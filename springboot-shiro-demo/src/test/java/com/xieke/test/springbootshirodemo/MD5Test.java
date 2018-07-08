package com.xieke.test.springbootshirodemo;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class MD5Test {

    @Test
    public void testMD5(){

        //原始密码：
        String source = "123456";

        //盐
        String salt = "80424d4bf4f8d78869f4709513329595";

        //散列次数
        int hashIterations = 2;

        //第1个参数：散列算法
        //第2个参数：明文，原始密码
        //第3个参数：盐，通过使用随机数
        //第4个参数：散列的次数，比如散列两次
        SimpleHash simpleHash = new SimpleHash("md5", source, "test"+salt, hashIterations);
        System.out.println(simpleHash.toString());
    }
}
