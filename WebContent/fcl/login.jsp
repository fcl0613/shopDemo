<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
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
    		height:40px;
    		width:40px;
    	}
    	
    	.code1{
    		width:150px;
    		height:40px;
    		border-radius:3px;
    	}
    	
    	.dd{
    		margin-top:8px;
    	}
    </style>
</head>
<body><!-------------------login-------------------------->
<div class="reg">
    <form action="login" method="post" onsubmit="return checkForm(this)">
    	<h1>用户登录</h1>
    	<div class="msg-warn hide dd"><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p><input type="text" name="username" value="" placeholder="昵称/邮箱/手机号" onblur="checkItem(this)"><span class="error" id="err"></span></p>
        <p><input type="text" name="password" value="" placeholder="请输入密码" onblur="checkItem(this)"><span class="error" id="err"></span></p>
        <p class="txtL txt"><input class="code" type="text" name="code" value="" placeholder="验证码" onblur="checkItem(this)"><img
                src="getcode" alt="看不清，换一张" onclick="changeImg(this)" class="imgcss"><span class="error1" id="err"></span></p>
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt"><a class="" href="reg.jsp">免费注册</a><a href="forget.html">忘记密码？</a></p>
        </form>
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
					b.html('用户名不合法');
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