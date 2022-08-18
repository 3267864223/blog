package blog.service;

import java.util.List;

import blog.entity.Tag;

public interface TagService {
	
	/**
	 * 查询全部标签
	 * @return 标签信息
	 */
	List<Tag> getAllTag();


	/**
	 * 根据tagId查询标签
	 * @param tagId
	 * @return 标签信息
	 */
	Tag getTagById(Integer tagId);

	/**
	 * 修改标签
	 * @param 标签信息
	 */
	void updateTag(Tag tag);
	
	/**
	 * 添加标签
	 * @param 标签信息
	 */
	void addTag(Tag tag);

	/**
	 * 删除标签
	 * @param tagId
	 */
	void deleteTag(Integer tagId);
}
