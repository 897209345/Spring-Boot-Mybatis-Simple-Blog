package com.springboot.mapper;

import com.springboot.bean.Message;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MessageMapper {
	@Insert("insert into message(messageId,username,messageField,messageTime) values(#{messageId},#{username},#{messageField},#{messageTime})")
	int add(Message message);
	
	@Update("update message set messageField=#{messageField} where username=#{username}")
	int update(Message message);
	
	@Delete("delete from message where messageId=#{messageId}")
	int deleteByMessageId(String messageId);
	
	@Select("select * from message where messageId=#{messageId}")
	Message queryByMessageId(String messageId);
	
	@Select("select * from message where username=#{username} order by publishTime DESC")
	List<Message> queryMessagesByUsername(String username);
	
	@Select("select * from message order by messageTime DESC")
	List<Message> findAllList();
}
