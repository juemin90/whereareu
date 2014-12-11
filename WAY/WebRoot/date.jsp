<%@ page language="java" import="java.util.*" pageEncoding="EUC-KR"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewDate.jsp' starting page</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet"href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&v=3&libraries=geometry"></script>
    
    <link href='http://fonts.googleapis.com/css?family=Noto+Sans' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/showmap.css"> 

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
        <div id="map"></div>
        <div id="controller">
            <a href="home.jsp" class="btn btn-default btn-lg btn-block">Back</a>
        </div>
    </div>
</body>
    <script src="js/showdate.js"></script>
  </body>
</html>
