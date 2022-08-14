package blog.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.commons.MD5Util;
import blog.entity.User;
import blog.service.UserService;

@Controller @RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
		
	@RequestMapping("/login")
	public String login(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String userName=request.getParameter("userName");
		String userPass=request.getParameter("userPass");
		//加密
		String encryption=MD5Util.EncoderByMd5(userPass);
		 
		User user=userService.getUserByNameOrEmail(userName);
		if(user!=null) {
			if(user.getUserPass().equals(encryption)) {
				request.getSession().setAttribute("session_user", user);
				request.setAttribute("msg", "登录成功");
				return "index";	
			}
			else {
				request.setAttribute("msg", "账号或密码错误");
				return "login";
			}
		}
		else {
			request.setAttribute("msg", "账号或密码错误");
			return "login";
		}	
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();	
		return "login";
	}
}
