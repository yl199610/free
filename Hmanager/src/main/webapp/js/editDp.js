$('#departmentInfo').datagrid({
	fitColumns : true,
	url:'dp/list',
	singleSelect : true,
	pagination:true,
	columns : [ [ {
		field : 'dpid',
		title : '部门编号',
		width : 30,
		align:'center'
	}, {
		field : 'dpname',
		title : '部门名称',
		width : 26,
		align:'center'
	} ,{
		field : 'operator',
		title : '操作',
		width : 40,
		align:'center',
		formatter: function(value,row,index){
			var str = '<a class="operatorBtn" href="javascript:void(0)" onClick="dpOperatorFun(1, ' 
				+ row.dpid + ')">删除</a>&nbsp;'
				+ '<a class="operatorBtn" href="javascript:void(0)" onClick="dpOperatorFun(2, ' 
				+ row.dpid + ')">修改</a>&nbsp;'
				+ '<script>$(".operatorBtn").linkbutton();</script>';
			return str;
		}
	} ]]
});


function dpOperatorFun(operType, id){
	switch(operType){
	case 1:
		stopDp(id);
		break;	
	case 2:
		parent.openDepartment(id);
		break;
	}
}


function stopDp(id){
	$.messager.confirm('确认','您确认想要删除记录吗,删除后记录将无法恢复？',function(r){    
	    if (r){
	        $.get("dp/archive?cnid="+id,function(data){
				$('#departmentInfo').datagrid("reload");
	        	$.messager.show({
					title:'删除部门',
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
