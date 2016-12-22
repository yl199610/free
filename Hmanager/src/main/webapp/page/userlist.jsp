<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/Hmanager/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
<link type="text/css" rel="stylesheet" href="css/login.css"> 
</head>
<body>
	<table id="upersonList"></table>
	<input type="button" value="获取所有员工信息" onClick="findAll()">
	<table id="umoneyList"></table>
	<form name="oneMoneyForm" id="oneMoneyForm" enctype="multipart/form-data">
		<input id="pid" name="pid" hidden="true" value="${sessionScope.login}"/>
		<input type="button" value="查询工资" onClick="findMy()">
	</form>
	
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/userlist.js"></script>
</body>
</html>