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
	<form id="modifyPersonMoney" enctype="multipart/form-data" style="width: 70%; margin: 0px auto">
		<input name="pamoney" id="pamoney" required="required" placeholder="请输入金额" /><br/>
		<input name="moneymonth" id="moneymonth" hidden="true"/>
		<input  id="date"  type="text" class="easyui-datebox"></input><br>
		<input name="punishaward_id" id="punishaward_id" hidden="true"/>
		<input  name="moneypid" id="moneypid" data-options="required:true" onSelect="findOnePerson()"><br>
		<input id="btn" type="button" value="修改" onClick="modifyMoney()">
	</form>
	<script type="text/javascript" src="js/modifyMoney.js"></script>
	<script type="text/javascript" src="js/addMoney.js"></script>
</body>
</html>