<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head><title><fmt:message key="title"/></title></head>
<body>
<h1><fmt:message key="heading"/></h1>


  <c:forEach items="${model.shoppingcarts}" var="scarts">
  
  	<f:form method="POST" action="updateShoppingCart">
  		<input type="hidden" name="id" value="${scarts.id}"/>
	    <c:out value="${scarts.productId}"/> 
	    <input type="hidden" name="pid" value="${scarts.productId}"/>
	     <input type="hidden" name="user" value="${scarts.userId}"/>
	    <c:out value="${scarts.name}"/> 
	     <input type="hidden" name="name" value="${scarts.name}"/>
	    <input type="text" name="count" value="${scarts.counts}" /> 
	    <c:out value="${scarts.price}"/>  
	     <input type="hidden" name="price" value="${scarts.price}"/>
	    <i>$<c:out value="${scarts.shippingFee}"/></i>
	     <input type="hidden" name="shippingFee" value="${scarts.shippingFee}"/>
	    <input type="submit" value="Update">
    </f:form>
    
    <a href="<c:url value="/shopping/deleteShoppingCart.htm?id=${scarts.id}"/>">Delete</a>
    
    
    <br>
    
  </c:forEach>
  
  <br/><br/>
  <a href="<c:url value="/order/addOrderRecord.htm?user=${model.user}"/>">Check out</a>
    
 
  
  
  <!-- test github -->

  
  <p><fmt:message key="greeting"/><c:out value="${model.now}"/></p>
  
  
</body>
</html>