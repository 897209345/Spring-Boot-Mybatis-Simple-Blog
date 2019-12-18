package com.springboot.service;

import com.springboot.bean.Article;

import java.util.List;

public interface ArticleService {
	int add(Article article);

	int update(Article article);

	int deleteByArticleId(String articleId);

	Article queryByArticleId(String articleId);
	
	List<Article> queryArticlesByAuthor(String author);
	
	List<Article> findAllList();
}
