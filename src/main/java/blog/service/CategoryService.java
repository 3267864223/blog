package blog.service;

import java.util.List;

import blog.entity.Category;

public interface CategoryService {

	/**
	 * 根据pid查询全部分类
	 * @param 
	 * @return 分类信息
	 */
	List<Category> getCategoryByPid(Integer pid);
}
