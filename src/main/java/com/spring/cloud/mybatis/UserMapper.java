package com.spring.cloud.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

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
	
	/**
	 * xml 配置映射
	 * @return
	 */
	//@ResultMap("result")
	@Select("SELECT u.id,u.NAME,u.gender,u.age,ur.company,ur.company_id FROM user u inner join user_relation ur on u.id=ur.user_id")
	List<User> findAll2();
	
	/**
	 * xml 配置映射
	 * @return
	 */
	List<User> findAll3();
	
	@Results(
			@Result(column="company_id", property="relationId")
		)
	@Select("SELECT * FROM user_relation where company_id=#{company_id}")
	List<UserRelation> findUserRelation(Integer company_id);
	
	/**
	 * 注解 映射
	 * @return
	 */
	@Results(
			@Result(column="company_id", property="relationId")
		)
	@Select("SELECT * FROM user_relation where user_id=#{user_id}")
	List<UserRelation> findUserRelationByUserId(Integer user_id);
	@Results({
			@Result(property="userRelations", column="id", many=@Many(select="com.spring.cloud.mybatis.UserMapper.findUserRelationByUserId", fetchType=FetchType.LAZY))
	})
	@Select("SELECT * FROM user")
	List<User> findAll4(Integer id);
	
}
