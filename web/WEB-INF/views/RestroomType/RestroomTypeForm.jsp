<%@ page import="com.aliaksey.entity.ToiletType" %>
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
<c:set var="toiletTypeValues" value="<%=ToiletType.values()%>"/>
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
            <td><form:errors path="name" /></td>
        </tr>
        <tr>
            <td><label>Toilet type</label></td>
            <td>
                <form:select name="toiletType" path="toiletType">
                    <c:forEach items="${toiletTypeValues}" var="toiletTypeValues">
                        <option value="${toiletTypeValues}" ${restroomType.toiletType == toiletTypeValues ? 'selected' : ''}>${toiletTypeValues.name()}</option>
                    </c:forEach>
                </form:select>
            </td>
            <%--<td><form:input type="text" path="toiletType"/></td>--%>
            <td><form:errors path="toiletType" /></td>
        </tr>
        <tr>
            <td><label>Toilets count</label></td>
            <td><form:input type="text" path="toiletsCount"/></td>
            <td><form:errors path="toiletsCount" /></td>
        </tr>
        <tr>
            <td><label>Bathrooms count</label></td>
            <td><form:input type="text" path="bathroomsCount"/></td>
            <td><form:errors path="bathroomsCount" /></td>
        </tr>
        <tr>
            <td align="center"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>

<td><a href="/manage/restroomtypes">Back</a></td>
</body>
</html>
