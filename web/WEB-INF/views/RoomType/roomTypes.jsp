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
    <th>Name</th>
    <th>Blocks count</th>
    <th>Beds count</th>
    <th>Cost per day</th>
    <th>Additional inf</th>
    <th>Edit</th>
    <th>Delete</th>

    <c:forEach var="roomType" items="${roomTypes}">
        <tr>
            <td>${roomType.roomTypeId}</td>
            <td>${roomType.roomName}</td>
            <td>${roomType.blocksCount}</td>
            <td>${roomType.bedsCount}</td>
            <td>${roomType.costPerDay}</td>
            <td>${roomType.additionalInformation}</td>
            <td><a href="/manage/roomtypes/edit/${roomType.roomTypeId}">Edit</a></td>
            <td><a href="/manage/roomtypes/delete/${roomType.roomTypeId}">Delete</a></td>
        </tr>
    </c:forEach>

    <td><a href="/manage/roomtypes/new">Add</a></td>
</table>
</body>
</html>
