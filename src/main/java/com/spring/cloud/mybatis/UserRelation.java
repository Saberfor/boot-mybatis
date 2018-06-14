package com.spring.cloud.mybatis;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserRelation {
	private Integer id;
    private Integer user_id;
    private String company;
    private Integer relationId;
    
    public UserRelation() {
	}
}
