package com.xieke.test.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="用户对象user")
public class User {

    @ApiModelProperty(value="用户ID",name="id")
    private Long id;
    @ApiModelProperty(value="用户名",name="name")
    private String name;
    @ApiModelProperty(value="年  龄",name="age")
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
