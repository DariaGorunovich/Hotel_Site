<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
</head>
<body>
<h2>Add/Edit RoomType</h2>
<form:form method="POST" action="/review//edit/${review.reviewId}" modelAttribute="review" >
    <table>

        <c:if test="${! empty review.text}">
            <tr>
                <td><label>${review.reviewId}</label></td>
            </tr>
        </c:if>
        <tr>
            <td><label>UserName</label></td>
            <td><label>${review.user.email}</label></td>
        </tr>
        <tr>
            <td><label>Text</label></td>
            <td><form:input type="text" path="text"/></td>
            <td><form:errors path="text" /></td>
        </tr>
        <tr>
            <td><label>Date</label></td>
            <td><form:input type="text" path="date"/></td>
            <td><form:errors path="date" /></td>
        </tr>
        <tr>
            <td><label>Mark</label></td>
            <td><form:input type="text" path="reviewMark"/></td>
            <td><form:errors path="reviewMark" /></td>
        </tr>

        <tr>
            <td align="center"><input type="submit" value="Save"></td>
        </tr>
    </table>

</form:form>
</body>
</html>
