$('#moneyInfo').datagrid({
	fitColumns : true,
	url:'money/list',
	singleSelect : true,
	pagination:true,
	columns : [ [ {
		field : 'paid',
		title : '编号',
		width : 14,
		align:'center'
	}, {
		field : 'pamoney',
		title : '工资',
		width : 12,
		align:'center'
	}, {
		field : 'moneymonth',
		title : '工资日期',
		width : 20,
		align:'center'
	} ,{
		field : 'pname',
		title : '员工姓名',
		width : 16,
		align:'center',
		formatter: function(value,row,index){
			return row['person']['pname'];
		}
	} ,{
		field : 'pid',
		title : '员工编号',
		width : 16,
		align:'center',
		formatter: function(value,row,index){
			return row['person']['pid'];
		}
	} ,{
		field : 'operator',
		title : '操作',
		width : 20,
		align:'center',
		formatter: function(value,row,index){
			var str = '<a class="operatorBtn" href="javascript:void(0)" onClick="moneyOperatorFun(1, ' 
				+ row.paid + ')">删除</a>&nbsp;'
				+ '<a class="operatorBtn" href="javascript:void(0)" onClick="moneyOperatorFun(2, ' + row.paid+','+row.paid +')">修改</a>&nbsp;'
				+ '<script>$(".operatorBtn").linkbutton();</script>';
			return str;
		}
	} ]]
});


function moneyOperatorFun(operType, id,pid){
	switch(operType){
	case 1:
		stopMon(id);
		break;	
	case 2:
		parent.openMoney(id,pid);
		break;
	}
}


function stopMon(id){
	$.messager.confirm('确认','您确认想要删除记录吗,删除后记录将无法恢复？',function(r){    
	    if (r){
	        $.get("money/arch?cnid="+id,function(data){
				$('#moneyInfo').datagrid("reload");
	        	$.messager.show({
					title:'删除工资',
					msg:returndata.trim()=="true"?"删除成功...":"删除失败!!!",
					showType:'show',
					style:{
						top:document.body.scrollTop+document.documentElement.scrollTop+40,
					}
				});
	        },"json");   
	    }    
	});
}
