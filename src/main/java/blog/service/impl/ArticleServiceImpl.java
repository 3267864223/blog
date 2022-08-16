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
import blog.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Resource
	private ArticleMapper articleMapper;

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
}
