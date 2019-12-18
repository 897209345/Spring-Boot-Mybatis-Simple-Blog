/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.mapper;

import com.springboot.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
	@Insert("insert into user(registerTime,username,password,email) values(#{registerTime},#{username},#{password},#{email})")
	int add(User user);
	
	@Update("update user set email=#{email},gender=#{gender},birthday=#{birthday},phone=#{phone},address=#{address},personal=#{personal} where username=#{username}")
	int update(User user);
	
	@Delete("delete from user where username=#{username}")
	int deleteByUsername(String username);
	
	//当数据库字段和实体不一致时,需要用@Results来进行一一对应
	@Select("select * from user where username=#{username}")
//	@Results(id = "user", value = { @Result(property = "username", column = "username", javaType = String.class),
//			@Result(property = "password", column = "password", javaType = String.class),
//			@Result(property = "email", column = "email", javaType = String.class),
//			@Result(property = "gender", column = "gender", javaType = String.class),
//			@Result(property = "birthday", column = "birthday", javaType = String.class),
//			@Result(property = "phone", column = "phone", javaType = String.class),
//			@Result(property = "address", column = "address", javaType = String.class),
//			@Result(property = "personal", column = "personal", javaType = String.class) })
	User queryUserByUsername(String username);
	
	@Select("select * from user where username=#{username} and password=#{password}")
	User checkUser(User user);
	
	@Select("select * from user order by registerTime DESC")
	List<User> findAllList();
}
