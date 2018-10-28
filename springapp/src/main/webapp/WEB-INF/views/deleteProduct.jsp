<%@ include file="/WEB-INF/views/include.jsp" %>
<html>

<head><title><fmt:message key="title"/></title></head>
<body>
<h1><fmt:message key="heading"/></h1>
<h3>My Product List</h3>
  <c:forEach items="${model.products}" var="prodd">
    <c:out value="${prodd.name}"/>  <i>$<c:out value="${prodd.price}"/></i>  <c:out value="${prodd.tag}"/>   <a href="<c:url value="/product/deleteview.htm?user=${model.user}&pid=${prodd.getId()}"/>">"${prodd.name}"</a><br>
    
  </c:forEach>
  

  

  

  
</body>
</html>