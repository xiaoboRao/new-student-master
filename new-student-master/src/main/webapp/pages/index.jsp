<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://cdn.bootcss.com/normalize/5.0.0/normalize.min.css"/>
    <link rel="stylesheet" href="/static/css/login.css"/>
    <script type="text/javascript" src="/static/js/jquery-1.11.3.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<STYLE type=text/css>

	.error{
		color:red;
	}
	.success{
		color:green;
	}

</STYLE>
<title>首页</title>
<script type="text/javascript">
function checkCode(){
	// 获取用户输入的登录名
	var code = $(".text").val();
	// 进行判断，说明没有输入登录名
	if(code.trim() == ""){
		// 给提示
		$("#checkcode").addClass("error");
		$("#checkcode").html("登录名不能为空");
	}else{
		$("#checkcode").removeClass("error");


	}
}
</script>

</head>
<body>
<div id="header">
    <div class="header-index">
        <img src="/static/images/logo-big.png" alt=""/>
    </div>
</div>
<div id="container">
    <div class="main">
        <div class="login-top">
            <div class="sig-up">
                登录<div class="register"><a href="/static/WEB-INF/pages/register.jsp">免费注册</a></div>
            </div>
        </div>
        <!-- 提交则跳转到login下面的list.action页面 -->
      <form id="login" action="login"
	method="post" enctype="multipart/form-data">
        <div class="login-center">
            <div class="user">
                用户名<span class="required">*</span>
                <input type="text" name="user" class="text" onblur="checkCode()"/>
                <span id="checkcode"></span>
            </div>
            <div class="pass">密&nbsp;码<span class="required">*</span>
                <input type="password" name="pass" class="text"/>
            </div>
            <div class="other">
                <input type="checkbox" name="chackbox" checked="checked" class="check"/>
                <span class="check-text">记住我</span>&nbsp;
                <a href="#">找回密码</a></div>
            <div class="login">
                <div class="controls">
                    <button type="submit" class="btn-session" onclick="">登录</button>
                </div>
            </div>
        </div>
        </form>
        <div class="login-bottom">
            <div class="quicklogint">
                使用第三方账号登陆
            </div>
            <div class="quicklogin">
                <a href="#"><i class="pop-sns icons-qq"></i>QQ登录</a>
                <a href="#"><i class="pop-sns icons-weixin"></i>微信登录</a>
                <a href="#"><i class="pop-sns icons-weibo"></i>微博登录</a>
            </div>
        </div>
    </div>
    <div class="footer">
        <p>2017<a href="#">江西理工大学</a>XXX</p>
    </div>
</div>
</body>
</html>