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
          <a href="/admin">首页</a>
          <a><cite>页面列表</cite></a>
        </span>
    </blockquote>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>页面列表</legend>
    </fieldset>
	    <table class="layui-table">
	        <colgroup>
	            <col width="50">
	            <col width="50">
	            <col width="100">
	            <col width="200">
	            <col width="50">
	            <col width="100">
	        </colgroup>
	        <thead>
	         <tr>
	             <th>id</th>
	             <th>key</th>
	             <th>标题</th>
	             <th>内容</th>
	             <th>状态</th>
	             <th>操作</th>
	         </tr>
	        </thead>
	        <tbody>
		        <c:forEach var="p" items="${pageList }">
			        <c:if test="${p.pageStatus != 2}">
				        <tr>
							<td>${p.pageId }</td>
							<td>${p.pageKey }</td>
							<td>${p.pageTitle }</td>
							<td>
							    <a href="/${p.pageKey }" target="_blank">${p.pageSummary }</a>
							</td>
							<td>
								<c:if test="${p.pageStatus eq 1}">
									显示
								</c:if>
								<c:if test="${p.pageStatus eq 0}">
									<span style="color: red;">隐藏</span>
								</c:if>
						    </td>
						    <td>
						        <a href="page/toUpdate?pageId=${p.pageId }" class="layui-btn layui-btn-mini">编辑</a>
						        <a href="javascript:del(${p.pageId })" class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
						    </td>
						</tr>
			        </c:if>
		        </c:forEach>
	    	</tbody>
	    </table>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>自定义页面</legend>
    </fieldset>
    <div class="layui-form">
        <table class="layui-table" style="width: 40%;">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
	            <tr>
	                <th>别名</th>
	                <th>标题</th>
	                <th>内容</th>
	            </tr>
            </thead>
            <tbody>
            	<c:forEach var="p" items="${pageList }">
            		<c:if test="${p.pageStatus eq 2}">
            			<tr>
			                <td>${p.pageKey }</td>
			                <td>${p.pageTitle }</td>
			                <td><a href="/${p.pageKey }" target="_blank">点击查看</a></td>
			            </tr>
            		</c:if>
            	</c:forEach>
        	</tbody>
        </table>
    </div>
    <blockquote class="layui-elem-quote layui-quote-nm">温馨提示：<br>
        1、自定义的页面，无法删除，别名已写入控制器
    </blockquote>
</rapid:override>

<rapid:override name="frame-footer-script">
	<script>
		function del(pageId){
			var result=true;
			result=confirm("确定删除吗");
			if(result==true){
				$.ajax({
					url:"page/del",
					data:{pageId:pageId},
					success:function(msg){
						alert(msg);
						window.location.href="page";
					}
				});
			}
		}
	</script>
</rapid:override>

<%@ include file="../framework.jsp" %>