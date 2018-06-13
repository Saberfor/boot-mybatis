package com.spring.cloud.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
	
	@Insert("INSERT INTO user(NAME,gender,age) VALUES (#{name},#{gender},#{age})")
	//@Options(useGeneratedKeys = true,s keyProperty = "id", keyColumn = "id")
	int addUser(User user);
	
	@Delete("DELETE FROM user WHERE id = #{id}")
	void deleteUser(User user);
	
	@Update("UPDATE user SET NAME = #{name},gender=#{gender},age=#{age} WHERE id = #{id}")
	void updateUser(User user);
	
	@Select("SELECT * FROM user WHERE id = #{id}")
	User findById(User user);
	
	@Select("SELECT * FROM user")
	List<User> findAll();
}
