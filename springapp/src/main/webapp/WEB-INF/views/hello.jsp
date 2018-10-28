<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title><fmt:message key="title"/></title></head>
<body>
<h1><fmt:message key="heading"/></h1>
<h3>Product List</h3>
  <c:forEach items="${model.products}" var="prodd">
    <c:out value="${prodd.name}"/>  <i>$<c:out value="${prodd.price}"/></i>  <c:out value="${prodd.tag}"/>   <a href="<c:url value="productview.htm?pid=${prodd.getId()}"/>">"${prodd.name}"</a><br>
    
  </c:forEach>
  
  <br>
  	<a href="<c:url value="/product/postProduct.htm?user=${model.user}"/>">Post Product</a>
  <br>
    <br>
  	<a href="<c:url value="deleteProduct.htm?user=${model.user}"/>">Delete Product</a>
  <br>
  
  <p><fmt:message key="greeting"/><c:out value="${model.now}"/></p>
  
  <form action="http://localhost:8080/elec5619/productlist.htm" id="test">
  		<input type="test" id="testText" name="pname" value=""/>
  		<input type="submit"  value="SearchbyKeyWord"/>
  		
  </form>
    <a href="<c:url value="/shopping/shoppingCarts.htm"/>">Shopping Carts</a>
    
</body>
</html>