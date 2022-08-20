package blog.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import blog.entity.Link;

public interface LinkService {

	/**
	 * 分页查询链接列表
	 * @param pageIndex 从第几页开始查
	 * @param pageSize  每页多少条
	 * @return PageInfo类型的数据,里面含有链接列表和分页相关数据
	 */
	PageInfo<Link> getPageLinkList(Integer pageIndex, Integer pageSize);

	/**
	 *根据linkId查询链接
	 * @param linkId
	 * @return 链接信息
	 */
	Link getLinkById(Integer linkId);

	/**
	 *查询全部链接
	 * @return 链接列表
	 */
	List<Link> getAllLink();

	/**
	 *修改链接
	 *@param 链接信息
	 */
	void updateLink(Link link);

	/**
	 *删除链接
	 *@param linkId
	 */
	void deleteLinkById(Integer linkId);

	/**
	 *添加链接
	 *@param 链接信息
	 */
	void addLink(Link link);

}
