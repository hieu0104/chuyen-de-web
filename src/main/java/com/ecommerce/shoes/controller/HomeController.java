package com.ecommerce.shoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.shoes.model.Article;
import com.ecommerce.shoes.service.ArticleService;

@Controller
public class HomeController {
		
	
	  @Autowired private ArticleService articleService;
	 
	
	@RequestMapping("/")
	public String index(Model model) {		
		
		  List<Article> articles = articleService.findFirstArticles();
		  model.addAttribute("articles", articles);
		 
		return "index";
	}

	
}
