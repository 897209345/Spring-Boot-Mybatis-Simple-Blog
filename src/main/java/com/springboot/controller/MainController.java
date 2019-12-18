/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.controller;

import com.springboot.bean.Article;
import com.springboot.bean.CalendarBean;
import com.springboot.bean.Message;
import com.springboot.bean.User;
import com.springboot.service.ArticleService;
import com.springboot.service.MessageService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 马秀昆
 */
@Controller
@RequestMapping("/main")
@SessionAttributes(value = {"userSession"})
public class MainController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private MessageService messageService;
	
	// 下面的引入并不能解决问题
//	@Autowired
//	private CalendarBean calendarBean;
	
	/**
	 * @return 转发到主页index.html
	 */
	@RequestMapping("")
	public String index(Article article, Model model) {
		List<Article> articles = this.articleService.findAllList();
		model.addAttribute("articles", articles);
		return "/index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> hello() {
		// System.err.println(this.userService.queryUserByUsername(username));
		// System.err.println(this.userService.deleteByUsername(username));
//		return this.userService.queryUserByUsername(username);
		return this.userService.findAllList();
	}
	
	@RequestMapping("/showData")
	public String showData(Model model) {
		model.addAttribute("userList", this.userService.findAllList());
		model.addAttribute("userSession", model.getAttribute("userSession"));
		return "/manager/showData";
	}
	
	@RequestMapping("/calendar")
	public String calendar(@ModelAttribute("calendar") @Valid CalendarBean calendarBean, BindingResult result,
	                       Model model) {
		if (result.hasErrors()) {
			// model.addAttribute("err", result.getFieldErrors());
//			for (ObjectError error : result.getAllErrors()) {
//				System.out.println(error.getDefaultMessage());
//			}
			return "/calendar";
		}
//		model.addAttribute("calendar", calendarBean);
		return "/calendar";
	}
	
	@RequestMapping("/login")
	public String login(User user) {
		return "/user/login";
	}
	
	@RequestMapping("/login/input")
	public String login(User user, Model model) {
		String username = (String) model.getAttribute("userSession");
		if ("".equals(username) || username == null) {
			if (this.userService.checkUser(user) == null) {
				model.addAttribute("notice", "<font color='red'>*用户名或密码错误</font>");
				return "/user/login";
			} else {
				model.addAttribute("userSession", user.getUsername());
				List<Article> articles = this.articleService.findAllList();
				model.addAttribute("articles", articles);
				return "/index";
			}
		} else {
			model.addAttribute("articles", this.articleService.findAllList());
			return "/index";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(/* HttpSession session, */ SessionStatus sessionStatus, User user, Model model) {
		/*
		 * 用注解添加的session不能用session.removeAttribute("userSession")或session.invalidate()
		 * 来清除,要用sessionStatus.setComplete();
		 */
//		session.removeAttribute("userSession");
//		session.invalidate();
		sessionStatus.setComplete();
		model.addAttribute("notice", "<font color='red'>*已安全退出</font>");
		return "/user/login";
	}
	
	@RequestMapping("/register")
	public String register(User user) {
		return "/user/register";
	}
	
	@RequestMapping("/register/input")
	public String register(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
		String username = (String) model.getAttribute("userSession");
		if ("".equals(username) || username == null) {
			if (result.hasErrors()) {
				return "/user/register";
			} else {
				this.userService.add(user);
				model.addAttribute("notice", "<font color='red'>*注册成功!请登录</font>");
				return "/user/login";
			}
		} else {
			model.addAttribute("articles", this.articleService.findAllList());
			return "/index";
		}
	}
	
	@RequestMapping("/myData")
	public String myData(User user, Model model) throws Exception {
		String username = (String) model.getAttribute("userSession");
		if ("".equals(username) || username == null) {
			model.addAttribute("notice", "<font color='red'>*请登录后查看</font>");
			return "/user/login";
		} else {
			model.addAttribute("user", this.userService.queryUserByUsername(username));
			return "/user/myData";
		}
	}
	
	@RequestMapping("/editMyData")
	public String editMyData(User user, Model model) {
		String username = (String) model.getAttribute("userSession");
		if ("".equals(username) || username == null) {
			model.addAttribute("notice", "<font color='red'>*请登录后查看</font>");
			return "/user/login";
		} else {
			model.addAttribute("user", this.userService.queryUserByUsername(username));
			return "/user/editMyData";
		}
	}
	
	@RequestMapping("/editMyData/input")
	public String saveEditMyData(User user, Model model) {
		String username = (String) model.getAttribute("userSession");
		if ("".equals(username) || username == null) {
			model.addAttribute("notice", "<font color='red'>*请登录后查看</font>");
			return "/user/login";
		} else {
			user.setUsername(username);
			this.userService.update(user);
			model.addAttribute("user", user);
			return "/user/myData";
		}
	}
	
	@RequestMapping("/myArticles")
	public String myArticles(User user, Model model) {
		String username = (String) model.getAttribute("userSession");
		if ("".equals(username) || username == null) {
			model.addAttribute("notice", "<font color='red'>*请登录后查看</font>");
			return "/user/login";
		} else {
			model.addAttribute("articles", this.articleService.queryArticlesByAuthor(username));
			return "/user/myArticles";
		}
		
	}
	
	@RequestMapping("/writeArticle")
	public String writeArticle(User user, Model model) {
		String username = (String) model.getAttribute("userSession");
		if ("".equals(username) || username == null) {
			model.addAttribute("notice", "<font color='red'>*请登录后查看</font>");
			return "/user/login";
		} else {
			return "/user/writeArticle";
		}
	}
	
	@RequestMapping("/addArticle")
	public String addArticle(Article article, Model model) {
		String username = (String) model.getAttribute("userSession");
		if ("".equals(username) || username == null) {
			model.addAttribute("notice", "<font color='red'>*请登录后查看</font>");
			return "/user/login";
		} else {
			article.setAuthor(username);
			this.articleService.add(article);
			model.addAttribute("articles", this.articleService.queryArticlesByAuthor(username));
			return "/user/myArticles";
		}
	}
	
	@RequestMapping("/viewArticle")
	public String viewArticle(String articleId, Model model) {
		model.addAttribute("article", this.articleService.queryByArticleId(articleId));
		return "/viewArticle";
	}
	
	@RequestMapping("/viewAuthor")
	public String viewAuthor(String author, Model model) {
		model.addAttribute("articles", this.articleService.queryArticlesByAuthor(author));
		model.addAttribute("author", author);
		return "/viewAuthor";
	}
	
	@RequestMapping("/message")
	public String showMessage(Model model) {
		model.addAttribute("messages", this.messageService.findAllList());
		return "/message";
	}
	
	@RequestMapping("/writeMessage")
	public String writeMessage(User user, Message message, Model model) {
		String username = (String) model.getAttribute("userSession");
		if ("".equals(username) || username == null) {
			model.addAttribute("notice", "<font color='red'>*请登录后查看</font>");
			return "/user/login";
		} else {
			model.addAttribute("message", message);
			return "/user/writeMessage";
		}
	}
	
	@RequestMapping("/addMessage")
	public String addMessage(Message message, Model model) {
		String username = (String) model.getAttribute("userSession");
		if ("".equals(username) || username == null) {
			model.addAttribute("notice", "<font color='red'>*请登录后查看</font>");
			return "/user/login";
		} else {
			message.setUsername(username);
			this.messageService.add(message);
			model.addAttribute("messages", this.messageService.findAllList());
			return "/message";
		}
	}
	
	@RequestMapping("/deleteArticle")
	public String deleteArticle(String articleId, User user, Model model) {
		String username = (String) model.getAttribute("userSession");
		if ("".equals(username) || username == null) {
			model.addAttribute("notice", "<font color='red'>*请登录后查看</font>");
			return "/user/login";
		} else {
			this.articleService.deleteByArticleId(articleId);
			model.addAttribute("articles", this.articleService.queryArticlesByAuthor(username));
			return "/user/myArticles";
		}
	}
	
	@RequestMapping("/editArticle")
	public String editArticle(String articleId, User user, Model model) {
		String username = (String) model.getAttribute("userSession");
		if ("".equals(username) || username == null) {
			model.addAttribute("notice", "<font color='red'>*请登录后查看</font>");
			return "/user/login";
		} else {
			model.addAttribute("article", this.articleService.queryByArticleId(articleId));
			return "/user/editArticle";
		}
	}
	
	@RequestMapping("/editArticle/input")
	public String editArticle(Article article, User user, Model model) {
		String username = (String) model.getAttribute("userSession");
		if ("".equals(username) || username == null) {
			model.addAttribute("notice", "<font color='red'>*请登录后查看</font>");
			return "/user/login";
		} else {
			this.articleService.update(article);
			model.addAttribute("articles", this.articleService.queryArticlesByAuthor(username));
			return "/user/myArticles";
		}
		
	}
}
