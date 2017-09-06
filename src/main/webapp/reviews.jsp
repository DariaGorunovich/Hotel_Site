<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Reviews</title>
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
<div class="main">
    <jsp:include page="header.jsp" />
    <div id="content" style = "max-width: 800px; margin: 0 auto;">
        <section id=contentTestimonials class="container" style = "display: block">
            <div class="indent">
                <h2 class="indent_h2">Отзывы клиентов</h2>

                <c:if test = "${sessionScope.email != null}">
                    <form method="post" action="/reviews/add" modelAttribute="review">
                        <p><textarea rows="10" name="text" style="width: 50%; color: black;"></textarea></p>
                        <p><input class="button1 add_indent" type="submit" value="Добавь свой отзыв" style="height: 60px"/></p>
                    </form>
                </c:if>

                <ul class="list4">
                    <c:forEach items="${reviews}" var="review">
                        <li>
                            <h4>${review.userName} ${review.userSurname}</h4>
                            <h5>${review.text}</h5>
                        </li>
                    </c:forEach>
                </ul>
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
