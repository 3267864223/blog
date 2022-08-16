package blog.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Article {
	
	private Integer articleId;

	// 创建文章的用户
	private Integer articleUserId;

	// 文章标题
	private String articleTitle;

	// 浏览次数
	private Integer articleViewCount;

	// 回复次数
	private Integer articleCommentCount;

	// 点赞次数
	private Integer articleLikeCount;

	// 创建时间
	private Date articleCreateTime;

	// 更新时间
	private Date articleUpdateTime;

	// 是否回复
	private Integer articleIsComment;

	// 状态 (0 草稿,1 已发布)
	private Integer articleStatus;

	// 排序
	private Integer articleOrder;

	// 文章内容
	private String articleContent;

	// 言章概要 (就是文章内容把格式标签去掉,再取前多少位的内容)
	private String articleSummary;

	// 用户
	private User user;
	
	//该文章属于哪些分类
	private List<Category> categoryList;
	
	//文章挂有哪些标签
	private List<Tag> tagList;

}
