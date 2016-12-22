<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/Hmanager/">
<meta charset="UTF-8">
<title>用户登录</title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
<link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body style="background-image: url('image/4.png');">
	<div id="loginDiv" class="easyui-dialog" style="background: #50A9D1">
		<form id="loginForm" method="post">
			<c:remove var="errorMsg" scope="session" />
			</br> <input name="mid" id="mid" required="required" placeholder="请输入编号" value="141808"/></br>
			</br> <input name="pwd" type="password" required="required" placeholder="请输入密码" value="444"/></br>
			</br> <select name="upower" id="upower">
				<option value="管理员">管理员</option>
				<option value="普通用户">普通用户</option>
			</select>
			<button id="loginBtn">登录</button>
			<br>
		</form>
	</div>

	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/login1.js"></script>
	<script type="text/javascript" src="js/userlist.js"></script>
</body>
</html>