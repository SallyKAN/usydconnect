<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
 <meta charset="UTF-8">
    <title>UsydConnect}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link href='https://fonts.googleapis.com/css?family=Satisfy' rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Arima+Madurai" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
   <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
  <!--  <head>
    <title>UsydConnect</title>
   <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
   
   <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
   <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</head> -->
<!--
<nav class="navbar navbar-default">
 <div class="container-fluid">
  <div class="navbar-header">
     <h1><a class="navbar-header" href="<c:url value="/" />">UsydConnect</a></h1>
       </div>
       <ul class="nav navbar-nav" >
	      <c:choose >
             <c:when test="${not empty username}">

                 	   <a href="<c:url value="/users/profile/${username}" />">${username}</a>
                     <a href="<c:url value="/users/loginOut"/>">Log out</a>
       </c:when>
       <c:otherwise>
   
    					<a href="<c:url value="/users/login" />">Log in</a>
    				<a href="<c:url value="/users/register" />">Register</a> 
    </c:otherwise>
	</c:choose >
	</ul>
	 <div class="serachform">
     <div class="small-4 columns">
        <input type="text" id="txt" name="searchString" placeholder="search...">
      </div>
       <div class="small-4 columns end">
         <button id="button-id" type="submit" >Search</button>
       </div>
   </div>
  </div>

</nav>

  <div class="charOnlineRoom">
 	<c:choose>
		<c:when test="${not empty username}">
			<a href="<c:url value="/msg/turntotalked"/>">Online chat room</a> 
		</c:when>
		<c:otherwise>
			<a href="<c:url value="/users/login" />">online chat room</a>
		    
		</c:otherwise>
	</c:choose>
	
</div> -->
<body>
<div class="container-fluid">
    <nav class="navbar navbar-inverse" id="menu">
        <a class="navbar-brand" id="branding" href="<c:url value="/" />">UsydConnect</a>
        <div id="searchform">
        <form id="searchform" action="<c:url value="/searchPost" />">
            <i class="fa fa-search"></i>
            <input class="searchfield" id="searchTerm" name="searchTerm" type="text" placeholder="Search">
            <button  class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-search"></span></button>
        </form>
        </div>

        <ul class="nav navbar-nav navbar-right" id="menubuttons">
          <li>
                <a href="<c:url value="/msg/turntotalked"/>">
                    <span class="glyphicon glyphicon-comment">chat</span>
                </a>
            </li>
        
           <c:choose >
             <c:when test="${not empty username}">
            <li>
                <a href="<c:url value = "/users/profile/${username}"/>">
                    <span class="glyphicon glyphicon-user">${username}</span>
                </a>
            </li>
            <li><a href="<c:url value="/users/loginOut"/>">
                    <span class="glyphicon glyphicon-log-out">Logout</span>
                  </a>
            </li>
        </c:when>
		<c:otherwise>
		  
            <li><a href="<c:url value="/users/login" />">
            <span class="glyphicon glyphicon-log-in">Login</span>
            </a></li>
            <li><a href="<c:url value="/users/register" />">
           Register
			 </a></li>
    </c:otherwise>
	</c:choose>
            <li>
                <a href="#">
                    <span class="glyphicon glyphicon-globe"></span>
                </a>
            </li>

                  <li>
                <a href="#">
                    <span class="glyphicon glyphicon-question-sign"></span>
                </a>
            </li>

        </ul>
    </nav>

    </div>

</body>

</html>