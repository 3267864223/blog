package blog.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern="HH:mm MM月dd日",timezone="GMT+8")
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

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getArticleUserId() {
		return articleUserId;
	}

	public void setArticleUserId(Integer articleUserId) {
		this.articleUserId = articleUserId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public Integer getArticleViewCount() {
		return articleViewCount;
	}

	public void setArticleViewCount(Integer articleViewCount) {
		this.articleViewCount = articleViewCount;
	}

	public Integer getArticleCommentCount() {
		return articleCommentCount;
	}

	public void setArticleCommentCount(Integer articleCommentCount) {
		this.articleCommentCount = articleCommentCount;
	}

	public Integer getArticleLikeCount() {
		return articleLikeCount;
	}

	public void setArticleLikeCount(Integer articleLikeCount) {
		this.articleLikeCount = articleLikeCount;
	}

	public Date getArticleCreateTime() {
		return articleCreateTime;
	}

	public void setArticleCreateTime(Date articleCreateTime) {
		this.articleCreateTime = articleCreateTime;
	}

	public Date getArticleUpdateTime() {
		return articleUpdateTime;
	}

	public void setArticleUpdateTime(Date articleUpdateTime) {
		this.articleUpdateTime = articleUpdateTime;
	}

	public Integer getArticleIsComment() {
		return articleIsComment;
	}

	public void setArticleIsComment(Integer articleIsComment) {
		this.articleIsComment = articleIsComment;
	}

	public Integer getArticleStatus() {
		return articleStatus;
	}

	public void setArticleStatus(Integer articleStatus) {
		this.articleStatus = articleStatus;
	}

	public Integer getArticleOrder() {
		return articleOrder;
	}

	public void setArticleOrder(Integer articleOrder) {
		this.articleOrder = articleOrder;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticleSummary() {
		return articleSummary;
	}

	public void setArticleSummary(String articleSummary) {
		this.articleSummary = articleSummary;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
