package blog.mapper;

import java.util.List;

import blog.entity.Notice;

public interface NoticeMapper {

	/**
	 * 查询所有公告
	 * @return 公告列表
	 */
	List<Notice> getAllNotice();

	/**
	 * 添加公告
	 * @param 公告信息
	 */
	void addNotice(Notice notice);

	/**
	 * 根据noticeId查询公告
	 * @param noticeId
	 * @return 公告信息
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
