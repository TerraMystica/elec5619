<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title><fmt:message key="title"/></title></head>
<body>
<h1><fmt:message key="heading"/></h1>
<h3>Search Result by "${model.pname}"</h3>
  <c:forEach items="${model.products}" var="prodd">
    <c:out value="${prodd.name}"/>  <i>$<c:out value="${prodd.price}"/></i>  <c:out value="${prodd.tag}"/>   <a href="<c:url value="productview.htm?pid=${prodd.id}"/>">"${prodd.name}"</a><br>
    
  </c:forEach>
  

  
  <p><fmt:message key="greeting"/><c:out value="${model.now}"/></p>
  
  
</body>
</html>