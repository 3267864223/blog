package blog.mapper;

import java.util.List;

import blog.entity.Comment;

public interface CommentMapper {
	
	/**
	 * 查询评论 分页
	 * @param 
	 * @return 评论信息
	 */
	List<Comment> getCommentLimit(Integer n);

	/**
	 * 查询全部评论
	 * @param 
	 * @return 评论信息列表
	 */
	List<Comment> getAllComment();

	/**
	 * 根据commentId查询评论
	 * @param commentI
	 * @return 评论信息
	 */
	Comment getCommentById(Integer commentId);

	/**
	 * 修改评论
	 * @param 评论信息
	 */
	void updateComment(Comment comment);

	/**
	 * 删除评论
	 * @param commentId
	 */
	void delComment(Integer commentId);

	/**
	 * 回复评论
	 * @param 评论信息
	 */
	void replyComment(Comment comment);
}
