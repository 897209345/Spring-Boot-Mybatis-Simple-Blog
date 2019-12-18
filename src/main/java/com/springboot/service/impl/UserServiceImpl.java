/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.service.impl;

import com.springboot.bean.User;
import com.springboot.mapper.UserMapper;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Administrator
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public int add(User user) {
		return this.userMapper.add(user);
	}

	@Override
	public int update(User user) {
		return this.userMapper.update(user);
	}

	@Override
	public int deleteByUsername(String username) {
		return this.userMapper.deleteByUsername(username);
	}

	@Override
	public User queryUserByUsername(String username) {
		return this.userMapper.queryUserByUsername(username);
	}

	@Override
	public List<User> findAllList() {
		return this.userMapper.findAllList();
	}

	@Override
	public User checkUser(User user) {
		return this.userMapper.checkUser(user);
	}

}
