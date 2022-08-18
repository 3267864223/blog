package blog.mapper;

import java.util.List;

import blog.entity.User;

public interface UserMapper {
	
	/**
	 * 根据用户名或邮箱查询用户
	 * @param str 用户账号或邮箱 
	 * @return 用户信息
	 */
	User getUserByNameOrEmail(String str);
	
	/**
	 * 查询所有用户
	 * @return 用户信息列表
	 */
	List<User> getAllUser();

	/**
	 *根据userId查询用户
	 * @param userId
	 * @return 用户信息
	 */
	User getUserById(Integer userId);

	/**
	 *添加用户
	 * @param 用户信息
	 */
	void addUser(User user);
	
	/**
	 *查询用户文章数量
	 * @param userId
	 */
	Integer getUserArticleCount(Integer userId);

	/**
	 *根据userId删除用户
	 * @param userId
	 */
	void deleteUserById(Integer userId);

	/**
	 *更新用户（有图片更新）
	 * @param 用户信息
	 */
	void updateUserHavePhoto(User user);

	/**
	 *更新用户（无图片更新）
	 * @param 用户信息
	 */
	void updateUser(User user);
}
