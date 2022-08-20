package blog.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import blog.entity.Comment;
import blog.service.CommentService;

@Controller @RequestMapping("/comment")
public class CommentController {
	
	@Resource
	private CommentService commentService;
	
	@RequestMapping("")
	public String getAllArticle(@RequestParam(required = false,defaultValue="1") Integer pageIndex,
			@RequestParam(required = false,defaultValue = "9") Integer pageSize,
			ModelMap m){
		PageInfo<Comment> pageInfoComment=commentService.getPageCommentList(pageIndex,pageSize);
		m.put("pageInfo",pageInfoComment);
		m.put("pageUrlPrefix", "comment?pageIndex"); 
		return "Comment/comment-list";
	}
	
	@RequestMapping(value="update",method = RequestMethod.GET)
	public String toUpdateComment(Integer commentId,ModelMap m){
		Comment comment=commentService.getCommentById(commentId);
		m.put("comment", comment);
		return "Comment/comment-update";
	}
	
	@RequestMapping(value="update",method = RequestMethod.POST)
	public String updateComment(Comment comment){
		commentService.updateComment(comment);
		return "forward:/comment";
	}
	
	@RequestMapping("/del")
	public void delComment(Integer commentId,HttpServletResponse response) throws IOException{
		commentService.delComment(commentId);
		response.getWriter().print("删除成功");
	}
	
	@RequestMapping(value="reply",method = RequestMethod.GET)
	public String toReplyComment(Integer commentId,ModelMap m){
		Comment comment=commentService.getCommentById(commentId);
		m.put("comment", comment);
		return "Comment/comment-replay";
	}
	
	@RequestMapping(value="reply",method = RequestMethod.POST)
	public String ReplyComment(Comment comment,ModelMap m,HttpServletRequest request){
		comment.setCommentCreateTime(new Date());
		commentService.replyComment(comment);
		return "forward:/comment";
	}
}
