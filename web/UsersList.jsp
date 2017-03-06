<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<table border="1">
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${users.indexOf(user) + 1}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.status}"/></td>
        </tr>
    </c:forEach>
</table>

<br/><a href="/get?from=<c:out value="${user.login}"/>&room=<c:out value="${user.room}"/>">Go Back</a>
</body>
</html>
