<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aliaksey
  Date: 14.03.2017
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">

    <th>FirstName</th>
    <th>Surname</th>
    <th>Patronimyc</th>
    <th>mobilePhone</th>

    <c:forEach var="user" items="${users}">
        <tr>

            <td>${user.firstName}</td>
            <td>${user.surname}</td>
            <td>${user.patronimyc}</td>
            <td>${user.mobilePhone}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
