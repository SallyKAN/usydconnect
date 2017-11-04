<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 

<html>
  <head>
  <style type="text/css">
 .container-fluid{

    margin: 0;
    padding:0;

}

#menu{
    /*Navigation Bar*/
    background-color: whitesmoke; /*change default bootstrap*/
    border-color: white; /*change default bootstrap*/
    font-family: 'Josefin Sans', sans-serif; /*google font*/

    -webkit-border-radius: 0; /*change default bootstrap*/
    -moz-border-radius: 0; /*change default bootstrap*/
    border-radius: 0; /*change default bootstrap*/

    padding-left: 10px;
    padding-right: 10px;
    max-height: 75px;
    margin: 0;


}

#branding{
    /*logo*/

    color: #000000;
    font-family: 'Kaushan Script', cursive; /*google font*/
    font-size: 40px;
}

/*css for right navbar options*/
#menubuttons{
    position: relative;
    top:-40px;
    margin: 5px;
    font-size:20px;
        background-color: whitesmoke;
    border: 2px transparent;
    border-radius: 5px;
    -webkit-transition-duration: 1s; /* Safari */
    transition-duration: 1s;
}

#menubuttons>li:hover{
    background-color: black;

    
}
#menubuttons>li>a{

    color: #000000;



}




#menubuttons>li>a:hover{

    color: white;


}

#searchbutton{

    color: #000000;
    padding:8px;
    background-color:red;
    font-size:15px;
}

#searchbutton:hover{
    color: red;
    background-color: #000000;
}


input[type=text], select {
    margin-top: 10px;
    height: 35px;
    width: 500px;
    margin-left: 75px;


}

.loginstatus{
    font-size: 15px;
    padding:10px;

}
#id_honeypot {
    display: none;
}
  </style>
    <jsp:include page="header.jsp"></jsp:include>
    <title>${post.title}</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
 <body>
 <div class="container">

        <div class="row">
            <div class="col-lg-10">
    <h1>${post.title}</h1>     
    <p class="lead"><i class="fa fa-user"></i> by <a href="">${post.postUsername}</a></p>
    <hr>
                <p><i class="fa fa-calendar"></i> Posted on ${date}</p>
				<p><i class="fa fa-tags"></i> Tags:
				 <c:forEach items="${tags}" var="tags">
				 <a href=""><span class="badge badge-info">#${tags.name}</span></a>
				</c:forEach>
                
                <p>${post.message}</p>
    <h4>${commentCount} comments</h4> <h4>${upVoteCount} likes</h4>
     <a href="#" class="btn btn-primary"/>Fllow</a>
      <a href="<c:url value="/posts/view/${post.id}/like"/>" class="btn btn-primary" onclick="myFunction();this.onclick=null;">
  <span class="glyphicon glyphicon-thumbs-up"></span>Like</a>
  <c:set value="${post.postUsername}" var="postUsername"></c:set>
    <c:choose> 
      <c:when test="${username == postUsername}">
       <div class="Delete">
         <a href="<c:url value="/posts/view/${post.id}/delete"/>">Delete</a>
         <a href="<c:url value="/posts/view/${post.id}/edit"/>">Edit</a>
        </div>
       </c:when>
     </c:choose>
  
    <div class="well">
                    <h4><i class="fa fa-paper-plane-o"></i> Leave a Comment:</h4>
                    <form action="<c:url value="/posts/view/${post.id}/comments/create" />" method="POST" >
                       <div class="form-group">
                            <textarea class="form-control" rows="3" name="commentText"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary"><i class="fa fa-reply"></i> Submit</button>
                    </form>
       </div>  
                
             <c:forEach items="${comments}" var="comments" >
                <!-- the comments -->
                <h3><i class="fa fa-comment"></i><a href="<c:url value = "/users/profile/${comments.commentUsername}"/>"> ${comments.commentUsername}</a> says:
                </h3>
                <p>${comments.commentText}</p>
                 <a href="<c:url value="/posts/view/${post.id}/comments/${comments.id}/like"/>">
    <span class="glyphicon glyphicon-thumbs-up"></span>
    Like</a>
				 <c:set value="${comments.commentUsername}" var="commentUsername"></c:set>
               <c:choose> 
      <c:when test="${username == commentUsername}">
       <div class="Delete">
         <a href="<c:url value="/posts/view/${post.id}/comments/${comments.id}/delete" />" class="btn btn-primary">Delete</a>
        </div>
       </c:when>      
     </c:choose>
    
    </c:forEach>
                
     
 
</div>

    
<jsp:include page="footer.jsp" />
 </body>
</html>
