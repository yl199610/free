var pid=$("#pid").val();
function findMy(){
	$("#umoneyList").datagrid({
		url : "money/getOnePerson?pid="+pid,
		pagination : true,
		fitColumns : true,
		singleSelect : true,
		columns : [ [ {
			field : 'paid',
			title : '编号',
			width : 20,
			align : 'center'
		}, {
			field : 'pamoney',
			title : '工资',
			width : 10,
			align : 'center'
		} , {
			field : 'moneymonth',
			title : '月份',
			width : 10,
			align : 'center'
		} ] ]
	});
}
	

function findAll() {
	$("#upersonList").datagrid({
		url : "user/list",
		pagination : true,
		fitColumns : true,
		pageList : [ 5, 10, 15, 20, 25, 30 ],
		singleSelect : true,
		columns : [ [ {
			field : 'pid',
			title : '编号',
			width : 25,
			align : 'center'
		}, {
			field : 'pname',
			title : '姓名',
			width : 70,
			align : 'center'
		}, {
			field : 'position',
			title : '职称',
			width : 40,
			align : 'center'
		}, ] ]
	});
}
