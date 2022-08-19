<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<rapid:override name="frame-header-style">
	<style>
        /*覆盖 layui*/
        .layui-table {
            margin-top: 0;
        }
    </style>
</rapid:override>

<rapid:override name="frame-content">
	<blockquote class="layui-elem-quote">
		<span class="layui-breadcrumb" lay-separator="/"> <a
			href="article/index">首页</a> <a><cite>评论列表</cite></a>
		</span>
	</blockquote>
	
	<div class="layui-tab layui-tab-card">
		<form id="articleForm" method="post">
			<input type="hidden" name="currentUrl" id="currentUrl" value="">
			<table class="layui-table"  lay-size="lg">
				<colgroup>
					<col width="100">
					<col width="200">
					<col width="270">
					<col width="150">
					<col width="100">
					<col width="100">
					<col width="100">
					<col width="50">
				</colgroup>
				<thead>
					<tr>
						<th>作者</th>
						<th>评论内容</th>
						<th>回复至</th>
						<th>提交于</th>
						<th>作者网址</th>
						<th>作者邮箱</th>
						<th>作者ip</th>
						<th>ID</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${pageInfo.list}">
						<tr>
                    		<td>
                        		<!--  <img src="${p.commentAuthorAvatar }" alt="" width="64px">-->
                        		<strong>${p.commentAuthorName }</strong>
                            </td>
                    		<td class="dashboard-comment-wrap">
                    			<c:if test="${p.commentPid eq 0}">
                    				${p.commentContent }
                    			</c:if>
                    			<c:if test="${p.commentPid != 0}">
                    				<span class="at">@</span><a href="${p.commentAuthorUrl }">${p.commentPname }</a> &nbsp;${p.commentContent }
                    			</c:if>
                        		<div class="row-actions">
                                    <span class="">
                                    	<a href="comment/reply?commentId=${p.commentId }">回复</a>
                                    </span>
                            		<span class=""> |
                                        <a href="comment/update?commentId=${p.commentId }">编辑</a>
                                    </span>
                            		<span class=""> |
                                        <a href="javascript:del(${p.commentId })">删除</a>
                                    </span>
                        		</div>
                    		</td>
                    		<td>
                        		<a href="/article/${p.commentArticleId }" target="_blank">${p.article.articleTitle }</a>
                    		</td>
		                    <td>
		                        <fmt:formatDate value="${p.commentCreateTime }" pattern="yyyy年MM月dd日 HH:mm:ss"/>
		                    </td>
		                    <td>
		                    	${p.commentAuthorUrl }
		                    </td>
		                    <td>
		                    	${p.commentAuthorEmail }
		                    </td>
		                    <td>
		                    	${p.commentIp }
		                    </td>
		                    <td>${p.commentId }</td>
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
		function del(commentId){
			var result=true;
			result=confirm("确定删除吗");
			if(result==true){
				$.ajax({
					url:"comment/del",
					data:{commentId:commentId},
					success:function(msg){
						alert(msg);
						window.location.href="comment";
					}
				});
			}
		}
	</script>
</rapid:override>

<%@ include file="../framework.jsp" %>