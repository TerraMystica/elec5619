<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head><title><fmt:message key="title"/></title></head>
<body>

<h1><fmt:message key="heading"/></h1>
<h3>Product List</h3>
  <c:forEach items="${model.products}" var="prodd">
    <c:out value="${prodd.name}"/> 
    <i>$<c:out value="${prodd.price}"/></i>  
    <c:out value="${prodd.tag}"/>   
    <a href="<c:url value="productview.htm?pid=${prodd.getId()}"/>">"${prodd.name}"</a>
    
    
    
    <f:form method="POST" action="shopping/addShoppingCart.htm">
	    <input type="hidden" name="user" value="${model.user}"/>
	    <input type="hidden" name="pid" value="${prodd.id}"/>
	    <input type="hidden" name="name" value="${prodd.name}"/>
	    <input type="hidden" name="price" value="${prodd.price}"/>
		<input type="submit" value="Add to Shopping Cart"/>
	</f:form>

    <br/>
  </c:forEach>
  
  
	
	
  
  <br>
  	<a href="<c:url value="/product/postProduct.htm?user=${model.user}"/>">Post Product</a>
  <br>
    <br>
  	<a href="<c:url value="deleteProduct.htm?user=${model.user}"/>">Delete Product</a>
  <br>
   <br>
  <a href="<c:url value="/shopping/shoppingCarts.htm?user=${model.user}"/>">Shopping Carts</a>
  <br>
  
  <p><fmt:message key="greeting"/><c:out value="${model.now}"/></p>
  
  <form action="http://localhost:8080/elec5619/productlist.htm" id="test">
  		<input type="text" id="testText" name="pname" value=""/>
  		<input type="submit"  value="SearchbyKeyWord"/>
  </form>
    
    
</body>
</html>