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
	
	/**
	 *查询标签对应文章数量
	 * @param categoryId
	 */
	Integer getArticleTagCount(Integer tagId);

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
