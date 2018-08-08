package com.xieke.test.demo.pojo;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -1L;

	private String userName;

	private Integer userAge;

	public User(String userName, Integer userAge) {
		super();
		this.userName = userName;
		this.userAge = userAge;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

}