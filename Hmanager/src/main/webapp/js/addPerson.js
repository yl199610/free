$(document).ready(function() {
	queryXzqh();
	findPerson();
})

function restUser(){
	$("#resetBtn").linkbutton('resize');
}

$("#ppower").append("<option value='1'>普通用户</option>");
$("#ppower").append("<option value='0'>管理员</option>");

$("#ppower").combobox({})
//加载部门
function queryXzqh() {
	$("#personid").combobox({
		url:'dp/list',// 获取数据
		method : "post",
		valueField : 'dpid',
		textField : 'dpname',
	})
}

//加载所有人员
function findPerson() {
	$("#managername").combobox({
		url:'user/getAllPerson',
		method : "post",
		valueField : 'pname',
		textField : 'pname',
	})
	$("#punishaward_id").combobox({
		url:'user/getAllPerson',
		method : "post",
		valueField : 'pid',
		textField : 'pname',
	})
}


function addPic(obj){
	var picStr=window.URL.createObjectURL(obj.files[0]);
	//alert(picStr);
	$("#acurrPic").attr("src",picStr);
	var upFile=document.personForm.file.value;
	$("#f").html(upFile);
}


// 添加用户
function addUser() {
	var pid=$('#personid').combobox('getValue');//获得选中的值
	var ppower=$('#ppower').combobox('getValue');
	var formData = new FormData($("#personForm")[0]); // FormData
	$.ajax({
		url : 'user/add?pid='+pid+'&ppower='+ppower,
		type : 'POST',
		data : formData,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(returndata) {
			$('#userInfo').datagrid("reload");
			$.messager.show({
				title : '添加用户',
				msg : returndata.trim()=="true"? "添加成功..." : "添加失败!!!",
				showType : 'show',
				style : {
					top : document.body.scrollTop+document.documentElement.scrollTop + 40,
				}
			});
		}
	});
}