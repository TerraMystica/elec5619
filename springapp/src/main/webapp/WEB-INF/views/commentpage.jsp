<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>Comment List</title>
</head>
<body>
<h1>
	Comment  
</h1>
	<form action="add" method="post">
		<ul>
			<li>
				userId: <input type="text" name="userId"/>
			</li>
			<li>
				productId: <input type="text" name="productId"/>
			</li>
			<li>
				Score: <input type="text" name="score"/>
			</li>
			<li>
				Subject: <input type="text" name="subject"/>
			</li>
			<li>
				Content: <input type="text" name="content"/>
			</li>
			<li>
				<input type="submit" name="submit"/>
			</li>
		</ul>
	</form>
</body>
</html>
