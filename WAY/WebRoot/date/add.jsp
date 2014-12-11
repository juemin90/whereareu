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

    <form action="<%=request.getContextPath() %>/addDate.do" method="post" enctype="multipart/form-data">
    	title:<input type="text" name="title"> <br/>
		meettime:<input type="text" name="meettime"><br/>
		nickname:<input type="text" name="nickname"><br/>
		longitude:<input type="text" name="longitude"><br/>
		latitude:<input type="text" name="latitude"><br/>
    	<input type="submit" value="register">
	</form>
  </body>
</html>
