package com.irish.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class User {

    @NotBlank(message = "用户名不能为空")
    private String name;

    @Max(value = 120, message = "年龄不能超过120岁")
    private int age;

    @NotNull
    @Size(min = 8, max = 20, message = "密码必须大于8位并且小于20位")
    private String password;

    @Email(message = "请输入符合格式的邮箱")
    private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


    
}