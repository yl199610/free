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
	<form name="departmentForm" id="departmentForm"  enctype="multipart/form-data" style="margin-left: 200px; margin-top: 40px;">
		<input name="dpname" id="dpname" required="required" placeholder="请输入部门名" /><br/><br>
		<input type="button" value="添加" onClick="addDepartment()">
	</form>
	<script type="text/javascript" src="js/addDp.js"></script>
	<script type="text/javascript" src="js/addPerson.js"></script>
</body>
</html>