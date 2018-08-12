package com.xieke.test.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xieke.test.demo.pojo.User;
import com.xieke.test.demo.util.ValidateUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootManualValidationDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testValidate() {
		User user = new User();
		user.setUserName("458");
		user.setPassWord("786");
		user.setEmail("9999.com");
		System.err.println(ValidateUtils.valid(user));
		// for (String error : list) {
		// System.err.println(error);
		// }
	}

}