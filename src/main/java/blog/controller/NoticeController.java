package blog.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import blog.entity.Notice;
import blog.service.NoticeService;

@Controller @RequestMapping("/notice")
public class NoticeController {

	@Resource
	private NoticeService noticeService;
	
	@RequestMapping("")
	public String getAllNotice(@RequestParam(required = false,defaultValue="1") Integer pageIndex,
			@RequestParam(required = false,defaultValue = "10") Integer pageSize,
			ModelMap m){
		PageInfo<Notice> pageInfoNotice=noticeService.getPageNoticeList(pageIndex,pageSize);
		m.put("pageInfo",pageInfoNotice);
		m.put("pageUrlPrefix", "notice?pageIndex"); 
		return "Notice/notice-list";
	}
	
	@RequestMapping("/toAdd")
	public String toAddNotice() {
		return "Notice/notice-add";
	}
	
	@RequestMapping("/add")
	public String addNotice(Notice notice) {
		notice.setNoticeCreateTime(new Date());
		notice.setNoticeUpdateTime(new Date());
		notice.setNoticeOrder(1);
		notice.setNoticeStatus(1);
		noticeService.addNotice(notice);
		return "forward:/notice";
	}
	
	@RequestMapping("/toUpdate")
	public String toUpdateNotice(Integer noticeId,ModelMap m) {
		Notice notice=noticeService.getNoticeById(noticeId);
		m.put("notice", notice);
		return "Notice/notice-update";
	}
	
	@RequestMapping("/update")
	public String updateNotice(Notice notice) {
		notice.setNoticeUpdateTime(new Date());
		noticeService.updateNotice(notice);
		return "forward:/notice";
	}
	
	@RequestMapping("/del")
	public void del(HttpServletResponse response,Integer noticeId) throws IOException {
		noticeService.deleteNotice(noticeId);
		response.getWriter().println("删除成功");
	}
}
