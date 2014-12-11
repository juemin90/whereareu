<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>register</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  
    <form action="<%=request.getContextPath() %>/addUser.do" method="post" enctype="multipart/form-data">
    	username:<input type="text" name="username"> <br/>
		password:<input type="password" name="password"><br/>
		email:<input type="text" name="email"><br/>
		nickname:<input type="text" name="nickname"><br/>
		imgfile:<input type="file" name="file"><br/>
    	<input type="submit" value="register">
	</form>
  </body>
</html>
