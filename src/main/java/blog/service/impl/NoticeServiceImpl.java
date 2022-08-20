package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import blog.entity.Notice;
import blog.mapper.NoticeMapper;
import blog.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Resource
	private NoticeMapper noticeMapper;

	public PageInfo<Notice> getPageNoticeList(Integer pageIndex, Integer pageSize) {
		PageHelper.startPage(pageIndex,pageSize);
		List<Notice> noticeList = noticeMapper.getAllNotice();
		return new PageInfo<Notice>(noticeList);
	}

	public void addNotice(Notice notice) {
		noticeMapper.addNotice(notice);
	}

	public Notice getNoticeById(Integer noticeId) {
		return noticeMapper.getNoticeById(noticeId);
	}

	public void updateNotice(Notice notice) {
		noticeMapper.updateNotice(notice);
	}

	public void deleteNotice(Integer noticeId) {
		noticeMapper.deleteNotice(noticeId);
	}

}
