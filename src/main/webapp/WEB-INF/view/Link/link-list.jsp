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

        .layui-btn {
            margin: 2px 0!important;
        }
    </style>
</rapid:override>

<rapid:override name="frame-content">
	 <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a href="article/index">首页</a>
              <a><cite>链接列表</cite></a>
        </span>
    </blockquote>

    <table class="layui-table" >
        <colgroup>
            <col width="100">
            <col width="50">
            <col width="100">
            <col width="100">
            <col width="50">
            <col width="50">
            <col width="100">
            <col width="50">
        </colgroup>
        <thead>
	        <tr>
	            <th>名称</th>
	            <th>URL</th>
	            <th>联系方式</th>
	            <th>创建时间</th>
	            <th>Order</th>
	            <th>状态</th>
	            <th>操作</th>
	            <th>ID</th>
	        </tr>
        </thead>
        <tbody>
        	<c:forEach var="p" items="${pageInfo.list}">
	        	<tr>
	            	<td>${p.linkName }</td>
	                <td >
	                    <a href="${p.linkUrl }" target="_blank">${p.linkUrl }</a>
	                </td>
	                <td>${p.linkOwnerContact }</td>
	                <td><fmt:formatDate value="${p.linkCreateTime }" pattern="yyyy年MM月dd日"/></td>
	                <td>${p.linkOrder }</td>
	                <td>
	                	<c:if test="${p.linkStatus eq 1}">
	                		显示
	                	</c:if>
	                	<c:if test="${p.linkStatus eq 0}">
	                		<span style="color: red;">隐藏</span>
	                	</c:if>
	         		</td>
	                <td>
	                    <a href="link/update?linkId=${p.linkId}" class="layui-btn layui-btn-mini">编辑</a>
	                    <a href="javascript:del(${p.linkId})" class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
	                </td>
	                <td>${p.linkId}</td>
	            </tr>
            </c:forEach>
        </tbody>
    </table>
	<%@ include file="../page.jsp" %>
</rapid:override>

<rapid:override name="frame-footer-script">
	<script>
		function del(linkId){
			var result=true;
			result=confirm("确定删除吗");
			if(result==true){
				$.ajax({
					url:"link/del",
					data:{linkId:linkId},
					success:function(msg){
						alert(msg);
						window.location.href="link";
					}
				});
			}
		}
	</script>
</rapid:override>

<%@ include file="../framework.jsp" %>