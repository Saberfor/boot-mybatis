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
	
	public List<User> listUser2(){
		return mapper.findAll2();
	}
	
	public List<User> listUser3(){
		return mapper.findAll3();
	}
	
	public List<User> listUser4(Integer id){
		return mapper.findAll4(id);
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
	
	public List<UserRelation> findUserRelation(Integer company_id){
		return mapper.findUserRelation(company_id);
	}
}
