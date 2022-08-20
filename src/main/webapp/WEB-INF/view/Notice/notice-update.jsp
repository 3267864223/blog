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
              <a href="notice">公告列表</a>
              <a><cite>编辑公告</cite></a>
        </span>
    </blockquote>

    <form class="layui-form"  method="post" id="myForm" action="notice/update">
        <input type="hidden" name="noticeId" value="${notice.noticeId }">
        <div class="layui-form-item">
            <label class="layui-form-label">标题  <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-block">
                <input type="text" name="noticeTitle" lay-verify="title" id="title" value="${notice.noticeTitle }" class="layui-input" required>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">内容  <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-block">
                <textarea class="layui-textarea layui-hide" name="noticeContent" id="content" >${notice.noticeContent }</textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">Order</label>
            <div class="layui-input-inline">
                <input type="number" name="noticeOrder" value="${notice.noticeOrder }"class="layui-input" min="0" max="10" >
            </div>
            <div class="layui-form-mid layui-word-aux">输入1-10的数字,order越大排序越前</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
	            <c:if test="${notice.noticeStatus eq 1}">
	            	<input type="radio" name="noticeStatus" value="1" title="显示" checked>
	                <input type="radio" name="noticeStatus" value="0" title="隐藏" >
	            </c:if>
	            <c:if test="${notice.noticeStatus eq 0}">
	            	<input type="radio" name="noticeStatus" value="1" title="显示" >
	                <input type="radio" name="noticeStatus" value="0" title="隐藏" checked>
	            </c:if>
            </div>

        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="" type="submit">编辑</button>
            </div>
        </div>
    </form>
</rapid:override>
	
<rapid:override name="frame-footer-script">
	<script>
		layui.use([ 'form', 'laydate' ],function() {
			var form = layui.form, layer = layui.layer, laydate = layui.laydate;

			//自定义验证规则
			form.verify({
				title : function(value) {
					if (value.length < 5) {
						return '标题至少得5个字符啊';
					}
				},
			});

			layui.use('code', function() { //加载code模块
				layui.code();
			});

		});
	</script>

	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[id="content"]', {
				uploadJson : 'article/uploadImg',
				allowFileManager : true,
				width:"1570px",
				height:"420px"
			});
			prettyPrint();
		});
		
		//给文本编辑器的iframe引入代码高亮的css
		$("iframe").contents().find("head").append("<link rel=\"stylesheet\" href=\"/css/highlight.css\">\n");
	</script>
</rapid:override>

<%@ include file="../framework.jsp" %>