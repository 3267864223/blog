package blog.mapper;

import blog.entity.User;

public interface UserMapper {
	
	/**
	 * 根据用户名或邮箱查询用户
	 * @param str 用户账号或邮箱 
	 * @return 用户信息
	 */
	User getUserByNameOrEmail(String str);
}
