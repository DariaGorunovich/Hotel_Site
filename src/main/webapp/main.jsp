<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <div class="menu-btn" id="menu-btn" onclick="">
                        <div></div>
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                    <div class="inner" id="inner">
                        <ul class="nav" id="nav">
                            <li><a href="#contentMain" class="current" id="idConMain">Главная</a></li>
                            <li><a href="#contentServices" id="idServicesA" onclick="noneMenu('nav')">Услуги</a></li>
                            <li><a href="#contentGallery" id="idConGal" onclick="noneMenu('nav')">Галерея</a></li>
                            <li><a href="#contentTestimonials" id="idConTest" onclick="noneMenu('nav')">Отзывы</a></li>
                            <li><a href="#entry" id="idEntryA" style="float: right" onclick="noneMenu('nav')">Авторизация</a></li>
                            <li><a id="idDocsRef" href="#documents" style="display: none;" onclick="noneMenu('nav')">Документы</a></li>
                            <li><a id="idAdminRef" href="/admin_start" style="display: none;" onclick="noneMenu('nav')">Админка</a></li>
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
<script type="text/javascript">
    jQuery(function($){
        $( '.menu-btn' ).click(function(){
            $('.nav').toggleClass('expand')
            $('.menu-btn').addClass('btn-none')
        })

        $( '.inner' ).click(function(){
            $('.nav').removeClass('expand')
            $('.menu-btn').removeClass('btn-none')
        })
    })
</script>
</body>
</html>