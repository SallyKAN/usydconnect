<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<c:forEach items="${posts}" var="posts" >
   <div class="posts">
    <h3><a href="<c:url value="/posts/view/${posts.id}"/>">${posts.title}</a> </h3>
    <p>${posts.postUsername}</p>  
  </div>
</c:forEach>