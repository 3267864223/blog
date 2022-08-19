<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>

<rapid:override name="frame-header-script">
	<link rel="stylesheet" href="resources/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="resources/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="resources/kindeditor/kindeditor-all-min.js"></script>
	<script charset="utf-8" src="resources/kindeditor/lang/zh-CN.js"></script>
	<script charset="utf-8" src="resources/kindeditor/plugins/code/prettify.js"></script>
</rapid:override>

<rapid:override name="frame-content">
	<blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a href="article/index">首页</a>
              <a href="comment">评论列表</a>
              <a><cite>编辑评论</cite></a>
        </span>
    </blockquote>

    <form class="layui-form"  method="post" id="myForm" action="comment/update">
        <input type="hidden" name="commentId" value="${comment.commentId }">
        <div class="layui-form-item">
            <label class="layui-form-label">昵称 </label>
            <div class="layui-input-block">
                <input type="text" name="commentAuthorName"  value="${comment.commentAuthorName }" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱 </label>
            <div class="layui-input-block">
                <input type="text" name="commentAuthorEmail"  value="${comment.commentAuthorEmail }" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">网址 </label>
            <div class="layui-input-block">
                <input type="text" name="commentAuthorUrl"  value="${comment.commentAuthorUrl }" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">内容</label>
            <div class="layui-input-block">
                <textarea name="commentContent"  class="layui-textarea">${comment.commentContent }</textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">编辑</button>
                <button type="reset" class="layui-btn layui-btn-primary" >重置</button>
            </div>
        </div>

    </form>
</rapid:override>
	
<rapid:override name="frame-footer-script">
</rapid:override>

<%@ include file="../framework.jsp" %>