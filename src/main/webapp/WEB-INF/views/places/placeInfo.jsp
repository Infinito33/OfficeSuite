<%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="UTF-8">
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
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Szczegółowe informacje o miejscu</h2>
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
                            <br/>
                            <form:form modelAttribute="place"
                                       class="form-horizontal form-label-left">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Kraj</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">${place.country}</label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Miasto</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">${place.city}</label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Wyspa</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">${place.island}</label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Informacje</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">${place.information}</label>
                                    </div>
                                </div>

                                <c:set value="${returnPath}" var="returnP"/>
                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                        <a href="<c:url value='${returnP}'/>" class="btn btn-danger">Wróć</a>
                                    </div>
                                </div>
                            </form:form>
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
</body>
</html>