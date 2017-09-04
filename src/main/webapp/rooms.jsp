<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Rooms</title>
    <script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/SPA_JS.js"></script>
    <script type="text/javascript" src="js/main/main.js"></script>
    <script src="js/formScript.js" type="text/javascript"></script>
    <script type="text/javascript" src=js/formScript.js></script>
    <script type="text/javascript" src="js/booking/booking.js"></script>>
    <script type="text/javascript" src="js/services/services.js"></script>
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
        <section id=contentServices class="container" style = "display: block">
            <div class="wrapper">
                <div class="content">
                    <div class="indent">
                        <h2>Мы предлагаем несколько видов комнат:</h2>
                        <div class="container" id="containerServices">
                            <c:forEach items="${rooms}" var="room">
                                <div class="room">
                                    <img src="images/2page-img11.jpg" class="extra-img png"/>
                                    <dl class="list1">
                                        <dt name="name" id="room_name">${room.name}</dt>
                                        <dd><span name="floor">${room.floor}</span>Этаж:</dd>
                                        <dd><span name="roomsCount">${room.roomType.roomsCount}</span>Количество комнат:</dd>
                                        <dd><span name="bedsCount">${room.roomType.bedsCount}</span>Количество кроватей:</dd>
                                        <dd><span name="size">${room.roomType.size}</span>Площадь:</dd>
                                        <dd class="alt"><span name="bathroomsCount">${room.roomType.bathroomsCount}</span>Ванна:</dd>
                                        <dd class="last"><span name="costPerDay">${room.roomType.costPerDay}</span>Цена за день ($):</dd>
                                    </dl>
                                    <div class="button" id="idRoom${room.id}" onclick='reservateRoom(this)'>
                                        <div class="button_opacity">
                                            <h4 class="button_opacity_h4">
                                                <a class="classReservationRoom">Забронировать сейчас!</a>
                                            </h4>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </c:forEach>

                            <div class="clear"></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </div>
</div>

</body>
</html>
