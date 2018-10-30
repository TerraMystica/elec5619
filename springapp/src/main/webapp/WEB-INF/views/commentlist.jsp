<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Comment List</title>
</head>
<body>
<h1>
	<a href="/elec5619/comment">Comments</a>  
</h1>
	<table border="1">
		<tr>
			<td>User Id</td>
			<td>Product Id</td>
			<td>Time</td>
			<td>Score</td>
			<td>Subject</td>
			<td>Content</td>
			<td>Operation</td>
		</tr>
		<c:forEach items="${model.comments}" var="prodd">
			<tr>
				<td>
					<a href="/elec5619/comment/getcommentsbyuser?userId=<c:out value="${prodd.userId}" />">
						<c:out value="${prodd.userId}" />
					</a>
				</td>
				<td>
					<a href="/elec5619/comment/getcommentsbyproduct?productId=<c:out value="${prodd.productId}" />">
						<c:out value="${prodd.productId}" />
					</a>
				</td>
				<td><c:out value="${prodd.time}" /></td>
				<td><c:out value="${prodd.score}" /></td>
				<td><c:out value="${prodd.subject}" /></td>
				<td><c:out value="${prodd.content}" /></td>
				<td>
					<a href="/elec5619/comment/delete?id=<c:out value="${prodd.id}" />">delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/elec5619/comment/commentpage">Add</a>
</body>
</html>
