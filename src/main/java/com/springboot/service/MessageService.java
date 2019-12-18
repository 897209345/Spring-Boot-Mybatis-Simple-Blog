package com.springboot.service;

import com.springboot.bean.Message;

import java.util.List;

public interface MessageService {
	
	int add(Message message);
	
	int update(Message message);
	
	int deleteByMessageId(String messageId);
	
	Message queryByMessageId(String messageId);
	
	List<Message> queryMessagesByUsername(String username);
	
	List<Message> findAllList();
}
