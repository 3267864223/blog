package blog.mapper;

import java.util.List;

import blog.entity.Tag;

public interface TagMapper {
	
	/**
	 * 查询全部标签
	 * @param 
	 * @return 标签信息
	 */
	List<Tag> getAllTag();
}
