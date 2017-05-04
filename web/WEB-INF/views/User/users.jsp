<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kirik
  Date: 04.05.2017
  Time: 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <th>Id</th>
    <th>FirstName</th>
    <th>Surname</th>
    <th>Patronymic</th>
    <th>Mobile Phone</th>
   <!-- <th>E-mail</th>
    <th>Password Hash</th>-->
    <th>Sex</th>
    <th>Edit</th>
    <th>Delete</th>

    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.userId}</td>
            <td>${user.firstName}</td>
            <td>${user.surname}</td>
            <td>${user.patronimyc}</td>
            <td>${user.mobilePhone}</td>
            <!--<td>${user.email}</td>
            <td>${user.passwordHash}</td>-->
            <td>${user.userSex}</td>
            <td><a href="/admin/users/edit/${user.userId}">Edit</a></td>
            <td><a href="/admin/users/delete/${user.userId}">Delete</a></td>
        </tr>
    </c:forEach>
    <td><a href="/home/admin/users/new">Add</a></td>
</table>
</body>
</html>
