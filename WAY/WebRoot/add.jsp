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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page"><link rel="stylesheet"href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
	<link rel="stylesheet" type="text/css" href="css/showmap.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
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
    <form action="<%=request.getContextPath() %>/addDate.do" method="post">
        <h2 class="form-signin-heading">New Date</h2>
    	<input type="text" class="form-control" placeholder="Title" name="title" required>
		<input type="date" class="form-control" placeholder="Date" name="meettime" required>
		<input type="text" class="form-control" placeholder="With" name="nickname" required>
		${InfoMessage}
		<div id="map"></div>
		<input type="text"  class="form-control" placeholder="Longitude" name="longitude" id="longitude" required >
		<input type="text"   class="form-control" placeholder="Latitude" name="latitude"  id="latitude" required >
    	<input type="submit" class="btn btn-primary btn-block" value="confirm">
	</form>
	</div>
    <script src="js/showmap.js"></script>
  </body>
</html>
