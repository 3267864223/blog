package blog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.entity.User;
import blog.service.UserService;

@Controller @RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
		
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		String userName=request.getParameter("userName");
		String userPass=request.getParameter("userPass");
		 
		User user=userService.getUserByNameOrEmail(userName);
		if(user!=null) {
			if(user.getUserPass().equals(userPass)) {
				request.getSession().setAttribute("session_user", user);
				return "index";	
			}
			else {
				request.setAttribute("msg", "密码错误");
				return "login";
			}
		}
		else {
			request.setAttribute("msg", "账号或密码错误");
			return "login";
		}	
	}
}
