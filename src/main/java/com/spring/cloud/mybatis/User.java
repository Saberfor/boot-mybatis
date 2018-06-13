package com.spring.cloud.mybatis;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class User {
	private Integer id;
    private String name;
    private String gender;
    private Integer age;
    
    public User(String name, String gender, Integer age){
    	this.name = name;
    	this.gender = gender;
    	this.age = age;
    }
    
    public User() {
	}
}
