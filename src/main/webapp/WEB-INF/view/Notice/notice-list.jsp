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
			<a href="articel/index">首页</a>
			<a><cite>公告列表</cite></a>
		</span>
	</blockquote>
    <table class="layui-table" >
	    <colgroup>
	        <col width="400">
	        <col width="50">
	        <col width="100">
	        <col width="100">
	        <col width="50">
	    </colgroup>
        <thead>
	        <tr>
	            <th>标题</th>
	            <th>Order</th>
	            <th>状态</th>
	            <th>操作</th>
	            <td>ID</td>
	        </tr>
        </thead>
        <tbody>
        	<c:forEach var="p" items="${pageInfo.list}">
		        <tr>
	               <td>
	                   <a href="/notice/${p.noticeId }" target="_blank">${p.noticeTitle }</a>
	               </td>
	               <td>${p.noticeOrder }</td>
	               <td>
		               <c:if test="${p.noticeStatus eq 1}">
		               		显示
		               </c:if>
		               <c:if test="${p.noticeStatus eq 0}">
		               		<span style="color: red;">隐藏</span>
		               </c:if>
	               </td>
	               <td>
	                   <a href="notice/toUpdate?noticeId=${p.noticeId }" class="layui-btn layui-btn-mini">编辑</a>
	                   <a href="javascript:del(${p.noticeId })" class="layui-btn layui-btn-danger layui-btn-mini" >删除</a>
	               </td>
	               <td>${p.noticeId }</td>
				</tr>
			</c:forEach>
        </tbody>
    </table>
    <blockquote class="layui-elem-quote layui-quote-nm">温馨提示：
	    <ul>
       		<li>Order的大小决定显示的顺序</li>
	    </ul>
    </blockquote>
	<%@ include file="../page.jsp" %>
</rapid:override>

<rapid:override name="frame-footer-script">
	<script>
		function del(noticeId){
			var result=true;
			result=confirm("确定删除吗");
			if(result==true){
				$.ajax({
					url:"notice/del",
					data:{noticeId:noticeId},
					success:function(msg){
						alert(msg);
						window.location.href="notice";
					}
				});
			}
		}
	</script>
</rapid:override>

<%@ include file="../framework.jsp" %>