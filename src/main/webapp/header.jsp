<%--NOT USE IN MAIN.JSP!!!!!!!!!!!!!!!!!!!!!!--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
                <div class="inner">
                    <ul class="nav">
                        <li><a href="main#contentMain" class="current" id="idConMain">Главная</a></li>
                        <li><a href="/services" id="idServicesA">Услуги</a></li>
                        <li><a href="main#contentGallery" id="idConGal">Галерея</a></li>
                        <li><a href="/reviews" id="idConTest">Отзывы</a></li>
                        <li><a id="idBookingA">Бронь</a></li>

                        <c:if test = "${sessionScope.email == null}">
                            <li><a href="main#entry" id="idEntryA">Вход</a></li>
                        </c:if>
                        <c:if test = "${sessionScope.email != null}">
                            <li><a href="/account" style="float: right">${sessionScope.login}</a></li>
                        </c:if>
                        <c:out value = "${sessionScope.role}"/>
                        <c:if test = "${sessionScope.role == 'ROLE_ADMIN'}">
                            <li><a id="idDocsRef" href="main#documents" style="">Документы</a></li>
                            <li><a id="idAdminRef" href="/admin_start" style="">Админка</a></li>
                        </c:if>
                    </ul>
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
            </div>
        </div>
    </div>
</div>
