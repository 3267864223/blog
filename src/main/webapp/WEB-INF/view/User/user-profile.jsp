<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<rapid:override name="frame-header-script">
	<link rel="stylesheet" href="resources/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="resources/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="resources/kindeditor/kindeditor-all-min.js"></script>
	<script charset="utf-8" src="resources/kindeditor/lang/zh-CN.js"></script>
	<script charset="utf-8" src="resources/kindeditor/plugins/code/prettify.js"></script>
	
	<style>
	    .layui-form-item .layui-input-inline {
	        width: 300px;
	    }
	
	    .layui-word-aux {
	        color: #FF5722 !important;
	    }
	    .layui-form-label {
	        width: 120px;
	    }
	    input {
	        border: 0!important;
	    }
	</style>
</rapid:override>

<rapid:override name="frame-content">
	<blockquote class="layui-elem-quote">
		<span class="layui-breadcrumb" lay-separator="/">
			<a href="article/index">首页</a>
			<a href="user">用户列表</a>
			<a><cite>个人信息</cite></a>
		</span>
	</blockquote>
    <br><br>
        <input type="hidden" name="userId" id="userId" value="1">
        <div class="layui-form-item">
            <label class="layui-form-label">头像</label>
            <div class="layui-input-inline">
                <div class="layui-upload">
                    <div class="layui-upload-list" style="">
                        <img class="layui-upload-img" src="user/photo?userId=${user.userId }" id="demo1" width="100" height="100">
                        <p id="demoText"></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名 </label>
            <div class="layui-input-inline">
                <input type="text" value="${user.userName }"  id="userName" required autocomplete="off" class="layui-input" disabled>
            </div>
            <div class="layui-form-mid layui-word-aux" id="userNameTips"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码 </label>
            <div class="layui-input-inline">
                <input type="password" value="******" id="userPass" required autocomplete="off" class="layui-input" min="3" max="20" disabled>
            </div>
            <div class="layui-form-mid layui-word-aux"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">昵称 </label>
            <div class="layui-input-inline">
                <input type="text"  value="${user.userNickname }" required placeholder="" autocomplete="off" min="2" max="10" class="layui-input" disabled>
            </div>
            <div class="layui-form-mid layui-word-aux"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">Email </label>
            <div class="layui-input-inline">
                <input type="email"  value="${user.userEmail }" id="userEmail" required class="layui-input" disabled>
            </div>
            <div class="layui-form-mid layui-word-aux" id="userEmailTips"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">URL </label>
            <div class="layui-input-inline">
                <input type="url"  value="${user.userUrl }" placeholder="" autocomplete="off" class="layui-input" disabled>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">注册时间 </label>
            <div class="layui-input-inline">
                <input type="text"  value='<fmt:formatDate value="${user.userRegisterTime }" pattern="yyyy-MM-dd HH:mm:ss"/>' placeholder="" autocomplete="off" class="layui-input" disabled>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">最后登录时间 </label>
            <div class="layui-input-inline">
                <input type="text"  value='<fmt:formatDate value="${user.userLastLoginTime }" pattern="yyyy-MM-dd HH:mm:ss"/>' placeholder="" autocomplete="off" class="layui-input" disabled>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">最后登录IP </label>
            <div class="layui-input-inline">
                <input type="text"  value="${user.userLastLoginIp }" placeholder="" autocomplete="off" class="layui-input" disabled>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态 </label>
            <div class="layui-input-inline">
            	<c:if test="${user.userStatus eq 1}">
            	 	<input type="text"  value='正常' placeholder="" autocomplete="off" class="layui-input" disabled>
            	</c:if>
            	<c:if test="${user.userStatus eq 0}">
            	 	<input style="color:red" type="text"  value='禁用' placeholder="" autocomplete="off" class="layui-input" disabled>
            	</c:if>
            </div>
        </div>
</rapid:override>
	
<%@ include file="../framework.jsp" %>