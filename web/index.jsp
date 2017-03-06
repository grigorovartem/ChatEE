<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat</title>
</head>
<body>
<form action="/auth" method="post">
    Login : <input type="text" name="login"><br><br>
    Password : <input type="text" name="password"><br><br>
    <input type="radio" name="authorisation" value="auth">Authorisation
    <input type="radio" name="authorisation" value="reg">Registration
    <input type="submit" name="login" value="Send">
</form>

</body>
</html>
