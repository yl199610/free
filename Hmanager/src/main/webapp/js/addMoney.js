//添加的部门名称下拉在addPerson.js
$('#date').datebox({    
    required:true,
    onSelect: function(date){
        $("#moneymonth").val(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());
    }
});

function addMoney() {
	var formData = new FormData($("#moneyForm")[0]); // FormData
	$.ajax({
		url : 'money/add',
		type : 'POST',
		data : formData,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(returndata) {
			$('#moneyInfo').datagrid("reload");
			$.messager.show({
				title : '添加工资',
				msg : returndata.trim()=="true"? "添加成功..." : "添加失败!!!",
				showType : 'show',
				style : {
					top : document.body.scrollTop+document.documentElement.scrollTop + 40,
				}
			});
		}
	});
}