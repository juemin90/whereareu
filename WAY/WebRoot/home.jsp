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
	
    <div id="verify" class="content">
        <ul class="list-inline">
        <c:if test="${tab != 1}" >
        <li class="active">DATE</li><li>FRIEND</li>
        </c:if> 
        <c:if test="${tab == 1}" >
        <li >DATE</li><li class="active">FRIEND</li>
        </c:if>
        </ul>
        <div class="holder">
            <div id="date_list"
              <c:if test="${tab != 1}" >
	             class="active info-list" 
	          </c:if>     
              <c:if test="${tab == 1}" >
	             class="info-list" 
	          </c:if>
            >
                <table class="table table-striped">
                    <tr>
                        <th>Title</th>
                        <th>Time</th>
                        <th>With</th>
                        <th>Edit</th>
                    </tr>
                  
	        <c:forEach var="list"  items="${dateLists}">
	    	<tr>
	    		
	    		<td><a href="date.jsp?dateid=${list.dateid}&userid=${sessionScope.user.userid}">${list.title}</a></td>
	    		<td>${list.meettime}</td>
	    		
	    		<td>${list.nickname}</td>
	
	    		<td><a href="delDate.do?tid=${list.dateid}" class="glyphicon glyphicon-remove"  onclick="if(confirm('Delete Friend?')==false) return false;"></a></td>
	    	</tr>
	    	</c:forEach> 
  
                </table><nav>
              <div style="overflow:hidden">
				  <ul class="pagination" style="float:right;">
				      <li><a href="#">&laquo;</a></li>
				      <li><a href="#">1</a></li>
				      <li><a href="#">&raquo;</a></li>
				  </ul>
              </div>
			</nav>
                <a href="add.jsp" class="btn btn-primary btn-block btn-lg">New Date</a>
            </div>
            
            <div id="friend_list" 
              <c:if test="${tab != 1}" >
	             class="info-list" 
	          </c:if>
            
              <c:if test="${tab == 1}" >
	             class="active info-list" 
	          </c:if>
	          >
	          
                <table class="table table-striped">
                    <tr>
                        <th>Name</th>
                        <th>Edit</th>
                    </tr>
			   		<c:forEach var="list"  items="${friendLists}">
			    	<tr>
			    		<td>${list.friendnickname}</td>
			    		<td><a href="delFriend.do?tid=${list.id}" class="glyphicon glyphicon-remove"  onclick="if(confirm('Delete Friend?')==false) return false;"></a></td>
			    	</tr>
			    	</c:forEach>
                </table>
                <a href="add_friend.jsp" class="btn btn-primary btn-block btn-lg">Add Friend</a>
            </div>
        </div>
    </div>
    <script src="js/verify.js"></script>
</body>
</html>