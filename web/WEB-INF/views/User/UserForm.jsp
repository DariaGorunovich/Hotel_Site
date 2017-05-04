<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h2>Add/Edit User</h2>
<form:form method="POST" action="/admin/users/add" modelAttribute="user">
    <table>
        <c:if test="${! empty user.firstName}">
            <tr>
                <td><label>${user.userId}</label></td>
            </tr>
        </c:if>
        <tr>
            <td><label>User name</label></td>
            <td><form:input type="text" path="firstName"/></td>
        </tr>
        <tr>
            <td><label>Surname</label></td>
            <td><form:input type="text" path="surname"/></td>
        </tr>
        <tr>
            <td><label>Patronymic</label></td>
            <td><form:input type="text" path="patronimyc"/></td>
        </tr>
        <tr>
            <td><label>Mobile Phone</label></td>
            <td><form:input type="text" path="mobilePhone"/></td>
        </tr>
        <!--<tr>
            <td><label>E-mail</label></td>
            <td><form:input type="text" path="email"/></td>
        </tr>
        <tr>
            <td><label>Password Hash</label></td>
            <td><form:input type="text" path="passwordHash"/></td>
        </tr>-->
        <tr>
            <td><label>Sex</label></td>
            <td><form:input type="text" path="userSex"/></td>
        </tr>
        <tr>
            <td align="center"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
