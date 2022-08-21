package blog.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;

import blog.commons.MD5Util;
import blog.entity.Article;
import blog.entity.Comment;
import blog.entity.User;
import blog.service.ArticleService;
import blog.service.CommentService;
import blog.service.UserService;

@Controller @RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private ArticleService articleSerivce;
	
	@Resource
	private CommentService commentSerivce;
		
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException, UnknownHostException {
		String userName=request.getParameter("userName");
		String userPass=request.getParameter("userPass");
		//加密
		String encryption=MD5Util.EncoderByMd5(userPass);
		 
		User user=userService.getUserByNameOrEmail(userName);
		if(user!=null) {
			if(user.getUserPass().equals(encryption)) {
				request.getSession().setAttribute("session_user", user);
				user.setUserLastLoginTime(new Date());
				//获取ip
				InetAddress ip4=Inet4Address.getLocalHost();
				user.setUserLastLoginIp(ip4.getHostAddress());
				//添加时间和ip
				userService.updateUserLogin(user);
				//文章列表
				List<Article> articleList=articleSerivce.getArticleByStatus(6);
				//评论列表
				List<Comment> commentList=commentSerivce.getCommentLimit(6);

				request.setAttribute("articleList", articleList);
				request.setAttribute("commentList", commentList);
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
		return "forward:/user/login";
	}
	
	@RequestMapping("")
	public String getAllUser(@RequestParam(required = false,defaultValue="1") Integer pageIndex,
			@RequestParam(required = false,defaultValue = "10") Integer pageSize,
			ModelMap m){
		
		PageInfo<User> pageInfoUser=userService.getPageUserList(pageIndex,pageSize);
		m.put("pageInfo",pageInfoUser);
		m.put("pageUrlPrefix", "user?pageIndex"); 
		return "User/user-list";
	}
	
	//头像预览
	@RequestMapping("/photo")
	public void getPhoto(Integer userId, HttpServletResponse response ) throws IOException {
		User user=userService.getUserById(userId);
		
		response.setContentType("image/jpg");
		ServletOutputStream outStream =response.getOutputStream();
		if(user.getUserPhoto()!=null) {
			outStream.write(user.getUserPhoto());
			outStream.flush();
		}
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAddUser() {
		return "User/user-add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addUser(User user, MultipartFile photo) throws IOException, NoSuchAlgorithmException {
		user.setUserRegisterTime(new Date());
		user.setUserPhoto(photo.getBytes());
		//密码加密
		user.setUserPass(MD5Util.EncoderByMd5(user.getUserPass()));
		userService.addUser(user);
		return "forward:/user";
	}
	
	@RequestMapping("/del")
	public void delUser(HttpServletResponse response,Integer userId) throws IOException {
		userService.deleteUserById(userId);
		response.getWriter().println("删除成功");
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateUser(Integer userId,ModelMap m) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		User user=userService.getUserById(userId);
		m.put("user", user);
		return "User/user-update";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateUser(User user, MultipartFile photo) throws IOException {
		if(photo.getSize()!=0) {
			user.setUserPhoto(photo.getBytes());
		}
		userService.updateUser(user);
		return "forward:/user";
	}
	
	@RequestMapping("/profile")
	public String profile(HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("session_user");
		request.setAttribute("user", user);
		return "User/user-profile";
	}
}
