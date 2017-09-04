<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Admin</title>
    <script>
        <%@include file ="/js/jquery-3.2.0.min.js"%>
        <%--<%@include file="/js/adminJS.js"%>--%>
        <%@include file="/js/bootstrap.min.js"%>
    </script>
    <style>
        <%@include file="/bootstrap/bootstrap.min.css"%>
        <%@include file="/css/admin.css"%>
    </style>
    <script type="text/javascript">
        function Click() {
            document.getElementById("idHrefAdmin").click();
        }
    </script>
</head>
    <body>
        <div class="container" style="padding-left: 30px;margin-left: 0px;width: 100%">
            <div class="row" style="width: 100%;position: relative">
                <div class="container_header">
                    <div class="container_header_box">
                        <h3 style="padding-right: 30px;">Таблицы базы данных:</h3>
                    </div>
                </div>
                <div class="col-lg-3">
                    <table class="table table-hover table-bordered">
                        <tbody>
                            <c:forEach var="item" items="${names}">
                                <c:if test = "${item != 'reservation_room'}">
                                    <tr><td><input type="text" style="width: 100%" disabled="disabled" value="${item}" class="head"/></td></tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br>
                    <button type="button" style="width: 100%" onclick="Click()" class="btn btn-primary">Вернуться на сайт
                        <a id="idHrefAdmin" href="main.jsp"></a>
                    </button>
                </div>
                <div class="table_header">
                    <h3>Существующие записи:</h3>
                </div>
                <div class="col-lg-12">
                    <table class="table table-bordered table-hover" id="tableHotel" style="border-right: none; border-bottom: none">
                    </table>
                </div>
            </div>
        </div>
        <div id="myModalUpdate" class="modal fade"></div>
        <div id="myModalAdd" class="modal fade"></div>
        <div id="modalWindow"></div>
    </body>
<script type="text/javascript" src="js/adminJS.js"></script>
</html>
