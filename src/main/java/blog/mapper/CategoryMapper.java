package blog.mapper;

import java.util.List;

import blog.entity.Category;

public interface CategoryMapper {

	/**
	 * 根据pid查询全部分类
	 * @param 
	 * @return 分类信息
	 */
	List<Category> getCategoryByPid(Integer pid);
}
