package blog.mapper;

import java.util.List;

import blog.entity.Menu;

public interface MenuMapper {

	/**
	 * 查询全部菜单
	 * @return 菜单信息
	 */
	List<Menu> getAllMenu();

	/**
	 * 根据menuId查询菜单
	 * @return 菜单信息
	 */
	Menu getMenuById(Integer menuId);

	/**
	 * 修改菜单
	 * @param 菜单信息
	 */
	void updateMenu(Menu menu);

	/**
	 * 添加菜单
	 * @param 菜单信息
	 */
	void addMenu(Menu menu);
	
	/**
	 * 删除菜单
	 * @param menuId
	 */
	void deleteMenu(Integer menuId);

}
