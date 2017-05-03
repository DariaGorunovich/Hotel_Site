<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Aliaksey
  Date: 03.05.2017
  Time: 2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Add/Edit RoomType</h2>
<form:form method="POST" action="/manage/roomTypes/add" modelAttribute="roomType" >
    <table>
        <%--<form:input type="text" path="roomTypeId" value="${roomType.roomTypeId}"/>--%>
        <%--${roomType.roomTypeId}--%>
        <%--<tr>--%>
            <td><label oncontextmenu="return false">Id</label></td>
            <td><label>${roomType.roomTypeId}</label></td>
        </tr>
        <tr>
            <td><label>RoomType name</label></td>
            <td><form:input type="text" path="roomName"/></td>
        </tr>
        <tr>
            <td><label>Blocks count</label></td>
            <td><form:input type="text" path="blocksCount"/></td>
        </tr>
        <tr>
            <td><label>Beds count</label></td>
            <td><form:input type="text" path="bedsCount"/></td>
        </tr>
        <tr>
            <td><label>Cost per day</label></td>
            <td><form:input type="text" path="costPerDay"/></td>
        </tr>
        <tr>
            <td><label>Additional Inf</label></td>
            <td><form:input type="text" path="additionalInformation"/></td>
        </tr>

        <tr>
            <td align="center"><input type="submit" value="Save"></td>
        </tr>
    </table>

</form:form>
</body>
</html>
