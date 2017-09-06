<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Documents</title>
    <script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/SPA_JS.js"></script>
    <script type="text/javascript" src="js/main/main.js"></script>
    <script src="js/formScript.js" type="text/javascript"></script>
    <script type="text/javascript" src=js/formScript.js></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Satisfy" rel="stylesheet">
    <link rel="stylesheet" href="bootstrap/bootstrap.css">
    <link rel="stylesheet" href="css/styleSignIn.css">
    <link rel="stylesheet" href="css/gallery.css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/layout.css" rel="stylesheet" type="text/css" />
    <script src="js/maxheight.js" type="text/javascript"></script>
    <!--[if lt IE 7]>
    <link href="ie_style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="ie_png.js"></script>
    <script type="text/javascript">
        ie_png.fix('.png, #header .row-2, #header .nav li a, #content, .gallery li');
    </script>
    <![endif]-->
</head>
<body class="contentMain" onload="new ElementMaxHeight();">
<div id="main">
    <jsp:include page="header.jsp" />
    <div id="content">
        <section id=documents class="container" style="display: block">
            <div class="all_documents" style="display: block">
                <h2>Ваши документы:</h2>
                <h3><a class="docRef" href="/create_doc?docname=reservation_voucher&id=${sessionScope.id}">Электронный ваучер на проживание (PDF файл)</a></h3>
                <h3><a class="docRef" href="/create_doc?docname=reservation_confirm&id=${sessionScope.id}">Подтверждение брони (PDF файл)</a></h3>
                <h3><a class="docRef" href="/create_doc?docname=room_document&id=${sessionScope.id}">Информация о номере (PDF файл)</a><br>
                    <%--<form method="post">--%>
                        <%--<select class="select_doc_3" name="select_doc">--%>
                            <%--<optgroup label="Выберите номер: ">--%>
                                <%--<option value="Номер 1">Номер 1</option>--%>
                                <%--<option value="Номер 2">Номер 2</option>--%>
                                <%--<option value="Номер 3">Номер 3</option>--%>
                                <%--<option value="Номер 4">Номер 4</option>--%>
                                <%--<option value="Номер 5">Номер 5</option>--%>
                                <%--<option value="Номер 6">Номер 6</option>--%>
                            <%--</optgroup>--%>
                        <%--</select>--%>
                    <%--</form>--%>
                </h3>
                <h3><a class="docRef" href="/create_doc?docname=room_type_document&id=4">Информация о типе номера (PDF файл)</a><br>
                    <%--<form method="post">--%>
                        <%--<select class="select_doc_3" name="select_doc">--%>
                            <%--<optgroup label="Выберите тип номер: ">--%>
                                <%--<option value="Тип номер 1">Тип номер 1</option>--%>
                                <%--<option value="Тип номер 2">Тип номер 2</option>--%>
                                <%--<option value="Тип номер 3">Тип номер 3</option>--%>
                                <%--<option value="Тип номер 4">Тип номер 4</option>--%>
                                <%--<option value="Тип номер 5">Тип номер 5</option>--%>
                                <%--<option value="Тип номер 6">Тип номер 6</option>--%>
                            <%--</optgroup>--%>
                        <%--</select>--%>
                    <%--</form>--%>
                </h3>
                <h3><a class="docRef" href="/create_doc?docname=user_document&id=${sessionScope.id}">Информация о пользователе (PDF файл)</a></h3>
                <h3><a class="docRef" href="/create_doc?docname=room_report&type=by_month&year=2017">Отчет по комнатам по месяцам за год (XLS файл)</a><br>
                    <%--<form method="post">--%>
                        <%--<select class="select_doc_3" name="select_doc">--%>
                            <%--<optgroup label="Выберите год: ">--%>
                                <%--<option value="2016">2016 год</option>--%>
                                <%--<option value="2017">2017 год</option>--%>
                            <%--</optgroup>--%>
                        <%--</select>--%>
                    <%--</form>--%>
                </h3>
                <h3><a class="docRef" href="/create_doc?docname=room_report&type=by_quarter&year=2017">Отчет по комнатам по кварталам за год (XLS файл)</a><br>
                    <%--<form method="post">--%>
                        <%--<select class="select_doc_3" name="select_doc">--%>
                            <%--<optgroup label="Выберите год: ">--%>
                                <%--<option value="2016">2016 год</option>--%>
                                <%--<option value="2017">2017 год</option>--%>
                            <%--</optgroup>--%>
                        <%--</select>--%>
                    <%--</form>--%>
                </h3>
                <h3><a class="docRef" href="/create_doc?docname=financial_report&type=by_month&year=2017">Годовой отчет по месяцам (XLS файл)</a><br>
                    <%--<form method="post">--%>
                        <%--<select class="select_doc_3" name="select_doc">--%>
                            <%--<optgroup label="Выберите год: ">--%>
                                <%--<option value="2016">2016 год</option>--%>
                                <%--<option value="2017">2017 год</option>--%>
                            <%--</optgroup>--%>
                        <%--</select>--%>
                    <%--</form>--%>
                </h3>
                <h3><a class="docRef" href="/create_doc?docname=financial_report&type=by_quarter&year=2017">Годовой отчет по кварталам (XLS файл)</a><br>
                    <%--<form method="post">--%>
                        <%--<select class="select_doc_3" name="select_doc">--%>
                            <%--<optgroup label="Выберите год: ">--%>
                                <%--<option value="2016">2016 год</option>--%>
                                <%--<option value="2017">2017 год</option>--%>
                            <%--</optgroup>--%>
                        <%--</select>--%>
                    <%--</form>--%>
                </h3>
                <h3><a class="docRef" href="/create_doc?docname=reservation_report&id=${sessionScope.id}">10) Брони пользователя (XLS файл)</a></h3>
                <h3><a class="docRef" href="/create_doc?docname=entity_csv_report&entity=room">11) Отчет по комнатам (CSV файл)</a></h3>
                <h3><a class="docRef" href="/create_doc?docname=entity_csv_report&entity=reservation">12) Отчет по броням (CSV файл)</a></h3>
                <h3><a class="docRef" href="/create_doc?docname=entity_csv_report&entity=room_type">13) Отчет по типам комнат (CSV файл)</a></h3>
                <h3><a class="docRef" href="/create_doc?docname=entity_csv_report&entity=user">14) Отчет по пользователям (CSV файл)</a></h3>
                <h3><a class="docRef" href="/create_doc?docname=entity_csv_report&entity=role">15) Отчет по ролям (CSV файл)</a></h3>
            </div>
        </section>
    </div>
    <div id="footer" style="max-width: 1100px; margin: auto">
        <div class="wrapper">
            <h4 class="fleft">Copyright (c) 2017 Minsk See Resort</h4>
        </div>
    </div>
</div>

</body>
</html>
