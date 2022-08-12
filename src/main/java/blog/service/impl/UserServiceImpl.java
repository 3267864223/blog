package blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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

}
