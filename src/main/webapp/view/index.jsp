<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<rapid:override name="frame-header-style">
	<link rel="stylesheep" href="resources/css/index-page.css"></link>
</rapid:override>
<rapid:override name="frame-header-script">
	
</rapid:override>

<rapid:override name="frame-content">
	<div class="layui-container">
		<div class="layui-row">
			<div class="layui-col-md6">
				<div id="dashboard_activity" class="postbox ">
					<div class="inside">
						<div id="activity-widget">
							<div id="published-posts" class="activity-block">
								<h3>最近发布</h3>
								<br>
								<ul>
									<c:forEach var="a" items="${articleList }">
										<li><span><fmt:formatDate pattern="HH:mm M月dd日" value="${a.articleUpdateTime }"/>  </span> <a href="/article/${a.articleId }"	target="_blank">${a.articleTitle }</a></li>
									</c:forEach>
								</ul>	
							</div>
							<br>
							<div id="latest-comments" class="activity-block">
								<h3>近期评论</h3>
								<ul id="the-comment-list" data-wp-lists="list:comment">
									<c:forEach var="c" items="${commentList }">
										<li class="comment   thread-even comment-item approved"><img
											alt=""
											src="${c.commentAuthorAvatar }"
											class="avatar avatar-50 photo" height="50" width="50">
											<div class="dashboard-comment-wrap has-row-actions">
												<p class="comment-meta">
													由<cite class="comment-author"> <a target="_blank"
														href="" rel="external nofollow" class="url">${c.commentAuthorName }</a>
													</cite>发表在 《<a href="/article/6">${c.article.articleTitle }</a>》
												</p>
	
												<blockquote>
													<p>${c.commentContent }</p>
												</blockquote>
												<p class="row-actions">
													| <span class=""> <a data-comment-id="1268"
														href="/admin/comment/reply/29"> 回复 </a>
													</span> <span class=""> | <a href="/admin/comment/edit/29">编辑</a>
													</span> <span class=""> | <a href="javascript:void(0)"
														onclick="deleteComment(29)">删除</a>
													</span>
												</p>
											</div>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="layui-col-md6">
				<div id="dashboard_quick_press" class="postbox ">
					<div class="inside">
						<form name="post" method="post" id="insertDraftForm"
							class="initial-form hide-if-no-js"
							action="article/insertDraftSubmit">

							<div class="layui-form-item">
								<div class="layui-input-block">
									<input type="text" name="articleTitle" id="articleTitle"
										required lay-verify="required" placeholder="请输入标题"
										autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item layui-form-text">
								<div class="layui-input-block">
									<textarea name="articleContent" placeholder="请输入内容"
										id="articleContent" class="layui-textarea" required></textarea>
								</div>
							</div>
							<input type="hidden" name="articleStatus" value="0">
							<input type="hidden" name="articleUserId" value="${session_user.userId }">
							<div class="layui-form-item">
								<div class="layui-input-block">
									<button type="submit" class="layui-btn layui-btn-small" lay-submit
										lay-filter="formDemo" >保存草稿</button>
									<button type="reset"
										class="layui-btn layui-btn-small layui-btn-primary">重置</button>
								</div>
							</div>

						</form>
						<div class="drafts">
							<p class="view-all">
								<a href="/admin/article" aria-label="查看所有草稿">查看所有</a>
							</p>
							<h2 class="hide-if-no-js">草稿</h2>
							<ul>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</rapid:override>

<rapid:override name="frame-footer-script">
	<script>
	
	</script>
</rapid:override>

<%@include file="framework.jsp"%>