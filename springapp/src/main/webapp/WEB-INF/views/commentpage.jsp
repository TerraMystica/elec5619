<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>Comment List</title>
	<link rel="stylesheet" type="text/css" href="/elec5619/resources/css/commentpage.css">
</head>
<body>
	<div class="header">
		<div class="page-title">
			<a href="/elec5619/comment">Comment Board</a>
		</div>
	</div>
	
	<form action="add" method="post">
		<table>
			<tr>
				<td>
					<p>userId:</p>
				</td>
				<td>
					<input type="text" name="userId"/>
				</td>
			</tr>
			<tr>
				<td>
					<p>productId:</p>
				</td>
				<td>
					<input type="text" name="productId"/>
				</td>
			</tr>
			<tr>
				<td>
					<p>Score:</p>
				</td>
				<td>
					<input type="text" name="score"/>
				</td>
			</tr>
			<tr>
				<td>
					<p>Subject:</p>
				</td>
				<td>
					<input type="text" name="subject"/>
				</td>
			</tr>
			<tr>
				<td>
					<p>Content:</p>
				</td>
				<td>
					<input type="text" name="content"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" name="submit"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
