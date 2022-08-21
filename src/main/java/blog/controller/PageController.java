package blog.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.entity.Page;
import blog.service.PageService;
import cn.hutool.http.HtmlUtil;

@Controller @RequestMapping("/page")
public class PageController {

	@Resource
	private PageService pageService;
	
	@RequestMapping("")
	public String getAllPage(ModelMap m){
		List<Page> pageList=pageService.getAllPage();
		m.put("pageList", pageList);
		return "Page/page-list";
	}
	
	@RequestMapping("/toAdd")
	public String toAddPage() {
		return "Page/page-add";
	}
	
	@RequestMapping("/add")
	public String addLink(Page page,ModelMap m) {
		page.setPageCreateTime(new Date());
		page.setPageUpdateTime(new Date());
		page.setPageStatus(1);
		//页面内容摘要(hutu 工具包)
		String s= HtmlUtil.cleanHtmlTag(page.getPageContent());
		page.setPageSummary(s.length()>20?s.substring(0,20):s);
		pageService.addPage(page);
		return "forward:/page";
	}
	
	@RequestMapping("/toUpdate")
	public String toUpdatePage(Integer pageId,ModelMap m) {
		Page page=pageService.getPageById(pageId);
		m.put("page", page);
		return "Page/page-update";
	}
	
	@RequestMapping("/update")
	public String updatePage(Page page) {
		page.setPageUpdateTime(new Date());
		//页面内容摘要(hutu 工具包)
		String s= HtmlUtil.cleanHtmlTag(page.getPageContent());
		page.setPageSummary(s.length()>20?s.substring(0,20):s);
		pageService.updatePage(page);
		return "forward:/page";
	}
	
	@RequestMapping("/del")
	public void deletePage(Integer pageId,HttpServletResponse response) throws IOException {
		pageService.deletePage(pageId);
		response.getWriter().print("删除成功");
	}
	
}
