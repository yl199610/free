<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/Hmanager/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
</head>
<body>
	<form name="personForm" id="personForm"
		style="margin-left: 200px; margin-top: 40px;">
		<input name="pname" required="required" placeholder="请输入姓名" /><br />
		<input name="idcard" required="required" placeholder="请输入身份证" /><br />
		<input name="phonenumber" required="required"
			placeholder="请输入手机号" /><br /><input name="sex"
			required="required" placeholder="请输入性别" /><br /> <input
			name="birthday" required="required" placeholder="请输入生日" /><br />
		<label> 上传图片 </label> <input name="file" type="file"
			onchange="addPic(this)" multiple="multiple" /><br> <input
			type="hidden" name="f" id="f" /> <img alt="" src="image/not_pic.jpg"
			width="100" id="acurrPic"><br> <select id="ppower"
			name="ppower" style="width: 145px;">
		</select><br> <input class="easyui-combobox" name="personid" id="personid" data-options="required:true" onSelect="findDepart()"><br>
		<input name="address" required="required" placeholder="请输入地址" /><br />
		<input name="position" required="required" placeholder="请输入职务" /><br />
		<input name="empdate" required="required" placeholder="请输入职日期" /><br />
		<input type="button" value="添加" onClick="addUser()">
	</form>
	<script type="text/javascript" src="js/addPerson.js"></script>
</body>
</html>