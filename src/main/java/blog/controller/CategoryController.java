package blog.controller;


import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import blog.entity.Category;
import blog.entity.Tag;
import blog.service.CategoryService;

@Controller @RequestMapping("/category")
public class CategoryController {
	
	@Resource
	private CategoryService categoryService;
	
	@RequestMapping("")
	public String getAllArticle(ModelMap m){
		//一级分类
		List<Category> bigCategoryList=categoryService.getCategoryByPid(0);
		List<Category> categoryList=categoryService.getAllCategory();
		
		m.put("bigCategoryList", bigCategoryList);
		m.put("categoryList", categoryList);
		return "Category/category-list";
	}
	
	@ResponseBody @RequestMapping("/toUpdate")
	public Category toUpdateCategory(Integer categoryId){
		return categoryService.getCategoryById(categoryId);
	}
	
	@RequestMapping("/insertSubmit")
	public String insertSubmit(Category category){
		//修改
		if(category.getCategoryId()!=null) {
			categoryService.updateCategory(category);
		}
		//添加
		else {
			categoryService.addCategory(category);
		}
		return "forward:/category";
	}
	
	@RequestMapping("/del")
	public void deleteTag(Integer categoryId,HttpServletResponse response) throws IOException{
		categoryService.deletecategory(categoryId);
		response.getWriter().print("删除成功");
	}
}
