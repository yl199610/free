$("#leftSider").accordion({
	fit:true,
});


var urlJson={"添加工资":"addMoney.jsp","编辑工资":"editMoney.jsp","添加人员":"addPerson.jsp","编辑人员":"editPerson.jsp","添加部门":"addDp.jsp","编辑部门":"editDp.jsp"}


$(".menutree").tree({
	onClick: function(node){
		//alert(node.text);  // 当单击时弹出节点的文本值
		var nt = node.text;
		if($('#main').tabs('exists',nt)){  //判断面板是否存在
			//打开显示为当前面板 
			$('#main').tabs('select',nt);
		}else{
			//添加面板 
			if(urlJson[nt]){
				$('#main').tabs('add',{
				    title:nt,
				    href:"back/" + urlJson[nt],
				    closable:true,
				});
			}else{
				$('#main').tabs('add',{
				    title:nt,
				    content:'<h1>' + nt + '</h1>',
				    closable:true,
				});
			}
		}
	}
});

$("#main").tabs({
	fit:true,
});

var cnid;
var pid;
function openPerson(id){
	cnid=id;
	$("#personModify").dialog({
		title:'modify',
		width:300,
		height:500,
		left:300,
		modal:true,
		href:'back/modifyPerson.jsp'
	});
}

function openDepartment(id){
	cnid=id;
	$("#modifyDepartment").dialog({
		title:'Department',
		width:300,
		height:200,
		left:300,
		modal:true,
		href:'back/modifyDp.jsp'
	});
}
function openMoney(id,personid){
	cnid=id;
	pid=personid
	$("#modifyMoney").dialog({
		title:'Money',
		width:300,
		height:200,
		left:300,
		modal:true,
		href:'back/modifyMoney.jsp'
	});
}

function closePerson(){
	$("#personModify").dialog("close",true);
}
function closeDp(){
	$("#modifyDepartment").dialog("close",true);
}

function closeMo(){
	$("#modifyMoney").dialog("close",true);
}