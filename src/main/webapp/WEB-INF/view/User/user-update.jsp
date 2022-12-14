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
			<a href="article/index">首页</a> <a href="user">用户列表</a> <a><cite>编辑用户</cite></a>
		</span>
	</blockquote>
	
	<form class="layui-form" method="post" id="myForm" action="user/update" enctype="multipart/form-data">
		<input type="hidden" name="userId" value="${user.userId }">
		<div class="layui-form-item">
			<label class="layui-form-label">头像</label>
			<div class="layui-input-inline">
				<div class="layui-upload">
					<div class="layui-upload-list" id="localImag">
						<img src="user/photo?userId=${user.userId }" class="layui-upload-img" id="demo1" width="100" height="100">
					</div>
	
					<input type="file" name="photo" id="photo" type="file"
						style="display: none"
						onchange="preview(this,localImag,demo1,'100px','100px')" >
					<button type="button" onclick="$('#photo').click()"
						class="layui-btn" id="test1">上传图片</button>
				</div>
			</div>
			<input type="hidden" name="userAvatar" id="userAvatar" value="">
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用户名 <span
				style="color: #FF5722;">*</span></label>
			<div class="layui-input-inline">
				<input type="text" name="userName" id="userName" required
					lay-verify="userName" autocomplete="off" class="layui-input"
					onblur="checkUserName()" value="${user.userName}" >
			</div>
			<div class="layui-form-mid layui-word-aux" id="userNameTips"></div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码 <span
				style="color: #FF5722;">*</span></label>
			<div class="layui-input-inline">
				<input type="password" name="userPass" id="userPass" required
					lay-verify="userPass" autocomplete="off" class="layui-input"
					min="3" max="20" value="******" readonly>
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">昵称 <span
				style="color: #FF5722;">*</span></label>
			<div class="layui-input-inline">
				<input type="text" name="userNickname" required placeholder=""
					autocomplete="off" min="2" max="10" class="layui-input" value="${user.userNickname}">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">Email <span
				style="color: #FF5722;">*</span></label>
			<div class="layui-input-inline">
				<input type="email" name="userEmail" id="userEmail" required
					lay-verify="userEmail" class="layui-input"
					onblur="checkUserEmail()" value="${user.userEmail}">
			</div>
			<div class="layui-form-mid layui-word-aux" id="userEmailTips"></div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">URL </label>
			<div class="layui-input-inline">
				<input type="url" name="userUrl" placeholder="" class="layui-input" value="${user.userUrl}">
			</div>
		</div>
		 <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
            	<c:if test="${user.userStatus eq 0}">
	                <input type="radio" name="userStatus" value="1" title="正常" >
	                <input type="radio" name="userStatus" value="0" title="禁用" checked>
                </c:if>
                <c:if test="${user.userStatus != 0}">
	                <input type="radio" name="userStatus" value="1" title="正常" checked>
	                <input type="radio" name="userStatus" value="0" title="禁用" >
                </c:if>
            </div>
        </div>
	
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="demo1"
					id="submit-btn">编辑</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</rapid:override>
	
<rapid:override name="frame-footer-script">
	<script>
		//预览图片  
		function preview(docObj, localImagId, imgObjPreview, width, height) {
			$("#demo1").removeAttr("src");
			if (docObj.files && docObj.files[0]) { //火狐下，直接设img属性        
				imgObjPreview.style.display = 'block';
				imgObjPreview.style.width = width;
				imgObjPreview.style.height = height;
				//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式        
				imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
			} else { //IE下，使用滤镜      
				docObj.select();
				var imgSrc = document.selection.createRange().text;
				//必须设置初始大小        
				localImagId.style.width = width;
				localImagId.style.height = height;
				//图片异常的捕捉，防止用户修改后缀来伪造图片        
				try {
					localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
					localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
				} catch (e) {
					alert("您上传的图片格式不正确，请重新选择!");
					return false;
				}
				imgObjPreview.style.display = 'none';
				document.selection.empty();
			}
		}
	</script>
</rapid:override>

<%@ include file="../framework.jsp" %>