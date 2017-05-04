<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kirik
  Date: 04.05.2017
  Time: 2:06
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
    <th>Name</th>
    <th>ToiletType</th>
    <th>ToiletsCount</th>
    <th>BathroomsCount</th>
    <th>Edit</th>
    <th>Delete</th>

    <c:forEach var="restroomType" items="${restroomTypes}">
        <tr>
            <td>${restroomType.restroomTypeId}</td>
            <td>${restroomType.name}</td>
            <td>${restroomType.toiletType}</td>
            <td>${restroomType.toiletsCount}</td>
            <td>${restroomType.bathroomsCount}</td>
            <td><a href="/manage/restroomtypes/edit/${restroomType.restroomTypeId}">Edit</a></td>
            <td><a href="/manage/restroomtypes/delete/${restroomType.restroomTypeId}">Delete</a></td>
        </tr>
    </c:forEach>
    <td><a href="/manage/restroomtypes/new">Add</a></td>
</table>
</body>
</html>
