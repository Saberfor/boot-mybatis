package com.spring.cloud.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper; 
	
	public List<User> listUser(){
		return mapper.findAll();
	}
	
	public int addUser(User user){
		return mapper.addUser(user);
	}
	
	public void deleteUser(User user){
		mapper.deleteUser(user);
	}
	
	public void updateUser(User user){
		mapper.updateUser(user);
	}
	
	public User findById(User user){
		return mapper.findById(user);
	}
}
