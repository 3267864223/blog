package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.entity.Menu;
import blog.mapper.MenuMapper;
import blog.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{

	@Resource
	private MenuMapper menuMapper;

	public List<Menu> getAllMenu() {
		return menuMapper.getAllMenu();
	}

	public Menu getMenuById(Integer menuId) {
		return menuMapper.getMenuById(menuId);
	}

	public void updateMenu(Menu menu) {
		menuMapper.updateMenu(menu);
	}

	public void addMenu(Menu menu) {
		menuMapper.addMenu(menu);
	}

	public void deleteMenu(Integer menuId) {
		menuMapper.deleteMenu(menuId);
	}
}
