package blog.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import blog.entity.Article;

public interface ArticleService {
	
	/**
	 * 查询不是草稿的文章 分页
	 * @param 
	 * @return 文章信息
	 */
	List<Article> getArticleByStatus(Integer n);
	
	/**
	 * 首页保存草稿
	 * @param article
	 * @return 
	 */
	void insertDraftSubmit(Article article);
	
	/**
	 * 分页查询文章列表
	 * @param pageIndex 从第几页开始查
	 * @param pageSize  每页多少条
	 * @return PageInfo类型的数据,里面含有文章列表和分页相关数据
	 */
	PageInfo<Article> getPageArticleList(Integer pageIndex, Integer pageSize);
	
	/**
	 * 查询全部文章分类
	 * @param 
	 * @return 文章信息
	 */
	List<Article> getArticleCate();

	/**
	 * 发布文章
	 * @param article 文章信息
	 */
	void addArticle(Article article);

	/**
	 * 查询文章
	 * @param 文章id
	 * @return 文章信息
	 */
	Article getArticle(Integer articleId);

	/**
	 * 修改文章
	 * @param article 文章信息
	 */
	void updateArticle(Article article);

	/**
	 * 删除文章
	 * @param article 文章id
	 */
	void deleteArticleById(Integer articleId);
}
