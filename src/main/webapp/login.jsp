<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Login</title>
</head>

<body>

<h2>Login</h2>

<%
String error = request.getParameter("error");
if(error != null){
%>

<p style="color:red">Invalid username or password</p>

<%
}
%>

<form action="login" method="post">

Username :
<input type="text" name="username" required>

<br><br>

Password :
<input type="password" name="password" required>

<br><br>

<input type="submit" value="Login">

</form>

</body>
</html>