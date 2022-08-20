package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import blog.entity.Link;
import blog.mapper.LinkMapper;
import blog.service.LinkService;

@Service
public class LinkServiceImpl implements LinkService{
	
	@Resource
	private LinkMapper linkMapper;

	public PageInfo<Link> getPageLinkList(Integer pageIndex, Integer pageSize) {
		PageHelper.startPage(pageIndex,pageSize);
		List<Link> linkList = linkMapper.getAllLink();
		return new PageInfo<Link>(linkList);
	}

	public Link getLinkById(Integer linkId) {
		return linkMapper.getLinkById(linkId);
	}

	public List<Link> getAllLink() {
		return linkMapper.getAllLink();
	}

	public void updateLink(Link link) {
		linkMapper.updateLink(link);
	}

	public void deleteLinkById(Integer linkId) {
		linkMapper.deleteLink(linkId);
	}

	public void addLink(Link link) {
		linkMapper.addLink(link);
	}

}
