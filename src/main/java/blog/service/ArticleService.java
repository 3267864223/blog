package blog.service;

import java.util.List;

import blog.entity.Article;

public interface ArticleService {
	
	/**
	 * 查询所有文章
	 * @param 
	 * @return 文章信息
	 */
	List<Article> getAllArticle();
}
