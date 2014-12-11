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
    <form action="<%=request.getContextPath() %>/updateUser.do" method="post">

    	用户名：<input type="text" name="username" value="${user.username }"><br/>
		密码：<input type="password" name="pwd" value="${user.pwd }"><br/>
				name：<input type="text" name="name" value="${user.name }"><br/>
		telphone：<input type="text" name="telphone" value="${user.telphone }"><br/>
		email：<input type="text" name="email" value="${user.email }"><br/>
		<input type="hidden" name="userid" value="${user.userid }">
    <input type="submit" value="提交数据">

      </form>
  </body>
</html>
