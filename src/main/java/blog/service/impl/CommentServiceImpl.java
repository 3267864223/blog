package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.entity.Comment;
import blog.mapper.CommentMapper;
import blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Resource
	private CommentMapper commentMapper;

	/**
	 * 查询评论 分页
	 * @param 
	 * @return 评论信息
	 */
	public List<Comment> getCommentLimit(Integer n){
		return commentMapper.getCommentLimit(n);
	}
}
