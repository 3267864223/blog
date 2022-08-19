<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<rapid:override name="frame-content">
	<blockquote class="layui-elem-quote">
		<span class="layui-breadcrumb" lay-separator="/"> <a
			href="article/index">首页</a> <a><cite>用户列表</cite></a>
		</span>
	</blockquote>
	
	<div class="layui-tab layui-tab-card">
		<form id="articleForm" method="post">
			<input type="hidden" name="currentUrl" id="currentUrl" value="">
			<table class="layui-table">
				<colgroup>
					<col width="300">
					<col width="150">
					<col width="100">
					<col width="150">
					<col width="100">
					<col width="100">
					<col width="50">
				</colgroup>
				<thead>
					<tr>
						<th>用户名</th>
						<th>昵称</th>
						<th>电子邮件</th>
						<th>文章数量</th>
						<th>状态</th>
						<th>操作</th>
						<th>ID</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${ pageInfo.list}">
						<tr>
							<td>
								<img src="user/photo?userId=${p.userId }" width="48" height="48"> 
								 <strong><a href="user/edit/${p.userId}">${p.userName}</a></strong>
							</td>
							<td>${p.userNickname}</td>
							<td>${p.userEmail}</td>
							<td>${p.articleCount}</td>
							<td>
								<c:choose>
									<c:when test="${p.userStatus==0}">
										<span style="color: #FF5722;">禁用</span>
									</c:when>
									<c:otherwise>
			                    		正常
			                 		</c:otherwise>
								</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when test="${p.userId != session_user.userId}">
										<a href="user/update?userId=${p.userId}" class="layui-btn layui-btn-mini">编辑</a>
										<a href="javascript:del(${p.userId})" class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
									</c:when>
									<c:otherwise>
			                 		</c:otherwise>
								</c:choose>
							</td>
							<td>${p.userId}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<%@ include file="../page.jsp" %>
	</div>
</rapid:override>

<rapid:override name="frame-footer-script">
	<script>
		function del(userId){
			var result=true;
			result=confirm("确定删除吗");
			if(result==true){
				$.ajax({
					url:"user/del",
					data:{userId:userId},
					success:function(msg){
						alert(msg);
						window.location.href="user";
					}
				});
			}
		}
	</script>
</rapid:override>

<%@ include file="../framework.jsp" %>