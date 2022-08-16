package blog.service;

import java.util.List;

import blog.entity.Comment;

public interface CommentService {

	/**
	 * 查询评论 分页
	 * @param 
	 * @return 评论信息
	 */
	List<Comment> getCommentLimit(Integer n);
}
