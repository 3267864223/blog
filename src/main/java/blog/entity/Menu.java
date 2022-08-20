package blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

	//自增ID
	private Integer menuId; 
	
	//菜单名称
	private String menuName; 
	
	//菜单url地址
	private String menuUrl; 
	
	//这个值是用来区分是顶部菜单(1)还是主要菜单的(2)
	private Integer menuLevel;
	
	//菜单图标
	private String menuIcon; 
	
	//菜单的顺序
	private Integer menuOrder; 
}
