<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<rapid:override name="frame-content">
	<blockquote class="layui-elem-quote">
		<span class="layui-breadcrumb" lay-separator="/"> <a
			href="/admin">首页</a> <a><cite>文章列表</cite></a>
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
					<col width="50">
				</colgroup>
				<thead>
					<tr>
						<th>标题</th>
						<th>所属分类</th>
						<th>状态</th>
						<th>发布时间</th>
						<th>操作</th>
						<th>id</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="a" items="${pageInfo.list}">
						<tr>
							<td><a href="/article/${a.articleId }" target="_blank"> ${a.articleTitle }</a></td>
							<td>
								<c:forEach var="c" items="${cateList}">
									<c:if test="${a.articleId eq c.articleId}">
										<a href="/category/${c.categoryList[0].categoryId}" target="_blank">${c.categoryList[0].categoryName}</a>&nbsp;
										<a href="/category/${c.categoryList[1].categoryId}" target="_blank">${c.categoryList[1].categoryName}</a>&nbsp;
									</c:if>
								</c:forEach>
							</td>
							<td>
								<c:if test="${a.articleStatus==1 }">
							     <a href="/admin/article?status=1"><span style="color: #5FB878;">已发布</span></a>
							     </c:if>
							     
							     <c:if test="${a.articleStatus==0 }">
							     <a href="/admin/article?status=0"><span style="color: red;">草稿</span></a>
							     </c:if>
						    </td>
							<td> <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${a.articleUpdateTime }" /></td>
							<td>
								<a href="article/update?articleId=${a.articleId }" class="layui-btn layui-btn-mini">编辑</a> 
								<a href="javascript:del(${a.articleId })" class="layui-btn layui-btn-danger layui-btn-mini" >删除</a>
							</td>	
							<td>${a.articleId }</td>
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
		function del(articleId){
			var result=true;
			result=confirm("确定删除吗");
			if(result==true){
				$.ajax({
					url:"article/del",
					data:{articleId:articleId},
					success:function(msg){
						alert(msg);
						window.location.href="article";
					}
				});
			}
		}
	</script>
</rapid:override>

<%@ include file="../framework.jsp" %>