$(function(){
	$("#dg_par_enums").datagrid({  
		
	    url:'getParEnumsList.html',   
	    loadMsg : '正在玩命的为您加载。。。', //加载数据是显示的提示 
	    pagination : true, //是否显示分页工具栏
		fitColumns : true,  //真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
		rownumbers : false,  //是否显示行号
		singleSelect : true,  //只允许选择一行
		//fit:true, //自动适应高度和宽度
		striped : true,  //表格显示条纹
		pageSize:5,  //初始页面显示数据条数
		pageNumber:1, //当前页码
		pageList:[1,5,10,15], // 选择当页显示数据显示条数
		scrollbarSize: 0,   //滚动条的宽度
		
		toolbar: [{
			iconCls: 'icon-add',
			text : "新增",
			width :70,
			handler: function(){
				openAddParEnums();
			}
		},'-',{
			iconCls: 'icon-edit',
			text : "修改",
			width :70,
			handler: function(){
				var rowData = $('#dg_news').datagrid("getSelected");
				if(rowData!=null){
					openUpdateNewsInfo(rowData.id);
				}else{
					alertMsgBox("提示","请选择要修改的数据!","info");
				}
			}
		},'-',{
			iconCls: 'icon-remove',
			text : "删除",
			width :70,
			handler: function(){
				var rowData = $('#dg_par_enums').datagrid("getSelected");
				if(rowData!=null){
					$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
					    if (r){    
					        //deleteNewsInfo();
					    }    
					});
				}else{
					alertMsgBox("提示","请选择要删除的数据!","info");
				}
			}
		},],  
	    columns:[[    
	        {
	        	field:'sysId',
	        	title:'编号',
	        	width:100,
	        	align:'center'
	        },{
	        	field:'sysKey',
	        	title:'枚举名称',
	        	width:100,
	        	align:'center'
	        }, {
	        	field:'sysValue',
	        	title:'枚举值',
	        	width:100,
	        	align:'center'
	        },{
	        	field:'sysDesc',
	        	title:'详细描述',
	        	width:100,
	        	align:'center'
	        },{
	        	field:'updateTime',
	        	title:'修改时间',
	        	width:100,
	        	align:'center'
	        },{
	        	field:'isDelete',
	        	title:'是否生效',
	        	width:100,
	        	align:'center',
	        	formatter : function(value,row,index){
					if(value==0){
						return "生效";
					}else{
						return "无效";
					}
				}}    
	    ]]    
	
	}); 
	page("par_enums");
});


function openAddParEnums(){
	$('#dd_par_enums_add').dialog({    
	    title: "添加父类枚举类型",    
	    width: 400,    
	    height: 200,    
	    closed: false,    
	    cache: false,    
	    href: '',    
	    modal: true ,
	    buttons:[{ 
			text:'确定', iconCls:'icon-ok', onClick:function(){ alert("OK!")} 
		},{
			text:'取消', iconCls:'icon-cancel', onClick:function(){ $("#dd_par_enums_add").dialog('close');}
	}]
	});   
}