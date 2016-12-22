//前面父窗口定义的cnid能在这个弹出窗口中显示  说明弹出窗口是嵌套在父窗口下   
$.get("user/getPerson?cnid="+cnid,function(data){
	$("#pppid").val(cnid);
	$("#pppname").val(data.pname);
	$("#pppidcard").val(data.idcard);
	$("#ppphonenumber").val(data.phonenumber);
	$("#pppsex").val(data.sex);
	$("#pppbirthday").val(data.birthday);
	$("#pppcurrPic").attr("src",data.photo);
	$('#pppower').combobox('setValue',data.ppower);
	$("#personid").val(data.personid);
	$("#pppaddress").val(data.address);
	$("#ppposition").val(data.position);
	$("#pppempdate").val(data.empdate);
},"json");


$("#pppower").append("<option value='1'>普通用户</option>");
$("#pppower").append("<option value='0'>管理员</option>");

$("#pppower").combobox({})

function addPicPath(obj){
	var picStr=window.URL.createObjectURL(obj.files[0]);
	$("#pppcurrPic").attr("src",picStr);
}

//修改用户
function modifyPerson(){
	 var formData = new FormData($("#modifyPersons")[0]);	//FormData
	 $.ajax({  
		  url: 'user/modify',
		  type: 'POST',
		  data: formData,
		  async: false,  
		  cache: false,  
		  contentType: false,  
		  processData: false,  
		  success: function (returndata) {  
			 if(returndata.trim()=="true"){
				 alert("df");
				 parent.closePerson();
				 $('#personInfo').datagrid("reload");
			 }
			 $.messager.show({
					title:'修改用户',
					msg:returndata.trim()=="true"?"修改成功...":"修改失败!!!",
					showType:'show',
					style:{
						top:document.body.scrollTop+document.documentElement.scrollTop+40,
					}
				});
		  }
	 }); 
}