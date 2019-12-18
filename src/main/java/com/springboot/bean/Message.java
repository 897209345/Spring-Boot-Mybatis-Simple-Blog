package com.springboot.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 留言板信息实体类
 */
public class Message {
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
	private int messageId=(int)(Math.random()*317927+1);
	private String username;
	private String messageField;
	private String messageTime=dateFormat.format(date);
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getMessageTime() {
		return messageTime;
	}
	
	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}
	
	public int getMessageId() {
		return messageId;
	}
	
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	
	public String getMessageField() {
		return messageField;
	}
	
	public void setMessageField(String messageField) {
		this.messageField = messageField;
	}
}
