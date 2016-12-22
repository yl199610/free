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
	<form id="modifyDps" enctype="multipart/form-data" style="width: 70%; margin: 0px auto">
		<input name="dpid" id="dppid" required="required" readonly="readonly"/>
		<br><br><input id="departname" class="easyui-combobox" name="dpname"  data-options="required:true"><br><br>
		<input id="btn" type="button" value="修改" onClick="modifyDp()">
	</form>
	<script type="text/javascript" src="js/modifyDp.js"></script>
	<script type="text/javascript" src="js/addPerson.js"></script>
</body>
</html>