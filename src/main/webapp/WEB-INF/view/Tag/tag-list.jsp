<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<rapid:override name="frame-header-style">
	<style>
        /*覆盖 layui*/
        .layui-input-block {
            margin:0px 10px;
        }
        .layui-table {
            margin-top: 0;
        }
        .layui-col-md4 {
            padding:10px;
        }
        .layui-col-md8 {
            padding:10px;
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
	        <a><cite>标签列表</cite></a>
        </span>
    </blockquote>
    <div class="layui-row">
        <div class="layui-col-md4">
            <form class="layui-form"  method="post" id="myForm" action="tag/insertSubmit">
            	<input id="tagId" type="hidden" name="tagId">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <strong>添加标签</strong>
                    </div>
                    <div class="layui-input-block">名称
                    	<span style="color: #FF5722; ">*</span>
                    	<input id="tagName" type="text" name="tagName" placeholder="请输入标签名称" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">标签描述
                        <input id="tagDescription" type="text" name="tagDescription" placeholder="请输入标签描述" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        <button id="subBtn" class="layui-btn" lay-filter="formDemo" type="submit">添加</button>
                    </div>
                </div>
            </form>
            <blockquote class="layui-elem-quote layui-quote-nm">温馨提示：
                <ul>
                    <li>1、标签名必选，建议不要太长</li>
                    <li>2、标签名勿重复</li>
                </ul>
            </blockquote>
        </div>
        <div class="layui-col-md8" >
            <table class="layui-table" >
                <colgroup>
                    <col width="300">
                    <col width="50">
                    <col width="100">
                    <col width="50">
                </colgroup>
                <thead>
                <tr>
                    <th>名称</th>
                    <th>文章数</th>
                    <th>操作</th>
                    <th>ID</th>
                </tr>
                </thead>
                <tbody>
	                <c:forEach var="t" items="${tagList }">
	                	<tr>
		                    <td>
		                        <a href="/tag/${t.tagId }" target="_blank">${t.tagName }</a>
		                    </td>
		                    <td >
		                        <a href="/tag/${t.tagId }" target="_blank"  lay-data="{sort:true}">${t.articleCount }</a>
		                    </td>
		                    <td>
		                    	<c:if test="${t.articleCount eq 0 }">
			                        <a href="javascript:toUpdate(${t.tagId })" class="layui-btn layui-btn-mini">编辑</a>
			                        <a href="javascript:del(${t.tagId })" class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
		                        </c:if>
		                        <c:if test="${t.articleCount != 0 }">
			                        <a href="javascript:toUpdate(${t.tagId })" class="layui-btn layui-btn-mini">编辑</a>
		                        </c:if>
		                    </td>
		                    <td>${t.tagId }</td>
		                </tr>
	                </c:forEach>
                </tbody>
            </table>
            <blockquote class="layui-elem-quote layui-quote-nm">温馨提示：
	            <ul>
	                <li>如果该标签包含文章，将不可删除</li>
	            </ul>
            </blockquote>
        </div>
    </div>
</rapid:override>

<rapid:override name="frame-footer-script">
	<script>
		function toUpdate(tagId){
			$.ajax({
				url:"tag/toUpdate",
				data:{tagId:tagId},
				success:function(tag){
					$("#tagId").val(tag.tagId);
					$("#tagName").val(tag.tagName);
					$("#tagDescription").val(tag.tagDescription);
					$("#subBtn").html("编辑");
				}
			});
		}
		function del(tagId){
			var result=true;
			result=confirm("确定删除吗");
			if(result==true){
				$.ajax({
					url:"tag/del",
					data:{tagId:tagId},
					success:function(msg){
						alert(msg);
						window.location.href="tag";
					}
				});
			}
		}
	</script>
</rapid:override>

<%@ include file="../framework.jsp" %>