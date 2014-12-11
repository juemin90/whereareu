<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>所有数据</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <!--  datename, password , email , nickname, imgpath -->
  <body>
    所有结果<br/>
    <table border="1">
      <!--  dateid,title,meettime,createuserid,withuserid,longitude,latitude -->
    	<tr>
    		<td>dateid</td>
    		<td>title</td>
    		<td>meettime</td>
    		<td>createuserid</td>
    		<td>withuserid</td>
    		<td>longitude</td>
    		<td>latitude</td>
    		<td></td>
    	</tr>
    	<c:forEach var="list"  items="${dateLists}">
    	<tr>
    		<td>${list.dateid}</td>
    		<td>${list.title}</td>
    		<td>${list.meettime}</td>
    		<td>${list.createuserid}</td>
    		<td>${list.withuserid}</td>
    		<td>${list.longitude}</td>
    		<td>${list.latitude}</td>
    		<td><a href="modifyDate.do?tid=${list.dateid}">更新</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="delDate.do?tid=${list.dateid}">删除</a></td>
    	</tr>
    	</c:forEach> 
    </table>
  </body>
</html>
