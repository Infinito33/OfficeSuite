<%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                            <h2>Dodaj polisę</h2>
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
                            <form:form action="/polisazycie/addPolisazycie" method="post" modelAttribute="polisazycie"
                                       class="form-horizontal form-label-left">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Numer*</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="policyNumber" type="text"
                                                    class="form-control has-feedback-left"
                                                    placeholder="Numer polisy"/>
                                        <span class="fa fa-book form-control-feedback left"
                                              aria-hidden="true"></span>
                                        <form:errors path="policyNumber" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Klient</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:select path="client" class="form-control has-feedback-left">
                                            <form:options items="${clients}" itemValue="id"/>
                                        </form:select>
                                        <span class="fa fa-user form-control-feedback left"
                                              aria-hidden="true"></span>

                                        <form:errors path="client" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Informacje</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:textarea path="information" type="text"
                                                       class="form-control has-feedback-left"
                                                       cssStyle="min-height: 38px"
                                                       placeholder="Informacje dodatkowe"/>
                                        <span class="fa fa-info form-control-feedback left"
                                              aria-hidden="true"></span>
                                        <form:errors path="information" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                        <p class="text-muted font-13 m-b-30">
                                            * - wymagane informacje
                                        </p>
                                        <a href="<c:url value='/polisazycie/'/>" class="btn btn-danger">Cofnij</a>
                                        <button type="submit" class="btn btn-success">Zatwierdź</button>
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
<jsp:include page="/WEB-INF/views/notification/warningNotification.jsp"/>
</body>
</html>