package blog.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import blog.entity.Category;
import blog.entity.Menu;
import blog.service.MenuService;

@Controller @RequestMapping("/menu")
public class MenuController {

	@Resource
	private MenuService menuService;
	
	@RequestMapping("")
	public String getAllMenu(ModelMap m){
		List<Menu> menuList=menuService.getAllMenu();
		m.put("menuList", menuList);
		return "Menu/menu-list";
	}
	
	@ResponseBody @RequestMapping("/toUpdate")
	public Menu toUpdateMenu(Integer menuId){
		return menuService.getMenuById(menuId);
	}
	
	@RequestMapping("/insertSubmit")
	public String insertSubmit(Menu menu){
		//修改
		if(menu.getMenuId()!=null) {
			menuService.updateMenu(menu);
		}
		//添加
		else {
			menu.setMenuOrder(1);
			menuService.addMenu(menu);
		}
		return "forward:/menu";
	}
	
	@RequestMapping("/del")
	public void deleteTag(Integer menuId,HttpServletResponse response) throws IOException{
		menuService.deleteMenu(menuId);
		response.getWriter().print("删除成功");
	}
}
