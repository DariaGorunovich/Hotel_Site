<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Main</title>
    <script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/SPA_JS.js"></script>
    <script type="text/javascript" src="js/main/main.js"></script>
    <script src="js/formScript.js" type="text/javascript"></script>
    <script type="text/javascript" src=js/formScript.js></script>
    <meta name='viewport', content='width=device-width, initial-scale=1'/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta name='viewport', content='width=device-width, initial-scale=1'/>
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
    <!— header —>
    <div id="header">
        <div class="row-1">
            <div class="wrapper">
                <div class="logo">
                    <p class="p_header_icon"><img class="header_icon" src="images/header_icon.png" alt=""/></p>
                    <h1 class="hotel_name"><a href="main.jsp">Minsk See Resort</a></h1>
                    <h1 class="hotel_slogan">Make your dreams come true!</h1>
                </div>
            </div>
        </div>
        <div class="row-2">
            <div class="indent">
                <!— header-box begin —>
                <div class="header-box">
                    <div class="inner">
                        <ul class="nav">
                            <li><a href="#contentMain" class="current" id="idConMain">Главная</a></li>
                            <li><a href="#contentServices" id="idServicesA">Услуги</a></li>
                            <li><a href="#contentGallery" id="idConGal">Галерея</a></li>
                            <li><a href="#contentTestimonials" id="idConTest">Отзывы</a></li>
                            <li><a id="idBookingA">Бронь</a></li>

                            <c:if test = "${sessionScope.email == null}">
                                <li><a href="#entry" id="idEntryA">Вход</a></li>
                            </c:if>
                            <c:if test = "${sessionScope.email != null}">
                                <li><a href="/account" style="float: right">${sessionScope.login}</a></li>
                            </c:if>
                            <c:out value = "${sessionScope.role}"/>
                            <c:if test = "${sessionScope.role == 'ROLE_ADMIN'}">
                                <li><a id="idDocsRef" href="#documents" style="">Документы</a></li>
                                <li><a id="idAdminRef" href="/admin_start" style="">Админка</a></li>
                            </c:if>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="content">
        
        <section id=contentMain class="container" src="/templates/pages/main/contentMain.html"></section>
        <section id=contentBooking class="container" src="/templates/pages/booking/contentBooking.html"></section>
        <section id=contentGallery class="container" src="/templates/pages/gallery/contentGallery.html"></section>
        <section id=contentServices class="container" src="/templates/pages/services/contentServices.html"></section>
        <section id=entry class="container" src="/templates/pages/signin/entry.html"></section>

        <section id=contentTestimonials class="container" src="/templates/pages/testimonials/contentTestimonials.html"></section>
        <section id=documents class="container" src="/templates/pages/documents/documents.html"></section>
    </div>
    <div id="footer" style="max-width: 1100px; margin: auto">
        <div class="wrapper">
            <h4 class="fleft">Copyright (c) 2017 Minsk See Resort</h4>
        </div>
    </div>
</div>
</body>
</html>