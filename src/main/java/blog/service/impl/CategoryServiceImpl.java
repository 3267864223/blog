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

}
