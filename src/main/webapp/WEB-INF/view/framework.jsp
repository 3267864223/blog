<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
	<base href="<%=basePath%>">
	
	<title>X博客后台</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta charset="utf-8">
	<script src="resources/js/jquery-1.8.0.js"></script>
	<link rel="shortcut icon" href="resources/img/X.gif">
	<link rel="stylesheet" href="resources/plugin/layui/css/layui.css">
	<link rel="stylesheet" href="resources/css/back.css">
	<link rel="stylesheet" href="resources/plugin/font-awesome/css/font-awesome.min.css">
	
	<!-- 留给别的页面去覆盖,让其他页面能引入自已的css或js -->
	<rapid:block name="frame-header-style"></rapid:block>
	<rapid:block name="frame-header-script"></rapid:block>

</head>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header ">
			<div class="layui-logo">
				<a href="article/index" style="color: #009688;"> X博客管理 </a>
			</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left ">
				<li class="layui-nav-item"><a href="javascript:void(0)" target="_blank">前台</a></li>
				<li class="layui-nav-item"><a href="javascript:;">新建</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="article/add">文章</a>
						</dd>
						<dd>
							<a href="page/toAdd">页面</a>
						</dd>
						<dd>
							<a href="category">分类</a>
						</dd>
						<dd>
							<a href="notice/toAdd">公告</a>
						</dd>
						<dd>
							<a href="link/toAdd">链接</a>
						</dd>
					</dl></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="user/photo?userId=${session_user.userId }"
						class="layui-nav-img">${session_user.userNickname }
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="user/profile">基本资料</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="user/logout">溜。。</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll layui-bg-cyan">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree layui-bg-cyan" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a href="javascript:;">文章</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="article">全部文章</a>
							</dd>
							<dd>
								<a href="article/add">写文章</a>
							</dd>
							<dd>
								<a href="category">全部分类</a>
							</dd>
							<dd>
								<a href="tag">全部标签</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">页面</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="page">全部页面</a>
							</dd>
							<dd>
								<a href="page/toAdd">添加页面</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item layui-nav-itemed"><a href="javascript:;">链接 </a>
						<dl class="layui-nav-child">
							<dd>
								<a href="link">全部链接</a>
							</dd>
							<dd>
								<a href="link/toAdd">添加链接</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item layui-nav-itemed"><a href="javascript:;">公告</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="notice">全部公告</a>
							</dd>
							<dd>
								<a href="notice/toAdd">添加公告</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="comment"> 评论 </a></li>
					<li class="layui-nav-item layui-nav-itemed"><a href="javascript:;">用户 </a>
						<dl class="layui-nav-child">
							<dd>
								<a href="user">全部用户</a>
							</dd>
							<dd>
								<a href="user/add">添加用户</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item layui-nav-itemed"><a href="javascript:;">设置</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="menu">菜单</a>
							</dd>
							<dd>
								<a href="options">主要选项</a>
							</dd>
						</dl></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<div style="padding: 15px;">
				<!-- 主体内容,要留给别的页面覆盖 -->
				<rapid:block name="frame-content">
					内容主体区域,不同的页面要分别进行不同的编写
				</rapid:block>
			</div>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			制作：关喻轩&nbsp;&nbsp;qq：3267864223&nbsp;&nbsp;
		</div>
	</div>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/plugin/layui/layui.all.js"></script>
	<script src="resources/js/back.js"></script>

	<!-- 留给别的页面去覆盖,让它们可以引入自已的js -->
	<rapid:block name="frame-footer-script"></rapid:block>

</body>
</html>