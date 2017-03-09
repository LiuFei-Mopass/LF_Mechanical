<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


	<link rel="stylesheet" type="text/css" href="<%=path%>/view/backstage/easyui/themes/default/easyui.css" />   
	<link rel="stylesheet" type="text/css" href="<%=path%>/view/backstage/easyui/themes/icon.css" />   
	<script type="text/javascript" src="<%=path%>/view/backstage/easyui/jquery-1.8.3.min.js"></script>   
	<script type="text/javascript" src="<%=path%>/view/backstage/easyui/jquery.easyui.min.js"></script> 
	<script type="text/javascript" src="<%=path%>/view/backstage/js/enums.js"></script> 
	<script type="text/javascript" src="<%=path%>/view/backstage/js/easyui_public.js"></script> 
	<style type="text/css">
	html,body,div{margin: 0;padding:0;}
	
	</style>
</head>
<body>

<table id="dg_par_enums"></table> 
<div id="dd_par_enums_add"></div> 

</body>
</html>