/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户信息实体类
 */
public class User implements Serializable {
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
	
	private static final long serialVersionUID = -7436176488326500800L;
	//注册时间
	private String registerTime=dateFormat.format(date);
	@NotBlank(message = "*用户名不能为空")
	private String username;
	@NotBlank(message = "*密码不能为空")
	private String password;
	private String passwordtwo;
	@Email(message = "*邮箱格式错误")
	@NotBlank(message = "*邮箱不能为空")
	private String email;
	private String gender;
	private String birthday;
	private String phone;
	private String address;
	private String personal;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param emil the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * @return the personal
	 */
	public String getPersonal() {
		return personal;
	}
	
	/**
	 * @param personal the personal to set
	 */
	public void setPersonal(String personal) {
		this.personal = personal;
	}
	
	public String getPasswordtwo() {
		return passwordtwo;
	}
	
	public void setPasswordtwo(String passwordtwo) {
		this.passwordtwo = passwordtwo;
	}
	
	public String getRegisterTime() {
		return registerTime;
	}
	
	public void setRegisterTime(String registerTime) {
		
		this.registerTime = registerTime;
	}
}
