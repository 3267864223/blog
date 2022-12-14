package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import blog.entity.Article;
import blog.entity.Comment;
import blog.mapper.ArticleMapper;
import blog.mapper.CommentMapper;
import blog.mapper.UserMapper;
import blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Resource
	private CommentMapper commentMapper;
	
	@Resource
	private ArticleMapper articleMapper;
	
	@Resource
	private UserMapper userMapper;

	public List<Comment> getCommentLimit(Integer n){
		List<Comment> commentList=commentMapper.getCommentLimit(n);
		for(Comment c:commentList) {
			c.setUser(userMapper.getUserByNickname(c.getCommentAuthorName()));
		}
		return commentList;
	}

	public PageInfo<Comment> getPageCommentList(Integer pageIndex, Integer pageSize) {
		PageHelper.startPage(pageIndex,pageSize);
		List<Comment> commentList = commentMapper.getAllComment();
		for(Comment c:commentList) {
			c.setArticle(articleMapper.getArticleById(c.getCommentArticleId()));
			c.setUser(userMapper.getUserByNickname(c.getCommentAuthorName()));
		}
		return new PageInfo<Comment>(commentList);	
	}

	public Comment getCommentById(Integer commentId) {
		Comment comment=commentMapper.getCommentById(commentId);
		Article article=articleMapper.getArticleById(comment.getCommentArticleId());
		comment.setArticle(article);
		return comment;
	}

	public void updateComment(Comment comment) {
		commentMapper.updateComment(comment);
	}

	public void delComment(Integer commentId) {
		commentMapper.delComment(commentId);
	}

	public void replyComment(Comment comment) {
		commentMapper.replyComment(comment);
	}
}
