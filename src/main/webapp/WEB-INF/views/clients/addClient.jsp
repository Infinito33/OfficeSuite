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
                            <h2>Dodaj klienta</h2>
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
                            <form:form action="/client/addClient" method="post" modelAttribute="client"
                                       class="form-horizontal form-label-left">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Imię*</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="name" type="text" class="form-control has-feedback-left"
                                                    placeholder="Imię"/>
                                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>

                                        <form:errors path="name" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Nazwisko*</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="lastname" type="text" class="form-control has-feedback-left"
                                                    placeholder="Nazwisko"/>
                                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                        <form:errors path="lastname" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Email</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="email" type="text" class="form-control has-feedback-left"
                                                    placeholder="Email"/>
                                        <span class="fa fa-envelope form-control-feedback left"
                                              aria-hidden="true"></span>
                                        <form:errors path="email" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Płeć</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:select path="sex" class="form-control has-feedback-left">
                                            <form:option value="0" label="Mężczyzna"/>
                                            <form:option value="1" label="Kobieta"/>
                                        </form:select>
                                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>

                                        <form:errors path="sex" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Data urodzenia</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="birthDate" type="text" class="form-control has-feedback-left"
                                                    id="single_cal4" placeholder="Data urodzenia" name="birthDate"
                                                    aria-describedby="inputSuccess2Status4"/>
                                        <span class="fa fa-calendar-o form-control-feedback left"
                                              aria-hidden="true"></span>
                                        <span id="inputSuccess2Status4" class="sr-only">(success)</span>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Telefon</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="phone" type="number" class="form-control has-feedback-left"
                                                    placeholder="Telefon"/>
                                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
                                        <form:errors path="phone" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Adres domowy</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="addrHome" type="text" class="form-control has-feedback-left"
                                                    placeholder="Adres domowy"/>
                                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                        <form:errors path="addrHome" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Adres pocztowy</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="addrPostal" type="text" class="form-control has-feedback-left"
                                                    placeholder="Adres pocztowy"/>
                                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                        <form:errors path="addrPostal" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Firma</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="company" type="text" class="form-control has-feedback-left"
                                                    placeholder="Firma"/>
                                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                        <form:errors path="company" cssClass="error"/>
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
                                        <a href="<c:url value='/client/'/>" class="btn btn-danger">Cofnij</a>
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