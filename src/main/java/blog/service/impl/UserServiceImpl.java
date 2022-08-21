package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import blog.entity.User;
import blog.mapper.UserMapper;
import blog.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;

	public User getUserByNameOrEmail(String str) {
		return userMapper.getUserByNameOrEmail(str);
	}

	public PageInfo<User> getPageUserList(Integer pageIndex, Integer pageSize) {
		PageHelper.startPage(pageIndex,pageSize);
		
		List<User>  userList = userMapper.getAllUser();
		for(User u:userList) {
			u.setArticleCount(userMapper.getUserArticleCount(u.getUserId()));
		}
		return new PageInfo<User>(userList);	
	}

	public User getUserById(Integer userId) {
		return userMapper.getUserById(userId);
	}

	public void addUser(User user) {
		userMapper.addUser(user);
	}

	public void deleteUserById(Integer userId) {
		userMapper.deleteUserById(userId);
		
	}

	public void updateUser(User user) {
		if(user.getUserPhoto()!=null) {
			userMapper.updateUserHavePhoto(user);
		}else {
			userMapper.updateUser(user);
		}
		
	}

	public void updateUserLogin(User user) {
		userMapper.updateUserLogin(user);
	}

}
