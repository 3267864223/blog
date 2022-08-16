package blog.service;

import java.util.List;

import blog.entity.Tag;

public interface TagService {
	
	/**
	 * 查询全部标签
	 * @param 
	 * @return 标签信息
	 */
	List<Tag> getAllTag();
}
