<%--
  Created by IntelliJ IDEA.
  User: Dashutka
  Date: 27.08.2017
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<html>
<head>
    <title>Main</title>
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
                            <li><a href="#entry" id="idEntryA" style="float: right">Авторизация</a></li>
                            <li><a id="idDocsRef" href="#documents" style="display: none;">Документы</a></li>
                            <li><a id="idAdminRef" href="/admin_start" style="display: none;">Админка</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="content">
        <form id="myFormFeedback" method="POST" action="/getFeed">
            <div class="group">
                <label for="name" class="label" style="font-size: 20px;">Чувак</label>
                <input id="name" type="text" class="input" style="color: black; font-size: 20px;">
            </div>
            <div class="group">
                <label for="feedback" class="label" style="font-size: 20px;">Отзыв</label>
                <input id="feedback" type="text" class="input" style="color: black; font-size: 20px;">
            </div>
            <div class="group">
                <h4><input type="submit" class="button" style="background: transparent;"  value="оставить отзыв"></h4>
            </div>
        </form>

        <ul class="list4">
            <li><h4>${name}</h4><h5>${feedback}</h5></li>
            <li><h4>Эдгард Райт</h4><h5>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquast, qui dolorem ipsum.</h5></li>
            <li><h4>Эмилия Кларк</h4><h5>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore.</h5></li>
            <li><h4>Кевин Спейси</h4><h5>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</h5></li>
            <li><h4>Райан Рейнольдс</h4><h5>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquast, qui dolorem ipsum.</h5></li>
        </ul>
    </div>
    <div id="footer" style="width: 1100px; margin: auto">
        <div class="wrapper">
            <h4 class="fleft">Copyright (c) 2017 Minsk See Resort</h4>
        </div>
    </div>
</div>
</body>
</html>
