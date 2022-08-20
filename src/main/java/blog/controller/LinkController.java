package blog.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import blog.entity.Link;
import blog.service.LinkService;

@Controller @RequestMapping("/link")
public class LinkController {
	
	@Resource
	private LinkService linkService;

	@RequestMapping("")
	public String getAllLink(@RequestParam(required = false,defaultValue="1") Integer pageIndex,
			@RequestParam(required = false,defaultValue = "10") Integer pageSize,
			ModelMap m){
		PageInfo<Link> pageInfoLink=linkService.getPageLinkList(pageIndex,pageSize);
		m.put("pageInfo",pageInfoLink);
		m.put("pageUrlPrefix", "link?pageIndex"); 
		return "Link/link-list";
	}
	
	@RequestMapping("/update")
	public String toUpdateLink(Integer linkId,ModelMap m) {
		Link link=linkService.getLinkById(linkId);
		List<Link> linkList=linkService.getAllLink();
		m.put("link", link);
		m.put("linkList", linkList);
		return "Link/link-update";
	}
	
	@RequestMapping("/editSubmit")
	public String UpdateLink(Link link,ModelMap m) {
		link.setLinkUpdateTime(new Date());
		linkService.updateLink(link);
		m.put("linkId", link.getLinkId());
		return "forward:/link/update";
	}
	
	@RequestMapping("/del")
	public void del(HttpServletResponse response,Integer linkId) throws IOException {
		linkService.deleteLinkById(linkId);
		response.getWriter().println("删除成功");
	}
	
	@RequestMapping("/toAdd")
	public String toAddLink(Integer linkId,ModelMap m) {
		List<Link> linkList=linkService.getAllLink();
		m.put("linkList", linkList);
		return "Link/link-add";
	}
	
	@RequestMapping("/add")
	public String addLink(Link link,ModelMap m) {
		link.setLinkCreateTime(new Date());
		link.setLinkUpdateTime(new Date());
		linkService.addLink(link);
		m.put("linkId", link.getLinkId());
		return "forward:/link/toAdd";
	}
}
