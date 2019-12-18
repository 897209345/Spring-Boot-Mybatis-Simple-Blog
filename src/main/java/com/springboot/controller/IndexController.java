package com.springboot.controller;

import com.springboot.bean.Article;
import com.springboot.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
	@Autowired
	private ArticleMapper articleService;
	
	@RequestMapping("")
	public String index1(Article article, Model model) {
		List<Article> articles=this.articleService.findAllList();
		model.addAttribute("articles",articles);
		return "/index";
	}
	
	@RequestMapping("/index")
	public String index2(Article article, Model model) {
		List<Article> articles=this.articleService.findAllList();
		model.addAttribute("articles",articles);
		return "/index";
	}
}
