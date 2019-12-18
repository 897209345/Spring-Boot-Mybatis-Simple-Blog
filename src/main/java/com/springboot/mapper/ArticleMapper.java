package com.springboot.mapper;

import com.springboot.bean.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ArticleMapper {
	@Insert("insert into article(articleId,title,publishTime,author,article) values(#{articleId},#{title},#{publishTime},#{author},#{article})")
	int add(Article article);
	
	@Update("update article set title=#{title},article=#{article} where articleId=#{articleId}")
	int update(Article article);
	
	@Delete("delete from article where articleId=#{articleId}")
	int deleteByArticleId(String articleId);
	
	@Select("select * from article where articleId=#{articleId}")
	Article queryByArticleId(String articleId);
	
	@Select("select * from article where author=#{author} order by publishTime DESC")
	List<Article> queryArticlesByAuthor(String author);
	
	@Select("select * from article order by publishTime DESC")
	List<Article> findAllList();
}