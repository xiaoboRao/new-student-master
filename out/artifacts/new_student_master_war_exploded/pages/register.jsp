<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.2/jquery-1.8.0.min.js"></script>--%>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.2/jquery.easyui.min.js"></script>--%>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.2/locale/easyui-lang-zh_CN.js"></script>--%>
    <%--&lt;%&ndash;<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.3.2/themes/icon.css" >&ndash;%&gt;--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.3.2/themes/default/easyui.css" >--%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
	<link rel="stylesheet" href="https://cdn.bootcss.com/normalize/5.0.0/normalize.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<STYLE type=text/css>

	.error{
		color:red;
	}
	.success{
		color:green;
	}
    .boundwrite{
        color: #FF832C;

    }
	
</STYLE>
<title>Insert title here</title>

<script type="text/javascript">
	// 验证登录名

    //查看密码是否符合要求
    function IsDigit(cCheck) {
        for(len=0;len<cCheck.length;len++)
        {
         var  password= cCheck.charAt(len);
         if(((('a'<=password) && (password<='z')) || (('A'<=password) && (password<='Z'))||(('0'<=password) && (password<='9'))))
         {

         }
         else {
          return false;
         }

         if(len==cCheck.length-1)
         {
             return true;
         }
        }
         }


    function checkCode(){
		// 获取用户输入的登录名
		var code = $(".a").val();
		// 进行判断，说明没有输入登录名
		if(code.trim() == ""){
			// 给提示

			$("#checkname").removeClass("success");
			$("#checkname").addClass("boundwrite");
			$("#checkname").html("登录名不能为空");
		}else{
			// 登录名不为空，ajax请求，验证
			
			var url = "${pageContext.request.contextPath}/check.action";
			var param = {"user_code":code};
			$.post(url,param,function(data){
				// 操作data，进行判断
//                alert(data)
				if(data == 0){
					// 提示
                    $("#checkname").removeClass("boundwrite");
                    $("#checkname").removeClass("success");
					$("#checkname").addClass("error");
					$("#checkname").html("登录名已经存在");
					return false;
				}if(data && data == 1){
					$("#checkname").removeClass("error");
                    $("#checkname").removeClass("boundwrite");
					$("#checkname").addClass("success");

					$("#checkname").html("可以注册");
				}
				
			});
		}
	}
	function checkpwd(){
		
		var code = $(".b").val();
      var pass= IsDigit(code);
      //alert(pass);

		// 进行判断，说明没有输入密码
		if(code.trim() == ""){
			// 给提示
            $("#pwd").removeClass("success");
			$("#pwd").addClass("error");
			$("#pwd").html("密码不能为空");
			return false;

	      }
	      else if(code.length < 8)
        {
            $("#pwd").removeClass("success");
            $("#pwd").addClass("error");
            $("#pwd").html("密码长度不能小于8");
            return false;
        }
        else if(pass == 0)
        {
            $("#pwd").removeClass("success");
            $("#pwd").addClass("error");
            $("#pwd").html("密码必须是数字或者字母");
            return false;
        }
		else{

			$("#pwd").removeClass("error");
            $("#pwd").addClass("success");
			$("#pwd").html(" 密码符合要求");
		}
}

    function checkphonenum()
    {
        if ($("#phonenumber").val().trim() == "") {
            console.info("i am empty");
            $("#checkphone").addClass("error");
            $("#checkphone").html("手机号码不能为空");
        }
        else if (!((/^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/).test($("#phonenumber").val()))) {
            console.info("i am match");
            $("#checkphone").addClass("error");
            $("#checkphone").html("格式不正确！请重新输入");

            $("#phonenumber").focus;
        }
        else {
            console.info("i am true");
            $("#checkphone").removeClass("error");
           $("#checkphone").html(" ");
        }
    }
  function checkphoneandemail() {
      if ($("#email").val().trim() == "") {
          $("#checkemail").addClass("error");
          $("#checkemail").html("邮箱不能为空");

      }

    else if (!($("#email").val().match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/))) {

          $("#checkemail").html("格式不正确！请重新输入");
          $("#email").focus();
          $("#checkemail").addClass("error");
      }
      else {
          $("#checkemail").removeClass("error");
          $("#checkemail").html(" ");
      }
//
  }

	// 可以阻止表单的提交
	function checkForm(){
		// 先让校验名称的方法先执行以下
		checkCode();
        checkpwd();
        checkphonenum();
        checkphoneandemail();
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
                    <input class="a" type="text" name="username" placeholder="用户名" onblur="checkCode()" onfocus="removewrite()"/>
                    <span id="checkname" ></span>

                </div>
            </div>
            <div class="sig-item">
                <div class="item-name">学院<span class="required">*</span>
                </div>
                <div class="item-content">
                    <input class="a" type="text" name="college" placeholder="学院" onblur="checkCode()" />
                    <span id="checkRealname"></span>
                </div>
            </div>
            <div class="sig-item">
                <div class="item-name">一卡通号<span class="required">*</span>
                </div>
                <div class="item-content">
                    <input class="a" type="text" name="idnumber" placeholder="一卡通" onblur="checkCode()" />
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
                    <input class="c" type="radio" name="sex" value="1"  checked="checked"/>男
                    <input class="c" type="radio" name="sex" value="0" />女

                </div>
            </div>
            <%--<div class="sig-item">--%>
                <%--<div class="item-name college1">学&nbsp;院<span class="required">*</span></div>--%>
                <%--<div class="item-content college2">--%>
                    <%--<select>--%>
                        <%--<option value="b" name="usercollege">电气学院</option>--%>
                    <%--</select>--%>
                    <%--<span id="checkcollege"></span>--%>
                <%--</div>--%>
            <%--</div>--%>
            <div class="sig-item">
                <div class="item-name classes1">班&nbsp;级<span class="required">*</span></div>
                <div class="item-content classes2">
                    <select name="classes">
                        <option value="1" >电子141</option>
                        <option value="2">电子142</option>
                        <option value="3" selected="selected">电子143</option>
                    </select>
                    <span id="checkclass"></span>
                </div>
            </div>
            <div class="sig-item">
                <div class="item-name" >电话号<span class="required">*</span></div>
                <div class="item-content" >
                    <input  type="text" name="phone" placeholder="电话号" id="phonenumber" onblur="checkphonenum()">
                    <span id="checkphone" ></span>
                </div>
            </div>
            <div class="sig-item">
                <div class="item-name" >邮&nbsp;箱<span class="required">*</span></div>
                <div class="item-content" >
                    <input type="text" name="email" placeholder="邮箱" id="email" onblur="checkphoneandemail()">
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
                    <button type="submit" class="btn-session"  id="bt">立即注册</button>
                </div>
            </div>
        </div>
            </form>
    </div>
</div>
</body>
</html>