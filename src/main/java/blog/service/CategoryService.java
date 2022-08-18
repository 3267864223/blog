package blog.service;

import java.util.List;

import blog.entity.Category;
import blog.entity.Tag;

public interface CategoryService {

	/**
	 * 根据pid查询全部分类
	 * @param pid
	 * @return 分类信息
	 */
	List<Category> getCategoryByPid(Integer pid);

	/**
	 * 查询全部分类
	 * @return 分类信息
	 */
	List<Category> getAllCategory();

	/**
	 * 根据categoryId查询分类
	 * @param categoryId
	 * @return 分类信息
	 */
	Category getCategoryById(Integer categoryId);

	/**
	 * 修改分类
	 * @param 分类信息
	 */
	void updateCategory(Category category);

	/**
	 * 添加分类
	 * @param 分类信息
	 */
	void addCategory(Category category);

	/**
	 * 删除分类
	 * @param categoryId
	 */
	void deletecategory(Integer categoryId);
}
