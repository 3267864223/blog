package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.entity.Article;
import blog.mapper.ArticleMapper;
import blog.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Resource
	private ArticleMapper articleMapper;

	public List<Article> getAllArticle() {
		return articleMapper.getAllArticle();
	}
}
