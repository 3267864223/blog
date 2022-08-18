package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.entity.Category;
import blog.mapper.CategoryMapper;
import blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Resource
	private CategoryMapper categoryMapper;

	public List<Category> getCategoryByPid(Integer pid) {
		return categoryMapper.getCategoryByPid(pid);
	}

	public List<Category> getAllCategory() {
		List<Category> categoryList=categoryMapper.getAllCategory();
		for(Category c:categoryList) {
			c.setArticleCount(categoryMapper.getArticleCategoryCount(c.getCategoryId()));
		}
		return categoryList;
	}

	public Category getCategoryById(Integer categoryId) {
		return categoryMapper.getCategoryById(categoryId);
	}

	public void updateCategory(Category category) {
		categoryMapper.updateCategory(category);
	}

	public void addCategory(Category category) {
		categoryMapper.addCategory(category);
	}

	public void deletecategory(Integer categoryId) {
		categoryMapper.deleteCategory(categoryId);
	}

}
