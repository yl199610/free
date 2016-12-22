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
	<form name="moneyForm" id="moneyForm"  enctype="multipart/form-data" style="margin-left: 200px; margin-top: 40px;">
		<input name="pamoney" id="pamoney" required="required" placeholder="请输入金额" /><br/>
		<input name="moneymonth" id="moneymonth" hidden="true"/>
		<input  id="date"  type="text" ></input><br>
		<input class="easyui-combobox" name="punishaward_id" id="punishaward_id" data-options="required:true" onSelect="findPerson()"><br>
		<input type="button" value="添加" onClick="addMoney()">
	</form>
	<script type="text/javascript" src="js/addMoney.js"></script>
	<script type="text/javascript" src="js/addPerson.js"></script></body>
</html>