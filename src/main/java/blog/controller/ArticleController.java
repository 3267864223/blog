package blog.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import blog.entity.Article;
import blog.service.ArticleService;

@Controller @RequestMapping("/article")
public class ArticleController {
	
	@Resource
	private ArticleService articleService;
	
	@ResponseBody @RequestMapping("/getAllArticle")
	public List<Article> getAllArticle(){
		return articleService.getAllArticle();
	}

}
