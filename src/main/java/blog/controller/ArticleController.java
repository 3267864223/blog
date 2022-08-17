package blog.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
import cn.hutool.core.lang.UUID;
import cn.hutool.http.HtmlUtil;
import cn.hutool.json.JSONObject;

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
	public String add(HttpServletRequest request) {
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
	
	//图片的上传回显（配置虚拟路径）
	@RequestMapping("/uploadImg")
	public void upload(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		//imgFile 这个名称是固定的
		MultipartFile file =request.getFile("imgFile");
		
		//生成一个随机的文件名
		String newName=UUID.randomUUID().toString()+".jpg";
		File destFile=new File("D:/imguploads/"+newName);
		
		String path="http://localhost:8080/uploads/"+ newName;
		
		file.transferTo(destFile);
		
		//引入的 hutool 中自带, 所以不用引入其他的依赖
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put("url",path);
		
		response.getWriter().println(obj);
	}
	
	@RequestMapping(value = "update" ,method=RequestMethod.GET)
	public String toUpdate(Integer articleId,ModelMap m) {
		Article article=articleService.getArticle(articleId);
		List<Tag> tagList= tagService.getAllTag();
		//一级分类
		List<Category> bigCategoryList= categoryService.getCategoryByPid(0);
		if(article.getCategoryList().size()!=0) {
			//二级分类
			List<Category> smallCategoryList= categoryService.getCategoryByPid(article.getCategoryList().get(0).getCategoryId());
			m.put("smallCategoryList", smallCategoryList);
		}
		m.put("tagList", tagList);
		m.put("bigCategoryList", bigCategoryList);
		m.put("article", article);
		return "Article/article-update"; 	
	}
	
	@RequestMapping(value = "update" ,method=RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Article article=new Article();
		article.setArticleId(Integer.parseInt(request.getParameter("articleId")));
		//文章标题
		article.setArticleTitle(request.getParameter("articleTitle"));
		
		//文章内容
		article.setArticleContent(request.getParameter("articleContent"));
		
		//文章摘要(hutu 工具包)
		String s= HtmlUtil.cleanHtmlTag(article.getArticleContent());
		article.setArticleSummary(s.length()>150?s.substring(0,150):s);
		
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
		articleService.updateArticle(article);
		
		return "forward:/article"; 	
	}
	
	@RequestMapping("/del")
	public void del(HttpServletResponse response,Integer articleId) throws IOException {
		articleService.deleteArticleById(articleId);
		response.getWriter().println("删除成功");
	}
}
