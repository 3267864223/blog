package blog.mapper;

import java.util.List;

import blog.entity.Article;

public interface ArticleMapper {
	
	/**
	 * 查询所有文章
	 * @param 
	 * @return 文章信息
	 */
	List<Article> getAllArticle();
}
