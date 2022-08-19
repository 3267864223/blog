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
			<a href="article/index">首页</a>
			<a href="category">分类列表</a>
		</span>
	</blockquote>
    <div class="layui-row">
    	<div class="layui-col-md4">
        	<form class="layui-form"  method="post" id="myForm" action="category/insertSubmit">
        	<input id="categoryId" type="hidden" name="categoryId" >
            	<div class="layui-form-item">
                    <div class="layui-input-block">
                        <strong>添加分类</strong>
                    </div>
                    <div class="layui-input-block">
                    	名称 <span style="color: #FF5722; ">*</span>
                        <input type="text" id="categoryName" name="categoryName" placeholder="请输入分类名称" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                      	 父节点 <span style="color: #FF5722; ">*</span>
                        <select id="categoryPid" name="categoryPid" class="layui-input" required>
                            <option value="0">无</option>
                            <c:forEach var="b" items="${bigCategoryList }">
                            	 <option value="${b.categoryId }">${b.categoryName }</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <div class="layui-input-block">分类描述
                        <input type="text" id="categoryDescription" name="categoryDescription" placeholder="请输入分类描述" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">图标样式
                        <input type="text" id="categoryIcon" name="categoryIcon" placeholder="请输入图标样式,如 fa fa-coffee" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        <button id="subBtn" class="layui-btn" lay-filter="formDemo" type="submit">添加</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="layui-col-md8" >
            <table class="layui-table" >
                <colgroup>
                    <col width="300">
                    <col width="100">
                    <col width="100">
                    <col width="100">
                    <col width="50">
                    <col width="50">
                </colgroup>
                <thead>
	                <tr>
	                    <th>名称</th>
	                    <th>文章数</th>
	                    <th>操作</th>
	                    <th>ID</th>
	                    <th>pid</th>
	                </tr>
                </thead>
                <tbody>
               		<c:forEach var="c" items="${categoryList }">
	               		<tr>
	               			<c:if test="${c.categoryPid eq 0}">
								<td>
								    <a href="/category/1" target="_blank">${c.categoryName}</a>
								</td>
							</c:if>
							<c:if test="${c.categoryPid != 0}">
								<td>
								    <a href="/category/1" target="_blank">——${c.categoryName}</a>
								</td>
							</c:if>
							<td>
							    <a href="/category/1" target="_blank">${c.articleCount}</a>
							</td>
							<c:if test="${c.articleCount eq 0}">
								<td>
								    <a href="javascript:toUpdate(${c.categoryId})" class="layui-btn layui-btn-mini">编辑</a>
								    <a href="javascript:del(${c.categoryId})" class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
								</td>
							</c:if>
							<c:if test="${c.articleCount != 0}">
								<td>
							    	<a href="javascript:toUpdate(${c.categoryId})" class="layui-btn layui-btn-mini">编辑</a>
								</td>
							</c:if>
							<td>${c.categoryId}</td>
							<td>${c.categoryPid}</td>
						</tr>
                    </c:forEach>
               </tbody>
            </table>
            <blockquote class="layui-elem-quote layui-quote-nm">温馨提示：
	            <ul>
	                <li>分类最多只有两级，一级分类pid=0，二级分类pid=其父节点id</li>
	                <li>如果该分类包含文章，将不可删除</li>
	            </ul>
            </blockquote>
        </div>
    </div>
</rapid:override>

<rapid:override name="frame-footer-script">
	<script>
		function toUpdate(categoryId){
			layui.use('form',function(){
				$.ajax({
					url:"category/toUpdate",
					data:{categoryId:categoryId},
					async:false,
					success:function(category){
						$("#categoryId").val(category.categoryId);
						$("#categoryName").val(category.categoryName);
						$("#categoryPid").val(category.categoryPid);
						$("#categoryDescription").val(category.categoryDescription);
						$("#categoryIcon").val(category.categoryIcon);
						$("#subBtn").html("编辑");
						layui.form.render("select");
					}
				});
			});
		}
		function del(categoryId){
			var result=true;
			result=confirm("确定删除吗");
			if(result==true){
				$.ajax({
					url:"category/del",
					data:{categoryId:categoryId},
					success:function(msg){
						alert(msg);
						window.location.href="category";
					}
				});
			}
		}
	</script>
</rapid:override>

<%@ include file="../framework.jsp" %>