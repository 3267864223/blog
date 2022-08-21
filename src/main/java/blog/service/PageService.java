package blog.service;

import java.util.List;

import blog.entity.Page;

public interface PageService {

	/**
	 *查询全部页面
	 * @return 页面信息列表
	 */
	List<Page> getAllPage();

	/**
	 *根据pageId查询页面
	 * @param linkId
	 * @return 页面信息
	 */
	Page getPageById(Integer pageId);

	/**
	 *添加页面
	 * @param 页面信息
	 */
	void addPage(Page page);

	/**
	 *更新页面
	 * @param 页面信息
	 */
	void updatePage(Page page);

	/**
	 *删除页面
	 * @param pageId
	 */
	void deletePage(Integer pageId);

	
}
