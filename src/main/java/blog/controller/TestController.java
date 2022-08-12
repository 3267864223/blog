package blog.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.entity.User;
import blog.mapper.UserMapper;

@Controller
public class TestController {
	@Resource
	UserMapper userMapper;
	
	@RequestMapping("/test")
	public String test(ModelMap m) {
		User user=userMapper.getUserByNameOrEmail("admin");
		m.put("user", user);
		
		System.out.println(user);
	
		return "index";
	}
}
