//添加的部门名称下拉在addPerson.js
function addDepartment() {
	var formData = new FormData($("#departmentForm")[0]); // FormData
	$.ajax({
		url : 'dp/add',
		type : 'POST',
		data : formData,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(returndata) {
			$('#departmentInfo').datagrid("reload");
			$.messager.show({
				title : '添加部门',
				msg : returndata.trim()=="true"? "添加成功..." : "添加失败,或许部门已经存在!!!",
				showType : 'show',
				style : {
					top : document.body.scrollTop+document.documentElement.scrollTop + 10,
				}
			});
		}
	});
}