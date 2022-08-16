package blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import blog.entity.Article;
import blog.entity.Category;
import blog.entity.Comment;
import blog.entity.Tag;
import blog.entity.User;
import blog.service.ArticleService;
import blog.service.CategoryService;
import blog.service.CommentService;
import blog.service.TagService;
import cn.hutool.http.HtmlUtil;

@Controller @RequestMapping("/article")
public class ArticleController {
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	private CommentService commentSerivce;
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private TagService tagService;
	
	@RequestMapping("/insertDraftSubmit")
	public String insertDraftSubmit(Article article,ModelMap m){
		articleService.insertDraftSubmit(article);
		//文章列表
		List<Article> articleList=articleService.getArticleByStatus(6);
		//评论列表
		List<Comment> commentList=commentSerivce.getCommentLimit(6);

		m.put("articleList", articleList);
		m.put("commentList", commentList);
		return "index";
	}
	
	@RequestMapping("")
	public String getAllArticle(@RequestParam(required = false,defaultValue="1") Integer pageIndex,
			@RequestParam(required = false,defaultValue = "10") Integer pageSize,
			ModelMap m){
		
		List<Article> cateList=articleService.getArticleCate();
		PageInfo<Article> pageInfoArticle=articleService.getPageArticleList(pageIndex,pageSize);
		m.put("pageInfo",pageInfoArticle);
		m.put("cateList",cateList);
		m.put("pageUrlPrefix", "article?pageIndex"); 
		return "Article/article-list";
	}
	
	@RequestMapping(value = "add" ,method=RequestMethod.GET)
	public String gotoAdd(ModelMap m) {
		
		//查询一级分类
		List<Category> categoryList= categoryService.getCategoryByPid(0);
		List<Tag> tagList= tagService.getAllTag();
		
		m.put("categoryList", categoryList);
		m.put("tagList", tagList);
		
		return "Article/article-add"; 	
	}
	
	//ajax查询二级分类
	@ResponseBody @RequestMapping("/getsmallCate")
	public List<Category> getsmallCate(Integer pid){
		List<Category> categoryList=categoryService.getCategoryByPid(pid);
		return categoryList;
	}
	
	@RequestMapping(value = "add" ,method=RequestMethod.POST)
	public String Add(HttpServletRequest request) {
		Article article=new Article();
		
		//当前用户id
		User user=(User) request.getSession().getAttribute("session_user");
		article.setArticleUserId(user.getUserId());
		
		//文章标题
		article.setArticleTitle(request.getParameter("articleTitle"));
		
		//文章内容
		article.setArticleContent(request.getParameter("articleContent"));
		
		//文章摘要(hutu 工具包)
		String s= HtmlUtil.cleanHtmlTag(article.getArticleContent());
		article.setArticleSummary(s.length()>150?s.substring(0,150):s);
		
		//默认的排序
		article.setArticleOrder(1);
		
		//文章状态(草稿,或发布)
		article.setArticleStatus(Integer.parseInt(request.getParameter("articleStatus")));
		
		//一级分类ID
		int parentCateId =Integer.parseInt(request.getParameter("articleParentCategoryId"));
		
		//二级分类ID
		int childCateId=Integer.parseInt(request.getParameter("articleChildCategoryId"));
		
		//标签
		String [] tagIds =request.getParameterValues("articleTagIds");
		
		//传入分类信息
		List<Category> categoryList=new ArrayList<>();
		categoryList.add(new Category(parentCateId));
		categoryList.add(new Category(childCateId));
		article.setCategoryList(categoryList);
		
		//传入标签信息
		List<Tag> tagList=new ArrayList<>();
		for(String tagId:tagIds) {
			tagList.add(new Tag(Integer.parseInt(tagId)));
		}
		article.setTagList(tagList);
	
		//发布
		articleService.addArticle(article);
		
		return "forward:/article"; 	
	}
}
