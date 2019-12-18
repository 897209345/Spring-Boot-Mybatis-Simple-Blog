package com.springboot.service.impl;

import com.springboot.bean.Article;
import com.springboot.mapper.ArticleMapper;
import com.springboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;
	@Override
	public int add(Article article) {
		return this.articleMapper.add(article);
	}
	
	@Override
	public int update(Article article) {
		return this.articleMapper.update(article);
	}
	
	@Override
	public int deleteByArticleId(String articleId) {
		return this.articleMapper.deleteByArticleId(articleId);
	}
	
	@Override
	public Article queryByArticleId(String articleId) {
		return this.articleMapper.queryByArticleId(articleId);
	}
	
	@Override
	public List<Article> queryArticlesByAuthor(String author) {
		return this.articleMapper.queryArticlesByAuthor(author);
	}
	
	@Override
	public List<Article> findAllList() {
		return this.articleMapper.findAllList();
	}
}
