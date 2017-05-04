<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h2>Add/Edit RestroomType</h2>
<form:form method="POST" action="/manage/restroomtypes/add" modelAttribute="restroomType">
    <table>
        <c:if test="${! empty restroomType.name}">
            <tr>
                <td><label>${restroomType.restroomTypeId}</label></td>
            </tr>
        </c:if>
        <tr>
            <td><label>Restroom name</label></td>
            <td><form:input type="text" path="name"/></td>
        </tr>
        <tr>
            <td><label>Toilet type</label></td>
            <td><form:input type="text" path="toiletType"/></td>
        </tr>
        <tr>
            <td><label>Toilets count</label></td>
            <td><form:input type="text" path="toiletsCount"/></td>
        </tr>
        <tr>
            <td><label>Bathrooms count</label></td>
            <td><form:input type="text" path="bathtoomsCount"/></td>
        </tr>
        <tr>
            <td align="center"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>
</body>
</html>