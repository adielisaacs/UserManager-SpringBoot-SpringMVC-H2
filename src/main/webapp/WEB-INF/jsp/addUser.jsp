<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>
	<h3 style="color: red;">Add New User</h3>

	<form method="POST" name="newuser" action="/addNewUser" >
       <div style="width:500px;padding: 5px; "> 
       <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
       </br>
       <input name="password" type="password" class="form-control" placeholder="Password"/>
       </br>
       <input name="phone" type="text" class="form-control" placeholder="Phone"/>     
		</br>
            <button style="width:100px;height:30px;" class="btn btn-sm btn-primary btn-block" type="submit">add</button>
        </div>

    </form>
    
    </body>
</html>
