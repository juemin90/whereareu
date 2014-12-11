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
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link href='http://fonts.googleapis.com/css?family=Noto+Sans' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/docs.min.css">
</head>
<body>
    <header>
		<div class="holder">
            <h1>Where Are U</h1>
		</div>
	</header>
    <div id="verify" class="content">
        <ul class="list-inline">
        <c:if test="${tab != 1}" >
        <li class="active">LOGIN</li><li>REGISTER</li>
        
        </c:if>
        
        <c:if test="${tab == 1}" >
        <li >LOGIN</li><li class="active">REGISTER</li>
        
        </c:if>
        </ul>
        
		<div class="holder">
            <form id="login"
              <c:if test="${tab != 1}" >
	             class="active" 
	          </c:if>

             role="form" action="<%=request.getContextPath() %>/login.do" method="post">
                <h2 class="form-signin-heading">Sign In</h2>
                <input type="text" class="form-control" placeholder="username" name="username" required>
                <input type="password" class="form-control" placeholder="Password" name="password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                ${InfoMessage}
            </form>
            <form id="register"
            	<c:if test="${tab == 1}" >
	             class="active" 
	          </c:if>
            
             role="form" action="<%=request.getContextPath() %>/addUser.do" method="post" enctype="multipart/form-data">
                <h2 class="form-signin-heading">Sign Up</h2>
                <input type="text" class="form-control" placeholder="username" name="username" required>
                <input type="password" class="form-control" placeholder="Password" name="password" required>
                <input type="email" class="form-control" placeholder="Email address" name="email" required>
                <input type="nickname" class="form-control" placeholder="nickname" name="nickname" required>
                <input type="file" class="form-control" name="file">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Confirm</button>
                <div class="bs-docs-section">
                	${InfoMessage2}
                </div>
            </form>
        </div>
    </div>
</body>
    <script src="js/verify.js"></script>

</html>