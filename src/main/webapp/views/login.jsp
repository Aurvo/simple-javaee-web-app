<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Log In</title>
</head>

<style>
label {
	display: inline-block;
	width: 75px;
}
</style>

<body>
	<div style="display: ${warningDisp}; background-color: #ffcccc; color: #ff0000;">Your username or password is incorrect.</div>
	<form action="/login" method="POST">
		<div><label>Username:</label> <input type="text" name="username"/></div>
		<div><label>Password:</label> <input type="password" name="password"/></div>
		<button type="submit">Log In</button>
	</form>
	<p>Go to src/main/webApp/data/users.json to see what credentials are correct.</p>
</body>
</html>