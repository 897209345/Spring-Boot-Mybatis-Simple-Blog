package com.springboot.service.impl;

import com.springboot.bean.Message;
import com.springboot.mapper.MessageMapper;
import com.springboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageMapper messageMapper;
	
	@Override
	public int add(Message message) {
		return this.messageMapper.add(message);
	}
	
	@Override
	public int update(Message message) {
		return this.messageMapper.update(message);
	}
	
	@Override
	public int deleteByMessageId(String messageId) {
		return this.messageMapper.deleteByMessageId(messageId);
	}
	
	@Override
	public Message queryByMessageId(String messageId) {
		return this.messageMapper.queryByMessageId(messageId);
	}
	
	@Override
	public List<Message> queryMessagesByUsername(String username) {
		return this.messageMapper.queryMessagesByUsername(username);
	}
	
	@Override
	public List<Message> findAllList() {
		return this.messageMapper.findAllList();
	}
}
