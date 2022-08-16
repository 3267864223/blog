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
}
