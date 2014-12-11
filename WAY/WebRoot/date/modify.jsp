<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改数据</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="<%=request.getContextPath() %>/updateDate.do" method="post">
<!--  dateid,title,meettime,createuserid,withuserid,longitude,latitude -->
    	title:<input type="text" name="title" value="${date.title }"> <br/>
		meettime:<input type="text" name="meettime" value="${date.meettime }"><br/>
		longitude:<input type="text" name="longitude" value="${date.longitude }"><br/>
		latitude:<input type="text" name="latitude" value="${date.latitude }"><br/>
		
		<input type="hidden" name="dateid" value="${date.dateid }">
    <input type="submit" value="提交数据">

      </form>
  </body>
</html>
