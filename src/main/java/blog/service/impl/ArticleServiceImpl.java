package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import blog.entity.Article;
import blog.entity.Category;
import blog.entity.Tag;
import blog.mapper.ArticleMapper;
import blog.mapper.CategoryMapper;
import blog.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Resource
	private ArticleMapper articleMapper;
	
	@Resource
	private CategoryMapper categoryMapper;

	public List<Article> getArticleByStatus(Integer n) {
		return articleMapper.getArticleByStatus(n);
	}

	public void insertDraftSubmit(Article article) {
		articleMapper.insertDraftSubmit(article);
	}

	public PageInfo<Article> getPageArticleList(Integer pageIndex, Integer pageSize) {
		PageHelper.startPage(pageIndex,pageSize);
		List<Article>  articleList = articleMapper.getAllArticle();
		return new PageInfo<Article>(articleList);	
	}

	public List<Article> getArticleCate() {
		return articleMapper.getArticleCate();
	}

	public void addArticle(Article article) {
		//article表中添加数据
		articleMapper.addArticle(article);
		
		//article_category_ref表中添加数据
		List<Category>categoryList=article.getCategoryList();
		for(Category c: categoryList) {
			articleMapper.addArticleCategory(article.getArticleId(),c.getCategoryId());
		}
		
		//article_tag_ref表中添加数据
		List<Tag> tagList=article.getTagList();
		for(Tag t:tagList) {
			articleMapper.addArticleTag(article.getArticleId(),t.getTagId());
		}
	}

	public Article getArticle(Integer articleId) {
		Article article=articleMapper.getArticleById(articleId);
		
		//获取文章分类
		List<Category> categoryList=articleMapper.getArticleCateById(articleId);
		article.setCategoryList(categoryList);
		//获取文章标签
		List<Tag> tagList=articleMapper.getArticleTagById(articleId);
		article.setTagList(tagList);
		return article;
	}

	public void updateArticle(Article article) {
		//article表中修改数据
		articleMapper.updateArticle(article);
		
		//article_category_ref表中先删除再添加数据
		articleMapper.deleteArticleCategory(article.getArticleId());
		List<Category>categoryList=article.getCategoryList();
		for(Category c: categoryList) {
			articleMapper.addArticleCategory(article.getArticleId(),c.getCategoryId());
		}
		
		//article_tag_ref表中先删除再添加数据
		articleMapper.deleteArticleTag(article.getArticleId());
		List<Tag> tagList=article.getTagList();
		for(Tag t:tagList) {
			articleMapper.addArticleTag(article.getArticleId(),t.getTagId());
		}
	}
	
	public void deleteArticleById(Integer articleId) {
		//article表中删除数据
		articleMapper.deleteArticleById(articleId);
		
		//article_category_ref表中删除数据
		articleMapper.deleteArticleCategory(articleId);
		
		//article_tag_ref表中删除数据
		articleMapper.deleteArticleTag(articleId);
		
	}

	public PageInfo<Article> getPageDraftList(Integer pageIndex, Integer pageSize) {
		PageHelper.startPage(pageIndex,pageSize);
		List<Article>  articleList = articleMapper.getAllDraf();
		return new PageInfo<Article>(articleList);	
	}
}
