/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.service;

import com.springboot.bean.User;

import java.util.List;

/**
 *
 * @author Administrator
 */
public interface UserService {
	int add(User user);

	int update(User user);

	int deleteByUsername(String username);

	User queryUserByUsername(String username);

	User checkUser(User user);

	List<User> findAllList();
}
