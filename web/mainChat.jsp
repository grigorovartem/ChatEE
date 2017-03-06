<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Chat</title>
</head>
<body>
<form action="/get" method="get">
    <input type="submit" value="Receive"><br><br><br>
    <input type="hidden" name="from" value="<c:out value="${user.login}"/>">
    <input type="hidden" name="room" value="<c:out value="${currentRoom}"/>">
    <c:forEach items="${msg}" var="m">
        <c:if test="${(empty m.to) || (m.to eq user.login) || (m.from eq user.login)}">
            <c:if test="${currentRoom eq m.room}">
                <h4>[<c:out value="${m.from}"/>] :
                    to : [<c:out value="${m.to}"/>]
                    <c:out value="${m.text}"/></h4>
            </c:if>
        </c:if>

    </c:forEach>
</form>

<a href="/list?from=<c:out value="${user.login}"/>">AllUsers</a><br><br>

<c:if test="${empty currentRoom}">
    <table border="1">
        <c:forEach items="${rooms}" var="room">
            <tr>
                <td><a href="/get?from=<c:out value="${user.login}"/>&room=<c:out value="${rooms.indexOf(room)}"/>">
                    Go to room <c:out value="${rooms.indexOf(room) + 1}"/>
                </a></td>
            </tr>
        </c:forEach>
    </table>

    <form action="/room?from=<c:out value="${user.login}"/>" method="get">
        <input type="submit" value="Create new room"><br><br><br>
        <input type="hidden" name="room" value="<c:out value="${rooms.size() + 0}"/>">
        <input type="hidden" name="from" value="<c:out value="${user.login}"/>">
    </form>
</c:if>

<form action="/add" method="post">
    To : <input type="text" name="toUser"><br><br>
    Message : <input type="text" name="message">
    <input type="submit" value="Send"><br><br><br>
    <input type="hidden" name="from" value="<c:out value="${user.login}"/>">
    <input type="hidden" name="room" value="<c:out value="${currentRoom}"/>">
</form>

<c:if test="${not empty currentRoom}">
    <a href="/get?from=<c:out value="${user.login}"/>&room=">Back to main chat</a><br>
</c:if>
<a href="/logout?from=<c:out value="${user.login}"/>">Log out</a>

</body>
</html>
