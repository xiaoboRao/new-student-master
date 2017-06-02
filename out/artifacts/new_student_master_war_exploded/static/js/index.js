$(function () {


	/*$('#user').rules('add', {
			required : true,
			minlength : 6,
			maxlength : 18,
			messages : {
				required : '帐号不得为空！',
				minlength : jQuery.format('帐号不得小于{0}位！'),
				maxlength : jQuery.format('帐号不得大于{1}位！'),
		}
	});*/


	$('#reg').validate({

		
		/*focusInvalid : false,//光标不是默认在input中
		errorPlacement : function (error, element) {
			error.appendTo('.error_user');
		},*/

		rules : {
			user : {
				required : true,
				minlength : 6,
			},
			pass : {
				required : true,
				minlength : 6,
			},
			tel : {
				required : true,
				digits : true,
			},
			email : {
				email : true,
			}
		},
		messages : {
			/*1、因为下面的位数是对应上面的，所以如果修改了上面的位数而没有修改下面的那么就可能产生错误的提示
				后面使用代码会很多不方便，可以这样使用，更加方便*/
			user : {
				required : '账号不得为空',
				minlength : '账号不得小于6位',
			},
			pass : {
				required : '密码不得为空！',
				minlength : '密码不得小于6位！',
			},
			tel : {
				required : '电话号不得为空！',
				digits : '电话号格式有误！',
			},
			email : {
				email : '电子邮件格式不正确！',
			}
		}
	});

});


