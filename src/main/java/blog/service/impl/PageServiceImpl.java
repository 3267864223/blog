package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.entity.Page;
import blog.mapper.PageMapper;
import blog.service.PageService;

@Service
public class PageServiceImpl implements PageService{

	@Resource
	private PageMapper pageMapper;

	public List<Page> getAllPage() {
		return pageMapper.getAllPage();
	}

	public Page getPageById(Integer pageId) {
		return pageMapper.getPageById(pageId);
	}

	public void addPage(Page page) {
		pageMapper.addPage(page);
	}

	public void updatePage(Page page) {
		pageMapper.updatePage(page);
	}

	public void deletePage(Integer pageId) {
		pageMapper.deletePage(pageId);
	}
}
