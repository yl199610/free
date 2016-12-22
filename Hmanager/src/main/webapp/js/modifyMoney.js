$(document).ready(function() {
	findOnePerson();
})
$.get("money/getMsg?cnid="+cnid,function(data){
	var mondata=data.moneymonth;
	$('#pamoney').val(data.pamoney);
	$('#date').val(mondata);	// 设置日期输入框的值
	$('#moneymonth').val(mondata);
	$('#moneypid').combobox('setValue',data.person.pid);
	$('#punishaward_id').val(data.person.pid);
},"json");


function findOnePerson() {
	$("#moneypid").combobox({
		url:'user/getAllPerson',
		method : "post",
		valueField : 'pid',
		textField : 'pname',
		editable:false,
	})
}
//修改
function modifyMoney(){
	 var ppower=$('#moneypid').combobox('getValue');
	 $('#punishaward_id').val(ppower);
	 var formData = new FormData($("#modifyPersonMoney")[0]);	//FormData
	 $.ajax({  
		  url: 'money/modify?cnid='+cnid,
		  type: 'POST',
		  data: formData,
		  async: false,  
		  cache: false,  
		  contentType: false,  
		  processData: false,  
		  success: function (returndata) {  
			 if(returndata.trim()=="true"){
				 parent.closeMo();
				 $('#moneyInfo').datagrid("reload");
			 }
			 $.messager.show({
					title:'修改工资',
					msg:returndata.trim()=="true"?"修改成功...":"修改失败!!!",
					showType:'show',
					style:{
						top:document.body.scrollTop+document.documentElement.scrollTop+40,
					}
				});
		  }
	 }); 
}