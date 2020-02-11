<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>

	    <h3 style="color: red;text-align:right;">
	            Hello ${user.username} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
	    </h3>
    <form id="logoutForm" method="POST" action="/logout">
    </form>

</div>