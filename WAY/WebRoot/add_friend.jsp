<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">
    <meta http-equiv="content-type" charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Where are you?</title>
    <link rel="stylesheet"href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/docs.min.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div id="user_info">
        <div class="holder">
            <span class="glyphicon glyphicon-user"></span>&nbsp;${sessionScope.user.username}
            <ul class="list-inline" style="float:right">
                <li>
                    
                </li>
                <li>
                    <a href="logout.do" style="float:right"><span class="glyphicon glyphicon-off"></span></a>
                </li>
            </ul>
        </div>
    </div>
    <header>
		<div class="holder">
            <a href="home.do"><h1>Where Are U</h1></a>
		</div>
	</header>
    
    <div class="holder">
       <form id="search"  role="form" action="<%=request.getContextPath() %>/getAllByNickname.do" method="post">
            <input type="text" class="form-control" name="nickname" placeholder="nickname">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>
        </form>
        <table class="table table-striped">
    	<tr>

    		<th>nickname</th>
			<th>edit</th>
    	</tr>
    	<c:forEach var="list"  items="${friendLists}">
    	<tr>
    		<td>${list.friendnickname}</td>
    		<td><a href="addFriend.do?tid=${list.userid}">add</a></td>
    	</tr>
    	</c:forEach> 
    </table>
        
    </div>
</body>
</html>