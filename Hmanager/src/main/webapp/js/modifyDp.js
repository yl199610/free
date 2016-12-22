$(document).ready(function() {
	findAllPerson();
	findAllDp();
})
//加载部门
function findAllDp() {
	$("#departname").combobox({
		url:'dp/list',// 获取数据
		method : "post",
		valueField : 'dpname',
		textField : 'dpname',
	})
}

//加载所有人员
function findAllPerson() {
	$("#dpmanagername").combobox({
		url:'user/getAllPerson',
		method : "post",
		valueField : 'pname',
		textField : 'pname',
	})
}

$.get("dp/getMsg?cnid="+cnid,function(data){
	$('#dppid').val(cnid);
	$('#departname').combobox('setValue',data.dpname);
	$("#dpmanagername").combobox('setValue',data.managername);
},"json");

//修改
function modifyDp(){
	 var formData = new FormData($("#modifyDps")[0]);	//FormData
	 $.ajax({  
		  url: 'dp/modify',
		  type: 'POST',
		  data: formData,
		  async: false,  
		  cache: false,  
		  contentType: false,  
		  processData: false,  
		  success: function (returndata) {  
			 if(returndata.trim()=="true"){
				 parent.closeDp();
				 $('#departmentInfo').datagrid("reload");
			 }
			 $.messager.show({
					title:'修改部门',
					msg:returndata.trim()=="true"?"修改成功...":"修改失败!!!",
					showType:'show',
					style:{
						top:document.body.scrollTop+document.documentElement.scrollTop+40,
					}
				});
		  }
	 }); 
}