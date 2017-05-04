<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aliaksey
  Date: 03.05.2017
  Time: 0:37
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
    <th>Username</th>
    <th>Text</th>
    <th>Date</th>
    <th>Mark</th>
    <th>Edit</th>
    <th>Delete</th>

    <c:forEach var="review" items="${reviews}">
        <tr>
            <td>${review.reviewId}</td>
            <td>${review.user.email}</td>
            <td>${review.text}</td>
            <td>${review.date}</td>
            <td>${review.reviewMark}</td>
            <td><a href="/review/edit/${review.reviewId}">Edit</a></td>
            <td><a href="/review/delete/${review.reviewId}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/review/new">Add</a>
</body>
</html>
