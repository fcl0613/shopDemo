<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery-1.12.4.min.js"></script>
    <style>
    	.error{
    		display:block;
    		color:#ff5151;
    		padding-top:5px;
    		text-align:left;
    		padding-left:100px;
    		width:200px;
    	}
    	
    	.error1{
    		display:block;
    		color:#ff5151;
    		padding-top:5px;
    		text-align:left;
    		width:100px;
    	}
    	
    	.imgcss{
    		padding-left:20px;
    		margin-bottom:8px;
    	}
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="reginster" method="post" onsubmit="return checkForm(this)">
    	<h1>用户注册</h1>
        <p><input type="text" name="username" value="" placeholder="请输入用户名" onblur="checkItem(this)"><span class="error" id="err"></span></p>
        <p><input type="text" name="password" value="" placeholder="请输入密码" onblur="checkItem(this)"><span class="error" id="err"></span></p>
        <p><input type="text" name="repassword" value="" placeholder="请确认密码" onblur="checkItem(this)"><span class="error" id="err"></span></p>
        <p class="txtL txt"><input class="code" type="text" name="code" value="" placeholder="验证码" onblur="checkItem(this)"><img
                src="getcode" alt="看不清，换一张" onclick="changeImg(this)" class="imgcss"><span class="error1" id="err"></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="login.jsp"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>

<script>

	var flag = true;
	
	function changeImg(img){
		img.src="getcode?"+new Date().getTime();
	}
	
	function checkItem(obj){
		var v = obj.value;
		var b;
		var name = $(obj).attr('name');
		if($(obj).attr('name') == 'code'){
			b = $(obj).next().next("span");
		}else{
			b = $(obj).next("span");
		}
		switch(name){
			case"username":
				var uPattern = /^[a-zA-Z0-9_-]{4,40}$/;
				if (!uPattern.test(v)) {
					b.html('用户名为字母数字组合,至少4位');
					b.addClass('error');
					flag = false;
				}else{
					var url = "usernamecheck?name="+encodeURI(v)+"&"+new Date().getTime();
					$.get(url, function(data){
						if(data == "false"){
							b.html('该用户名已被注册');
							b.addClass('error');
							flag = false;
						}else{
							b.html("").removeClass("error");
							flag = true;
						}
					});
				}
				break;
			case"password":
				var pPattern = /^.*(?=.{6,20})(?=.*\d)(?=.*[a-z])(?=.*[@#$&*+. ]).*$/;
				if (!pPattern.test(v)) {
					b.html('密码最少6位,需要字母数字和特殊字符');
					b.addClass('error');
					flag = false;
				}else{
					b.html("").removeClass("error");
					flag = true;
				}
				break;
			case"repassword":
				if (v != $('input[name="password"]').val()) {
					b.html('密码与上次输入不一致');
					b.addClass('error');
					flag = false;
				}else{
					b.html("").removeClass("error");
					flag = true;
				}
				break;
			case"code":
				if (v=="") {
					b.html('验证码不能为空');
					b.addClass('error1');
					flag = false;
				}else{
					var url = "checkcode?num="+encodeURI(v)+"&"+new Date().getTime();
					$.get(url,function(num){
						if (num=="false") {
							b.html('验证码输入错误');
							b.addClass("error1");
							flag = false;
						}else{
							b.html("").removeClass("error1");
							flag = true;
						}
					});
				}
			break;
		}
	}
	
	
	function checkForm(frm){
		var els = frm.getElementsByTagName('input');
		for (var i = 0; i < els.length; i++) {
			if (els[i] != null) {
				if (els[i].getAttribute("onblur")) {
					checkItem(els[i]);
				}
			}
		}
		return flag;
	}
</script>

</body>
</html>