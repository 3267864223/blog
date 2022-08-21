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
              <a href="page">页面列表</a>
              <a><cite>编辑页面</cite></a>
        </span>
    </blockquote>

    <form class="layui-form" method="post" id="myForm" action="page/update">
        <input type="hidden" name="pageId" value="${page.pageId }">
        <div class="layui-form-item">
            <label class="layui-form-label">别名<span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="text" name="pageKey" lay-verify="key" id="key" value="${page.pageKey }"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">请填写2到20位，仅允许字母、下划线和减号组成（<span style="color: #FF5722;">请确保别名没重复</span>）</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">标题 <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="text" name="pageTitle" lay-verify="title" id="title" value="${page.pageTitle }" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">内容 <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-block">
                <textarea class="layui-textarea layui-hide" name="pageContent" id="content">${page.pageContent }</textarea>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
	            <c:if test="${page.pageStatus eq 1 }">
	            	<input type="radio" name="pageStatus" value="1" title="显示" checked>
                	<input type="radio" name="pageStatus" value="0" title="隐藏">
	            </c:if>
	            <c:if test="${page.pageStatus eq 0 }">
	            	<input type="radio" name="pageStatus" value="1" title="显示" >
                	<input type="radio" name="pageStatus" value="0" title="隐藏" checked>
	            </c:if>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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