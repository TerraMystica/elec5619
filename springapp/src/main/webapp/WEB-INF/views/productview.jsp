<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title><fmt:message key="title"/></title></head>
<body>
<h1><fmt:message key="heading"/></h1>
<h3>Product detail</h3>
    <P>Product Name:  <c:out value="${model.product.name}"/>    <br> </P>
    <P>Product Price:  $<c:out value="${model.product.price}"/>    <br> </P>
    <P>Product Description: <c:out value="${model.product.description}"/>    <br> </P>
    <P>Product Tag:  <c:out value="${model.product.tag}"/>    <br> </P>
    <P>Product id:  <c:out value="${model.product.id}"/>    <br> </P>

  

  

</body>
</html>