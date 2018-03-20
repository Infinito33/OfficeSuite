<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="<c:url value='/static/images/favicon.ico' />" type="image/ico"/>
    <jsp:include page="/WEB-INF/includes/cssIncludes.jsp"/>
    <title>OfficeSuite</title>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">

        <jsp:include page="../const/sidenavbar.jsp"/>

        <!-- top navigation -->
        <jsp:include page="../const/topnavbar.jsp"/>
        <!-- /top navigation -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Hotele
                            <small>Lista wszystkich hoteli</small>
                        </h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search for...">
                                <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Hotele</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                           aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">Settings 1</a>
                                            </li>
                                            <li><a href="#">Settings 2</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <p class="text-muted font-13 m-b-30">
                                    Lista wszystkich dodanych hoteli.
                                </p>

                                <table id="datatable-responsive"
                                       class="table table-striped table-bordered dt-responsive nowrap"
                                       cellspacing="0" width="100%">
                                    <thead>
                                    <tr>
                                        <th>Nazwa</th>
                                        <th>Jakość</th>
                                        <th>Ocena</th>
                                        <th>Rekomendacja</th>
                                        <th>Informacje</th>
                                        <th>Kraj</th>
                                        <th>Miasto</th>
                                        <th>Wyspa</th>
                                        <th>Opcje</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${hotels}" var="hotel">
                                        <c:choose>
                                            <c:when test="${hotel.recommendation == true}">
                                                <c:set value="Tak" var="rec"></c:set>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set value="Nie" var="rec"></c:set>
                                            </c:otherwise>
                                        </c:choose>
                                        <tr>
                                            <td>${hotel.hotelName}</td>
                                            <td><input path="starsCount" name="input-16" id="input-16"
                                                       value="${hotel.starsCount}"
                                                       type="text" data-readonly="true"
                                                       class="rating rating-input"
                                                       data-min="0" data-max="5"
                                                       data-step="0.5" data-size="xs" data-show-clear="false"
                                                       data-show-caption="false"/></td>
                                            <td>${hotel.rating}</td>
                                            <td>${rec}</td>
                                            <td>${hotel.information}</td>
                                            <td>${hotel.place.country}</td>
                                            <td>${hotel.place.city}</td>
                                            <td>${hotel.place.information}</td>
                                            <td>
                                                <button class="btn btn-primary"
                                                        onclick="location.href='/hotel/info/${hotel.id}'">Szczegóły
                                                </button>
                                                <button class="btn btn-primary"
                                                        onclick="location.href='/hotel/edit/${hotel.id}'">Edytuj
                                                </button>
                                            </td>
                                            <td>
                                                <form:form action="/hotel/delete/${hotel.id}" method="post">
                                                    <input class="btn btn-danger" type="submit"
                                                           value="Usuń"/>
                                                </form:form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- footer content -->
        <jsp:include page="../const/footer.jsp"/>
        <!-- /footer content -->
    </div>
</div>
<jsp:include page="/WEB-INF/includes/jsIncludes.jsp"/>
<jsp:include page="/WEB-INF/views/notification/successNotification.jsp"/>
<script>
    $('#datatable-responsive').DataTable({
        "language": {
            "lengthMenu": "Wyświetlanie _MENU_ wpisów na stronę",
            "zeroRecords": "Nic nie znaleziono",
            "info": "Strona _PAGE_ z _PAGES_",
            "infoEmpty": "Brak dostępnych wpisów",
            "infoFiltered": "(przefiltrowano z _MAX_ wszystkich wpisów)",
            "paginate": {
                "first": "Pierwszy",
                "last": "Ostatni",
                "next": "Następny",
                "previous": "Poprzedni"
            }
        }
    });
    // https://datatables.net/reference/option/language
</script>
</body>
</html>
