package blog.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.service.CommentService;

@Controller @RequestMapping("/comment")
public class CommentController {
	
	@Resource
	private CommentService commentService;
}
