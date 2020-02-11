<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Session Details</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>

<div class="container">
      <h3 style="color: red;">Show Session Data</h3>
      </br>
      <form id="refresh" method="POST" action="/welcome">
       <button style="width:80px;height:30px;" class="btn btn-sm btn-primary btn-block" type="submit">Refresh</button>
      </form>
	<table style="width: 700px;">
		<th>Key</th><th>Value</th>
		<c:forEach var="sessionValue" items="${sessiontracker}">
			<tr style="padding: 10px; margin-bottom: 20px;border-bottom: 1px solid #ccc;">
			<td>${sessionValue.user}</td><td>${sessionValue.token}</td>
			</tr>
		</c:forEach>
		<tr style="padding: 10px; margin-bottom: 20px;border-bottom: 1px solid #ccc;">
			<td><b>Amount of Valid Users</b></td><td>${sumValidSessions}</td>
			</tr>
	</table>  

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script></body>
</html>
