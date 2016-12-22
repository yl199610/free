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
	<form id="modifyPersons" enctype="multipart/form-data" style="width: 70%; margin: 0px auto">
		<input name="pid" id="pppid" required="required" readonly="readonly"/><br />
		<input name="pname" id="pppname" required="required" placeholder="请输入姓名" /><br />
		<input name="idcard" id="pppidcard" required="required" placeholder="请输入身份证" /><br />
		<input name="phonenumber" id="ppphonenumber" required="required" placeholder="请输入手机号" /><br />
		<input name="sex" id="pppsex" required="required" placeholder="请输入性别" /><br />
		<input name="birthday" id="pppbirthday" required="required" placeholder="请输入生日" /><br />
		<label> 上传图片 </label> 
		<input name="file" type="file" onchange="addPicPath(this)" multiple="multiple" />
	    <input type="hidden" name="f" id="f" />
		<img alt="" src="image/not_pic.jpg" width="100" id="pppcurrPic"><br>
		<input id="pppower" name="ppower" style="width: 145px;">
		<input class="easyui-combobox" name="personid" id="personid" data-options="required:true" onSelect="findDepart()"><br>
		<input name="address" id="pppaddress" required="required" placeholder="请输入地址" /><br />
		<input name="position" id="ppposition" required="required" placeholder="请输入职务" /><br />
		<input name="empdate" id="pppempdate" required="required" placeholder="请输入入职时间" /><br />
		<input type="button" value="修改" onClick="modifyPerson()">
	</form>
	<script type="text/javascript" src="js/modifyPerson.js"></script>
	<script type="text/javascript" src="js/addPerson.js"></script>
</body>
</html>