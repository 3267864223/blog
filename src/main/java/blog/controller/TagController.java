package blog.controller;


import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import blog.entity.Tag;
import blog.service.TagService;

@Controller @RequestMapping("/tag")
public class TagController {

	@Resource
	private TagService tagService;
	
	@RequestMapping("")
	public String getAllArticle(ModelMap m){
		List<Tag> tagList=tagService.getAllTag();
		m.put("tagList", tagList);
		return "Tag/tag-list";
	}
	
	@ResponseBody @RequestMapping("/toUpdate")
	public Tag toUpdateTag(Integer tagId){
		return tagService.getTagById(tagId);
	}
	
	@RequestMapping("/insertSubmit")
	public String insertSubmit(Tag tag){
		//修改
		if(tag.getTagId()!=null) {
			tagService.updateTag(tag);
		}
		//添加
		else {
			tagService.addTag(tag);
		}
		return "forward:/tag";
	}
	
	@RequestMapping("/del")
	public void deleteTag(Integer tagId,HttpServletResponse response) throws IOException{
		tagService.deleteTag(tagId);
		response.getWriter().print("删除成功");
	}
}
