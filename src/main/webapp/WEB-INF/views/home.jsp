<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
  <style type="text/css">
  .post-title{
     padding-top: 20px;
    padding-bottom: 20px;

}
author{


    font-style: italic;
    font-family: "Century Gothic";
    font-size: small;

}
.post-date{

         font-family: "Century Gothic";
    font-size: small;

    padding-top: 10px;
     padding-bottom: 20px;
      border-bottom: solid slategray 2px;
}
.float-left{
    float:left;
}

.float-right{
    float:right;
}
  </style>
  <meta charset="UTF-8">
    <title>UsydConnect</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link href='https://fonts.googleapis.com/css?family=Satisfy' rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Arima+Madurai" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
   <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   <link rel="stylesheet" type="text/css" href="resources/style.css"/>
   <jsp:include page="header.jsp"></jsp:include>
   <title>UsydConnect</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <body>
  <div id="index_heading">Share and Connect</div>
    <div class="container-fluid" id="index_content">
 
     <div class="row">
        <div class="col-md-3">
        <a href="<c:url value="/posts/create"/>" id="new_post"><span class="glyphicon glyphicon-pencil"></span>Create Post</a>
                <div id="tag_header">Tags</div>
                <c:forEach items="${tags}" var="tags" >
            <a href="<c:url value="/posts/${tags.name}"/>" id="tag_list">#${tags.name}</a> 
            </c:forEach>
            </div>
            <div class="col-md-7">
            <div class="sort-box float-right">
               <form class="form-horizontal" action ="<c:url value="/sort"/>" method='get'>
                    <select id="filter" name="value" onchange="filterContent();">
						<option value="oldest">Oldest</option>
						<option value="newest">Newest</option>
						
						
					</select>
                   <input type='submit' value='Sort'>
                </form>
              </div>
              
            <div class="container" id="post_list">
       
            <h3 id="recent_post">Recent posts</h3>
    
                <c:forEach items="${posts}" var="posts" >
        <div class="post-title">
            <h3><a href="<c:url value="/posts/view/${posts.id}"/>"> ${posts.title}</a></h3>
            <span class="author float-right"> published by: <a href="<c:url value = "/users/profile/${username}"/>">${posts.postUsername}</a></span>
        </div>
        <div class="post-date">
            <div class="float-left"> ${posts.getTime()} </div>
            <div class="float-right">${posts.commentCount} comments </div>
        </div>
   		
				</c:forEach>
               
               </div>
              </div>
              </div>
           </div>

 
<jsp:include page="footer.jsp" />
  </body>
</html>
