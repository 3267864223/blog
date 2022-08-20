<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<rapid:override name="frame-content">
	<blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
          <a href="article/index">首页</a>
          <a><cite>基本信息</cite></a>
        </span>
    </blockquote>
    <form class="layui-form" action="options/update" method="post" enctype="multipart/form-data">

    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
        <ul class="layui-tab-title">
            <li class="layui-this">基本信息</li>
            <li>小工具</li>
        </ul>
        <div class="layui-tab-content">
            <br><br>
            <input type="hidden" name="optionId" value="${options.optionId }">
                <div class="layui-tab-item layui-show">
                <div class="layui-form-item">
                    <label class="layui-form-label">站点名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="optionSiteTitle"  value="${options.optionSiteTitle }"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">站点描述</label>
                    <div class="layui-input-block">
                        <input type="text" name="optionSiteDescrption"   value="${options.optionSiteDescrption }"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">首页描述</label>
                    <div class="layui-input-block">
                        <input type="text" name="optionMetaDescrption"  value="${options.optionMetaDescrption }"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">首页关键词</label>
                    <div class="layui-input-block">
                        <input type="text" name="optionMetaKeyword"  value="${options.optionMetaKeyword }"   autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-tab-item">
                <div class="layui-form-item">
                    <label class="layui-form-label">头像</label>
                    <div class="layui-input-inline">
                        <div class="layui-upload">
                            <div class="layui-upload-list" id="localImag1">
                                <img class="layui-upload-img" src="options/photo1?optionId=${options.optionId }" id="demo1" width="100" height="100">
                                <p id="demoText"></p>
                            </div>
                            <input type="file" id="photo1" name="photo" style="display: none" onchange="preview(this,localImag1,demo1,'100px','100px')" >
							<button type="button" onclick="$('#photo1').click()" class="layui-btn" id="test1">上传图片</button>
                        </div>
                    </div>
                    <div class="layui-form-mid layui-word-aux">建议 150px*150px</div>

                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">昵称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="optionAboutsiteTitle"   value="${options.optionAboutsiteTitle }"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">说明</label>
                    <div class="layui-input-block">
                        <input type="text" name="optionAboutsiteContent"   value="${options.optionAboutsiteContent }"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">微信二维码</label>
                    <div class="layui-input-inline">
                        <div class="layui-upload">
                            <div class="layui-upload-list" id="localImag2">
                                <img class="layui-upload-img" src="options/photo2?optionId=${options.optionId }" id="demo2" width="100"
                                     height="100">
                                <p id="demoText2"></p>
                            </div>
                            <input type="file" id="photo2" name="photo" style="display: none" onchange="preview(this,localImag2,demo2,'100px','100px')" >
							<button type="button" onclick="$('#photo2').click()" class="layui-btn" id="test1">上传图片</button>
                        </div>
                    </div>
                    <div class="layui-form-mid layui-word-aux">建议 430px*430px</div>

                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">QQ</label>
                    <div class="layui-input-inline">
                        <input type="text" name="optionAboutsiteQq"   value="${options.optionAboutsiteQq }"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">微博</label>
                    <div class="layui-input-inline">
                        <input type="text" name="optionAboutsiteWeibo"  value="${options.optionAboutsiteWeibo }"    autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">Github</label>
                    <div class="layui-input-inline">
                        <input type="text" name="optionAboutsiteGithub"  value="${options.optionAboutsiteGithub }"   autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
        </div>

    </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">保存设置</button>
            </div>
        </div>
    </form>
</rapid:override>

<rapid:override name="frame-footer-script">
	<script>
		//预览图片  
		function preview(docObj, localImagId, imgObjPreview, width, height) {
			$(docObj).removeAttr("src");
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