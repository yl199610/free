$("#loginDiv").dialog({
	title:"",
	border:false,
	modal:true,
	width:380,
	height:150,
	top:200,
	left:360
});
$('#loginBtn').linkbutton({    
    iconCls: 'icon-man',
    onClick:function(){
    	$("#loginForm").submit();
    }
});

$("#loginForm").form({
	url:"user/login",
    success:function(data){  
    	if(data.trim()=="true"){
    		location.replace("page/admin.jsp");
    	}else if(data.trim()=="true1"){
    		location.replace("page/userlist.jsp");
    	}else{
    		$.messager.show({
    			modal:true,
    			title:'登录信息',
    			msg:'登录失败',
    			showType:'show',
    			style:{
    				top:document.body.scrollTop+document.documentElement.scrollTop,
    			}
    		});
    	}
    }
});