<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>
	<title>${message}</title>
</head>
<body>
	<h1>
	${message} 
	</h1>
	<f:form method="POST" action="login">
	AccountName:<input type="text" name="AccountName"/>
	Password:<input type="password" name="Password"/>
	<input type="submit" value="Login"/>
		</f:form>>

</body>
</html>