<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<%
String id = request.getParameter("pid");  
%>
<%
String user = request.getParameter("user");  
%>
<head><title><fmt:message key="title"/></title></head>
<body>
<h1><fmt:message key="heading"/></h1>
<h3>Product detail</h3>
    <P>Product Name:  <c:out value="${model.product.name}"/>    <br> </P>
    <P>Product Price:  $<c:out value="${model.product.price}"/>    <br> </P>
    <P>Product Description: <c:out value="${model.product.description}"/>    <br> </P>
    <P>Product Tag:  <c:out value="${model.product.tag}"/>    <br> </P>
    <P>Product id:  <c:out value="${model.product.id}"/>    <br> </P>
    <P>User id:  <c:out value="${model.product.user}"/>    <br> </P>

	<f:form  method="POST" action="deleteview">
   <input type="hidden" name="pid" value=<%=id%>>
    <input type="hidden" name="user" value=<%=user%>>
	<input type="submit" value="delete"/>
</f:form>

  

</body>
</html>