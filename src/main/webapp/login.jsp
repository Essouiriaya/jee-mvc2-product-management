<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Login</h2>

<form action="<%= request.getContextPath() %>/auth" method="post">
    <input type="hidden" name="action" value="login">

    Username: <input type="text" name="username"><br>
    <br>
    Password: <input type="password" name="password"><br>
    <br>
    <button type="submit">Login</button>
</form>

<% if (request.getParameter("error") != null) { %>
    <p style="color:red;">Invalid credentials</p>
<% } %>

</body>
</html>