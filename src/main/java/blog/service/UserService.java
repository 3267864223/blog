package blog.service;

import com.github.pagehelper.PageInfo;

import blog.entity.User;

public interface UserService {

	/**
	 * 根据用户名或邮箱查询用户
	 * @param str 用户账号或邮箱 
	 * @return 用户信息
	 */
	User getUserByNameOrEmail(String str);

	/**
	 * 分页查询用户列表
	 * @param pageIndex 从第几页开始查
	 * @param pageSize  每页多少条
	 * @return PageInfo类型的数据,里面含有用户列表和分页相关数据
	 */
	PageInfo<User> getPageUserList(Integer pageIndex, Integer pageSize);

	/**
	 * 根据userId查询用户
	 * @param userId
	 * @return 用户信息
	 */
	User getUserById(Integer userId);

	/**
	 * 添加用户
	 * @param 用户信息
	 */
	void addUser(User user);

	/**
	 * 根据userId删除用户
	 * @param userId
	 */
	void deleteUserById(Integer userId);

	/**
	 * 编辑用户
	 * @param 用户信息
	 */
	void updateUser(User user);

	/**
	 * 更新用户登录时间和ip
	 * @param 用户信息
	 */
	void updateUserLogin(User user);

}
