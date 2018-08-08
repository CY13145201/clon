package com.xieke.test.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.xieke.test.demo.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisDemoApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void testOne() throws Exception {
		// 保存字符串
		stringRedisTemplate.opsForValue().set("xieke", "66666");
		Assert.assertEquals("66666",
				stringRedisTemplate.opsForValue().get("xieke"));
	}

	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	@Test
	public void testTwo() throws Exception {

		// 保存对象
		User user = new User("超人", 20);
		redisTemplate.opsForValue().set(user.getUserName(), user);

		user = new User("蝙蝠侠", 30);
		redisTemplate.opsForValue().set(user.getUserName(), user);

		user = new User("蜘蛛侠", 40);
		redisTemplate.opsForValue().set(user.getUserName(), user);

		Assert.assertEquals(20, redisTemplate.opsForValue().get("超人")
				.getUserAge().longValue());
		Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠")
				.getUserAge().longValue());
		Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠")
				.getUserAge().longValue());

	}

}