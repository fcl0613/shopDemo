<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
	<link rel="stylesheet" type="text/css" href="css/admin_login.css"/>
	<script src="js/jquery-1.12.4.min.js"></script>
	<style>
		.error{
    		display:block;
    		color:#ff5151;
    		padding-top:5px;
    		text-align:left;
    		width:200px;
    	}
	</style>
</head>
<body>
<div class="admin_login_wrap">
    <h1>后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="adminlogin" method="post" onsubmit="return checkForm(this)">
                <ul class="admin_items">
                    <li>
                        <label for="user">用户名：</label>
                        <input type="text" name="username" value="" id="user" size="40" class="admin_input_style" 
                    	onblur="checkItem(this)"><span class="error" id="err"></span>
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="password" value="" id="pwd" size="40" class="admin_input_style" 
                    	onblur="checkItem(this)"><span class="error" id="err"></span>
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="提交" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <p class="admin_copyright"><a tabindex="5" href="#" target="_blank">返回首页</a> 
    
<script>

	var flag = true;

	
	function checkItem(obj){
		var v = obj.value;
		var b;
		var name = $(obj).attr('name');
		b = $(obj).next("span");
		switch(name){
			case"username":
				if (v != "" || v != null) {
					b.html('用户名不能为空');
					b.addClass('error');
					flag = false;
				}else{
					b.html("").removeClass("error");
					flag = true;
				}
				break;
			case"password":
				if (v=="") {
					b.html('密码不能为空');
					b.addClass('error');
					flag = false;
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