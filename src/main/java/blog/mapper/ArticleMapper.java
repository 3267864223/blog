package blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import blog.entity.Article;
import blog.entity.Category;
import blog.entity.Tag;

public interface ArticleMapper {
	
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
	 * 查询全部文章
	 * @param 
	 * @return 文章信息
	 */
	List<Article> getAllArticle();
	
	/**
	 * 查询全部文章分类
	 * @param 
	 * @return 文章信息
	 */
	List<Article> getArticleCate();
	
	/**
	 * 添加文章信息到文章表
	 * @param article
	 */
	void addArticle(Article article);

	/**
	 * 添加文章分类信息到文章分类表
	 * @param articleId 文章ID
	 * @param categoryId 分类ID
	 */
	void addArticleCategory(@Param("articleId") Integer articleId, @Param("categoryId") Integer categoryId);

	/**
	 * 添加文章标签信息到文间标签表
	 * @param articleId 文章ID
	 * @param tagId 标签ID 
	 */
	void addArticleTag(@Param("articleId")  Integer articleId, @Param ("tagId") Integer tagId);

	/**
	 * 根据articleId查询文章
	 * @param 文章id
	 * @return 文章信息
	 */
	Article getArticleById(Integer articleId);
	
	/**
	 * 根据articleId查询文章的分类
	 * @param 文章id
	 * @return 文章分类信息
	 */
	List<Category> getArticleCateById(Integer articleId);
	
	/**
	 * 根据articleId查询文章的标签
	 * @param 文章id
	 * @return 文章标签信息
	 */
	List<Tag> getArticleTagById(Integer articleId);

	/**
	 * 根据修改文章的
	 * @param 文章信息
	 */
	void updateArticle(Article article);

	/**
	 * 根据articleId删除文章的分类
	 * @param 文章id
	 */
	void deleteArticleCategory(Integer articleId);

	/**
	 * 根据articleId删除文章的标签
	 * @param 文章id
	 */
	void deleteArticleTag(Integer articleId);

	/**
	 * 根据articleId删除文章
	 * @param 文章id
	 */
	void deleteArticleById(Integer articleId);

	/**
	 * 查询全部草稿
	 * @return 草稿信息
	 */
	List<Article> getAllDraf();
	
}
