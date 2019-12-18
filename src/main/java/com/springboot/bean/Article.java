package com.springboot.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *存放文章信息的实体类
 */
public class Article {
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
	private int articleId=(int)(Math.random()*8912356+1);
	private String title;
	private String publishTime=dateFormat.format(date);
	private String author;
	private String article;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPublishTime() {
		return publishTime;
	}
	
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getArticle() {
		return article;
	}
	
	public void setArticle(String article) {
		this.article = article;
	}
	
	public int getArticleId() {
		return articleId;
	}
	
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
}
