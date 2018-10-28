<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title><fmt:message key="title"/></title></head>
<body>
<h1><fmt:message key="heading"/></h1>


  <c:forEach items="${model.shoppingcarts}" var="scarts">
    <c:out value="${scarts.productId}"/> 
    <c:out value="${scarts.name}"/>  
    <c:out value="${scarts.counts}"/> 
    <c:out value="${scarts.price}"/>  
    <i>$<c:out value="${scarts.shippingFee}"/></i>
    <a href="<c:url value="/shopping/deleteShoppingCart.htm?id=${scarts.id}"/>">Delete</a>
    <br>
    
  </c:forEach>
  
  <br/><br/>
  

  
  <p><fmt:message key="greeting"/><c:out value="${model.now}"/></p>
  
  
</body>
</html>