<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/Hmanager/">
<meta charset="UTF-8">
<title>人事管理系统界面</title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
<link href="css/admin1.css" rel="stylesheet" type="text/css" />
</head>
<body class="easyui-layout"  id="layoutBody">
    <div data-options="region:'north'" style="height:145px;">
    	<div id="header">
		<div id="welcome">欢迎使用人事管理系统！</div>
		<div id="nav">
			<div id="a_b01">
				<img src="image/5.png" alt="" />
			</div>
		</div>
	</div>
    </div>
    <div data-options="region:'west',title:'菜单栏',collapsible:false" style="width:180px;">
    	<div id="leftSider">
		    <div title="用户管理" data-options="iconCls:'icon-man'">
		    	<ul class="menutree">
                    <li><span>添加人员</span></li>
                    <li><span>编辑人员</span></li>
				</ul>
		    </div>
		    <div title="部门管理" data-options="iconCls:'icon-man'">
		       	<ul class="menutree">
                    <li><span>添加部门</span></li>
                    <li><span>编辑部门</span></li>
				</ul>
		    </div>
		    <div title="工资管理" data-options="iconCls:'icon-man'">
		     	<ul class="menutree">
                    <li><span>添加工资</span></li>
                    <li><span>编辑工资</span></li>
				</ul>
		    </div>
		</div>
    </div>
    <div data-options="region:'center',">
    	<div id="main" style="width:500px;height:250px;">
		    <div title="主界面" style="background:#ccc">
		      		<h1>欢迎使用人事管理系统</h1>
		    </div>
		</div>
    </div>

	<!-- 子窗口中的对话框 -->
	<!-- 新闻 -->
	<div id="modifyMoney"></div>

	<!-- 部门 -->
	<div id="modifyDepartment"></div>
	
	<!-- 用户 -->
	<div id="personModify"></div>
	
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/admin1.js"></script>
</body>
</html>