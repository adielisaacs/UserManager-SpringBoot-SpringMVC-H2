<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	
	</br></br>
	<h3>Current Session ID :</br> ${users}</h3>
	<h3 style="color: red;">Show All Users Sessions</h3>
	<table>
		<th>Username</th><th>Phone</th><th>Password</th><th>isEnabled</th>
		<c:forEach var="listValue" items="${users}">
			<tr><td>${listValue.username}</td><td>${listValue.phone}</td><td>${listValue.password}</td><td>${listValue.enabled}</td></tr>tr>
		</c:forEach>
	</table>
</body>
</html>