package blog.mapper;

import java.util.List;

import blog.entity.Link;

public interface LinkMapper {

	/**
	 * 查询所有链接
	 * @return 链接列表
	 */
	List<Link> getAllLink();

	/**
	 * 根据linkId查询链接
	 * @param linkId
	 * @return 链接信息
	 */
	Link getLinkById(Integer linkId);

	/**
	 * 修改链接
	 * @param 链接信息
	 */
	void updateLink(Link link);

	/**
	 * 删除链接
	 * @param linkId
	 */
	void deleteLink(Integer linkId);

	/**
	 * 添加链接
	 * @param 链接信息
	 */
	void addLink(Link link);

}
