package blog.mapper;

import java.util.List;

import blog.entity.Category;

public interface CategoryMapper {

	/**
	 * 根据pid查询全部分类
	 * @return 分类信息
	 */
	List<Category> getCategoryByPid(Integer pid);

	/**
	 *查询全部分类
	 * @return 分类信息
	 */
	List<Category> getAllCategory();
	
	/**
	 *查询分类对应文章数量
	 * @param categoryId
	 */
	Integer getArticleCategoryCount(Integer categoryId);

	/**
	 *根据categoryId查询分类
	 * @param categoryId
	 * @return 分类信息
	 */
	Category getCategoryById(Integer categoryId);

	/**
	 *修改分类
	 * @param 分类信息
	 */
	void updateCategory(Category category);

	/**
	 *添加分类
	 * @param 分类信息
	 */
	void addCategory(Category category);

	/**
	 *删除分类
	 * @param category
	 */
	void deleteCategory(Integer categoryId);
}
