<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>X博客</title>
	<script src="resources/js/jquery-1.8.0.js"></script>
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/jquery.cookie.js"></script>
	<link rel="stylesheet" href="resources/plugin/font-awesome/css/font-awesome.min.css">
	<link rel="shortcut icon" href="resources/img/X.gif">
	<link rel='stylesheet' id='dashicons-css' href='resources/plugin/login/dashicons.min.css' type='text/css' media='all' />
	<link rel='stylesheet' id='buttons-css' href='resources/plugin/login/buttons.min.css' type='text/css' media='all' />
	<link rel='stylesheet' id='forms-css' href='resources/plugin/login/forms.min.css' type='text/css' media='all' />
	<link rel='stylesheet' id='l10n-css' href='resources/plugin/login/l10n.min.css' type='text/css' media='all' />
	<link rel='stylesheet' id='login-css' href='resources/plugin/login/login.min.css' type='text/css' media='all' />
	<link rel='stylesheet' href='resources/css/login.css' type='text/css' media='all' />
	<meta name='robots' content='noindex,follow' />
	<meta name="viewport" content="width=device-width" />
</head>
<body class="login login-action-login wp-core-ui  locale-zh-cn">
	<div id="login">
		<br /> <br />
		<form name="loginForm" id="loginForm" action="user/login" method="post">
			<p>
				<label for="user_login">用户名或电子邮件地址<br /> 
					<input type="text" name="userName" id="user_login" class="input" value="" size="20" required />
				</label>
			</p>
			<p>
				<label for="user_pass">密码<br /> 
					<input type="password" name="userPass" id="user_pass" class="input" value="" size="20" required />
				</label>
			</p>
			<p class="forgetmenot">
				<label for="rememberme">
					<input name="rememberme" type="checkbox" id="rememberme" value="1"  />记住账号和密码
				</label>
			</p>
			<p class="submit">
				<input type="submit" name="wp-submit" id="submit-btn" class="button button-primary button-large" value="登录" />
			</p>
		</form>

		<p id="backtoblog">
			<a href="javascript:void(0)">&larr; 去往博客前台</a>
		</p>

	</div>
	<div class="clear"></div>

</body>
<script>
	$(function(){
		getCookie();
		$("#submit-btn").click(function(){
				 setCookie();
			});
		
		var msg="${msg}";
		if(msg!=""){
			alert(msg);
		}
	});
	
	//设置Cookie方法
	function setCookie(){
		var user_name = $("#user_login").val();
		var user_pass = $("#user_pass").val();
	   //获取记住密码是否选中
	   var flag = $("#rememberme").is(":checked");
	   if(flag){//如果选中-->记住密码登录
	       //cookie有效时间7天，也可以设置为永久，把时间去掉就行
	       $.cookie("rememberme","true");
	       $.cookie("user_pass",user_pass.trim());
	       $.cookie("user_name",user_name.trim());
	   }else{//如果没选中-->不记住密码登录
	       //设置cookie有效时间-1，直接将浏览器端原先保存的cookie失效
	       $.cookie("rememberme","false",{expires:-1});
	       $.cookie("user_pass", "",{expires:-1});
	       $.cookie("user_name", "",{expires:-1});
	   }  
	}
	
	//获取cookie方法，自动填充密码
	function getCookie(){
	   var rememberme = $.cookie("rememberme");
	   //获取cookie中的登陆密码    
	   var user_pass =  $.cookie("user_pass");
	   var user_name = $.cookie("user_name");
	  //记住密码为true的话把  记住密码  复选框勾选住    
	   if(rememberme){
	      $("#rememberme").attr("checked","true");    
	   }    
	 //密码存在的话把密码填充到密码文本框    
	   if(user_pass!=""){
	        $("#user_pass").val(user_pass);
	   }else{
	        $("#user_pass").val("");
	   }
	 
	   if(user_name!=""){
	        $("#user_login").val(user_name);
	   }else{
	        $("#user_login").val("");
	   }
	}
</script>
</html>