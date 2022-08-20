package blog.service;

import com.github.pagehelper.PageInfo;

import blog.entity.Notice;

public interface NoticeService {

	/**
	 * 分页查询公告列表
	 * @param pageIndex 从第几页开始查
	 * @param pageSize  每页多少条
	 * @return PageInfo类型的数据,里面含有公告列表和分页相关数据
	 */
	PageInfo<Notice> getPageNoticeList(Integer pageIndex, Integer pageSize);

	/**
	 * 添加公告
	 * @param 公告信息
	 */
	void addNotice(Notice notice);

	/**
	 * 根据noticeId查询公告
	 * @param noticeId
	 *  @return 公告信息
	 */
	Notice getNoticeById(Integer noticeId);

	/**
	 * 修改公告
	 * @param 公告信息
	 */
	void updateNotice(Notice notice);
	
	/**
	 * 删除公告
	 * @param noticeId
	 */
	void deleteNotice(Integer noticeId);

}
