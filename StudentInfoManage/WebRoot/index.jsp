<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>学生信息管理系统登录</title>
		<link rel="icon" href="images/favicon.gif" type="image/gif"/>
<script type="text/javascript">
function resetValue() {
	document.getElementById("userName").value = "";
	document.getElementById("password").value = "";
	document.getElementById("vcode").value = "";
}

var code; //在全局 定义验证码  
function createCode() {
	code = "";
	var codeLength = 5;//验证码的长度  
	//所有候选组成验证码的字符，可以用中文  
	var selectChar = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C',
			'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c',
			'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
	for ( var i = 0; i < codeLength; i++) {
		var charIndex = Math.floor(Math.random() * 60);
		code += selectChar[charIndex];
	}
	return code;
}

function validate() {
	var inputCode = document.getElementById("vcode").value.toLowerCase();
	if (inputCode.length <= 0) {
		alert("请输入验证码！");
		return false;
	} else if (inputCode != code.toLowerCase()) {
		alert("验证码输入错误！");
		show();//刷新验证码  
		return false;
	} else {
		alert("^-^ OK");
		return true;
	}
}

function show() {
	//显示验证码  
	document.getElementById("code").src = "codeServlet?code=" + createCode();
}

window.onload = function() {//document.onload=show();  
	show();//页面加载时加载验证码  
	//这时无论在ie还是在firefox中，js没有加载完，页面的东西是不会被执行的；  
}
</script>
		<style type="text/css">
table,input {
	font-size: 18px;
}
</style>
	</head>
	<body>
		<div align="center" style="padding-top: 5px">
			<form action="login" method="post">
				<table width="1400px" height="740px" background="images/login.jpg"
					border="0">
					<tr height="310px">
						<td colspan="4"></td>
					</tr>
					<tr height="20px">
						<td width="46%"></td>
						<td colspan="2">
							<font color="red">${error }</font>
						</td>
						<td width="44%"></td>
					</tr>
					<tr height="20px">
						<td width="46%"></td>
						<td width="10%">
							用户名：
						</td>
						<td>
							<input type="text" style="width: 160px; height: 20px;"
								value="${userName }" name="userName" id="userName" />
						</td>
						<td width="44%"></td>
					</tr>
					<tr height="20px">
						<td width="46%"></td>
						<td width="10%">
							密&nbsp;&nbsp;码：
						</td>
						<td>
							<input type="password" style="width: 160px; height: 20px;"
								value="${password }" name="password" id="password" />
						</td>
						<td width="44%"></td>
					</tr>
					<tr height="20px">
						<td width="46%"></td>
						<td width="10%">
							验证码：
						</td>
						<td>
                            <input type="text" id="vcode" style="width: 60px; height: 20px;" maxLength="5" />  
                            <img src="" id="code" style="width: 80px; height: 25px;" onclick="javascript:show();return false;" />  
						</td>
						<td width="44%"></td>
					</tr>
					<tr height="60px">
						<td width="46%"></td>
						<td width="10%">
							<input type="submit" value="登录" />
						</td>
						<td>
							<input type="button" value="重置" onclick="resetValue()" />
						</td>
						<td width="44%"></td>
					</tr>

					<tr>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>