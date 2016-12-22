$('#personInfo').datagrid({
	fitColumns : true,
	url:'user/list',
	singleSelect : true,
	pagination:true,
	columns : [ [ {
		field : 'pid',
		title : '编号',
		width : 21,
		align:'center'
	}, {
		field : 'pname',
		title : '姓名',
		width : 22,
		align:'center'
	}, {
		field : 'idcard',
		title : '身份证',
		width : 56,
		align:'center'
	},{
		field : 'phonenumber',
		title : '手机号',
		width : 38,
		align:'center'
	}, {
		field : 'sex',
		title : '性别',
		width : 20,
		align:'center'
	}, {
		field : 'birthday',
		title : '生日',
		width : 26,
		align:'center'
	}, {
		field : 'photo',
		title : '照片',
		width : 50,
		align:'center',
		formatter: function(value,row,index){
 		   if(value==null){
			   return "<img width='100' src='image/not_pic.jpg'>"
		   }else{
			   return "<img width='100' src='"+value+"'>"
		   }
		}
	}, {
		field : 'personid',
		title : '部门',
		width : 20,
		align:'center'
	}, {
		field : 'address',
		title : '地址',
		width : 16,
		align:'center'
	}, {
		field : 'position',
		title : '职务',
		width : 14,
		align:'center'
	}, {
		field : 'empdate',
		title : '入职日期',
		width : 26,
		align:'center'
	},{
		field : 'operator',
		title : '操作',
		width : 32,
		align:'center',
		formatter: function(value,row,index){
			var str = '<a class="operatorBtn" href="javascript:void(0)" onClick="funoperatorFun(1, ' 
				+ row.pid + ')">删除</a>&nbsp;'
				+ '<a class="operatorBtn" href="javascript:void(0)" onClick="funoperatorFun(2, ' 
				+ row.pid + ')">修改</a>&nbsp;'
				+ '<script>$(".operatorBtn").linkbutton();</script>';
			return str;
		}

	} ]]
});


function funoperatorFun(operType, id){
	switch(operType){
	case 1:
		stopUser(id);
		break;	
	case 2:
		parent.openPerson(id);
		break;
	}
}


function stopUser(id){
	$.messager.confirm('确认','您确认想要删除记录吗,删除后记录将无法恢复？',function(r){    
	    if (r){
	        $.get("user/archive?cnid="+id,function(data){
				$('#personInfo').datagrid("reload");
	        	$.messager.show({
					title:'归档用户',
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
