<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="/static/js/jquery-1.11.3.min.js"></script>
	<link rel="stylesheet" href="https://cdn.bootcss.com/normalize/5.0.0/normalize.min.css"/>
    <link rel="stylesheet" href="/static/css/login.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<STYLE type=text/css>

	.error{
		color:red;
	}
	.success{
		color:green;
	}
	
</STYLE>
<title>Insert title here</title>

<script type="text/javascript">
	// 验证登录名
	function checkCode(){
		// 获取用户输入的登录名
		var code = $(".a").val();
		// 进行判断，说明没有输入登录名
		if(code.trim() == ""){
			// 给提示
			$("#checkcode").removeClass("success");
			$("#checkcode").addClass("error");
			$("#checkcode").html("登录名不能为空");
		}else{
			// 登录名不为空，ajax请求，验证
			
			var url = "${pageContext.request.contextPath}/user/check.action";
			var param = {"user_code":code};
			$.post(url,param,function(data){
				// 操作data，进行判断
				if(data && data == "no"){
					// 提示
					$("#checkcode").addClass("error");
					$("#checkcode").html("登录名已经存在");
				}else{
					$("#checkcode").removeClass("error");
					$("#checkcode").addClass("success");
					$("#checkcode").html("可以注册");
				}
				
			});
		}
	}
	function checkpwd(){
		
		var code = $(".b").val();
		// 进行判断，说明没有输入密码
		if(code.trim() == ""){
			// 给提示
			
			$("#pwd").addClass("error");
			$("#pwd").html("密码不能为空");
			
	}
		else{
			$("#pwd").removeClass("error");
			$("#pwd").html(" ");
		}
}
function checksex(){
		
		var code = $(".c").val();
		// 进行判断，说明没有输入性别
		if(code.trim() == ""){
			// 给提示
			
			$("#checksex").addClass("error");
			$("#checksex").html("请选择性别");
		}
			else{
				$("#checksex").removeClass("error");
				$("#checksex").html(" ");
			}
		
}
	// 可以阻止表单的提交
	function checkForm(){
		// 先让校验名称的方法先执行以下
		checkCode();
		checkpwd();
		checksex();
		//获取error的数量，如果数量 > 0，说明存在错误，不能提交表单
		if($(".error").size() > 0){
		
			return false;
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
<div id="register">
    <div class="container">
        <div class="sig-up">
            <h2 class="title">注册</h2>
            <a href="#">已有账号，马上登录</a>
        </div>
  <form action="${pageContext.request.contextPath}/register.action" method="post" onsubmit=" return checkForm()" >
        <div class="rgst-main">
            <div class="sig-item">
                <div class="item-name">用户名<span class="required">*</span>
                </div>
                <div class="item-content">
                    <input class="a" type="text" name="username" placeholder="用户名" onblur="checkCode()" />
                    <span id="checkname"></span>
                </div>
            </div>
            <div class="sig-item">
                <div class="item-name">真实名称<span class="required">*</span>
                </div>
                <div class="item-content">
                    <input class="a" type="text" name="realName" placeholder="真实名称" onblur="checkCode()" />
                    <span id="checkRealname"></span>
                </div>
            </div>
            <div class="sig-item">
                <div class="item-name">用户名<span class="required">*</span>
                </div>
                <div class="item-content">
                    <input class="a" type="text" name="nickName" placeholder="用户名" onblur="checkCode()" />
                    <span id="checkNickname"></span>
                </div>
            </div>
            <div class="sig-item">
                <div class="item-name">密&nbsp;码<span class="required">*</span></div>
                <div class="item-content">
                    <input class="b" type="password" name="password" placeholder="密码" onblur="checkpwd()"/>
                    <span id="pwd"></span>
                </div>
            </div>
            <div class="sig-item">
                <div class="item-name sex1">性&nbsp;别<span class="required">*</span></div>
                <div class="item-content sex2">
                    <input class="c" type="radio" name="sex" value="1" onblur="checksex()"/>男
                    <input class="c" type="radio" name="sex" value="0" onblur="checksex()"/>女
                    <span id="checksex"></span>
                </div>
            </div>
            <div class="sig-item">
                <div class="item-name college1">学&nbsp;院<span class="required">*</span></div>
                <div class="item-content college2">
                    <select>
                        <option value="b" name="usercollege">电气学院</option>
                    </select>
                    <span id="checkcollege"></span>
                </div>
            </div>
            <div class="sig-item">
                <div class="item-name classes1">班&nbsp;级<span class="required">*</span></div>
                <div class="item-content classes2">
                    <select name="userClass">
                        <option value="1" >电子141</option>
                        <option value="2">电子142</option>
                        <option value="3" selected="selected">电子143</option>
                    </select>
                    <span id="checkclass"></span>
                </div>
            </div>
            <div class="sig-item">
                <div class="item-name">电话号<span class="required">*</span></div>
                <div class="item-content">
                    <input type="text" name="phone" placeholder="电话号">
                    <span id="checkphone"></span>
                </div>
            </div>
            <div class="sig-item">
                <div class="item-name">邮&nbsp;箱<span class="required">*</span></div>
                <div class="item-content">
                    <input type="text" name="emali" placeholder="邮箱">
                    <span id="checkemail"></span>
                </div>
            </div>
            <div class="sig-item">
                <div class="protocol">
                    <input type="checkbox" name="icheck" class="check-box" checked="checked">
                    <span class="checkbox-text">
                        我已阅读并同意<a href="#">《用户注册协议》</a>
                    </span>
                </div>
            </div>
            <div class="sig-item1">
                <div class="btn">
                    <button type="submit" class="btn-session" onclick="">立即注册</button>
                </div>
            </div>
        </div>
            </form>
    </div>
</div>
</body>
</html>