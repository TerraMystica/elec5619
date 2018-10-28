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
	<f:form method="POST" action="register">
	AccountName:<input type="text" name="AccountName"/>
	${accountnamestatus}<br/>
	Password:<input type="password" name="Password"/>
	${passwordstatus}<br/>
	Confirm Password:<input type="password" name="ConfirmPassword"/>
	<input type="submit" value="Login"/>
		</f:form>>

</body>
</html>