package blog.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import blog.entity.Comment;

public interface CommentService {

	/**
	 * 查询评论 分页
	 * @param 
	 * @return 评论信息
	 */
	List<Comment> getCommentLimit(Integer n);

	/**
	 * 分页查询评论列表
	 * @param pageIndex 从第几页开始查
	 * @param pageSize  每页多少条
	 * @return PageInfo类型的数据,里面含有评论列表和分页相关数据
	 */
	PageInfo<Comment> getPageCommentList(Integer pageIndex, Integer pageSize);

	/**
	 * 根据commentId查询评论
	 * @param commentId
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
