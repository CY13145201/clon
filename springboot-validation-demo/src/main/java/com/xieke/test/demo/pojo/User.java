package com.xieke.test.demo.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class User {

	private Integer id;

	@NotBlank(message = "{user.username.notblank.error}")
	private String userName;

	@Length(min = 6, max = 16, message = "{user.password.length.error}")
	private String passWord;

	@Email(message = "{user.email.email.error}")
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}