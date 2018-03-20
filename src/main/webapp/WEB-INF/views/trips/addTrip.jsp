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
                            <h2>Dodaj wycieczkę</h2>
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
                            <form:form action="/trip/addTrip" method="post" modelAttribute="trip"
                                       class="form-horizontal form-label-left">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Data*</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="date" type="text" class="form-control has-feedback-left"
                                                    id="single_cal4" placeholder="Data" name="date"
                                                    aria-describedby="inputSuccess2Status4"/>
                                        <span class="fa fa-calendar-o form-control-feedback left"
                                              aria-hidden="true"></span>
                                        <span id="inputSuccess2Status4" class="sr-only">(success)</span>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Koszt*</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="cost" type="number" class="form-control has-feedback-left"
                                                    placeholder="Koszt"/>
                                        <span class="fa fa-money form-control-feedback left" aria-hidden="true"></span>
                                        <form:errors path="cost" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Profit*</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="profit" type="number" class="form-control has-feedback-left"
                                                    placeholder="Profit"/>
                                        <span class="fa fa-percent form-control-feedback left"
                                              aria-hidden="true"></span>
                                        <form:errors path="profit" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Organizator*</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="organisator" type="text"
                                                    class="form-control has-feedback-left"
                                                    placeholder="Organizator"/>
                                        <span class="fa fa-user-secret form-control-feedback left" aria-hidden="true"></span>
                                        <form:errors path="organisator" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Okres</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="period" type="number" class="form-control has-feedback-left"
                                                    placeholder="Okres"/>
                                        <span class="fa fa-clock-o form-control-feedback left" aria-hidden="true"></span>
                                        <form:errors path="period" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Wyżywienie</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:select path="food" class="form-control has-feedback-left">
                                            <form:option value="All inclusive" label="All inclusive"/>
                                            <form:option value="HB" label="HB"/>
                                            <form:option value="Ultra all inclusive" label="Ultra all inclusive"/>
                                            <form:option value="Brak" label="Brak"/>
                                        </form:select>
                                        <span class="fa fa-cutlery form-control-feedback left" aria-hidden="true"></span>

                                        <form:errors path="food" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Transport</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:select path="transport" class="form-control has-feedback-left">
                                            <form:option value="Samolot" label="Samolot"/>
                                            <form:option value="Autokar" label="Autokar"/>
                                            <form:option value="Dojazd własny" label="Dojazd własny"/>
                                        </form:select>
                                        <span class="fa fa-car form-control-feedback left" aria-hidden="true"></span>

                                        <form:errors path="transport" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Ilość osób*</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="persons" type="number" class="form-control has-feedback-left"
                                                    placeholder="Ilość osób"/>
                                        <span class="fa fa-user-plus form-control-feedback left" aria-hidden="true"></span>
                                        <form:errors path="persons" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Ilość dzieci</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:select path="kidsAmount" class="form-control has-feedback-left"
                                                     id="kidsAmount">
                                            <form:option value="0" label="0"/>
                                            <form:option value="1" label="1"/>
                                            <form:option value="2" label="2"/>
                                            <form:option value="3" label="3"/>
                                            <form:option value="4" label="4"/>
                                        </form:select>
                                        <span class="fa fa-user-plus form-control-feedback left" aria-hidden="true"></span>

                                        <form:errors path="kidsAmount" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback" id="kids1">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Wiek dziecka 1*</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="kidAge1" type="number"
                                                    class="form-control has-feedback-left"
                                                    placeholder="Wiek dziecka 1"/>
                                        <span class="fa fa-user-plus form-control-feedback left"
                                              aria-hidden="true"></span>
                                        <form:errors path="kidAge1" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback" id="kids2">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Wiek dziecka 2*</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="kidAge2" type="number"
                                                    class="form-control has-feedback-left"
                                                    placeholder="Wiek dziecka 2"/>
                                        <span class="fa fa-user-plus form-control-feedback left"
                                              aria-hidden="true"></span>
                                        <form:errors path="kidAge2" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback" id="kids3">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Wiek dziecka 3*</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="kidAge3" type="number"
                                                    class="form-control has-feedback-left"
                                                    placeholder="Wiek dziecka 3"/>
                                        <span class="fa fa-user-plus form-control-feedback left"
                                              aria-hidden="true"></span>
                                        <form:errors path="kidAge3" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback" id="kids4">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Wiek dziecka 4*</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:input path="kidAge4" type="number"
                                                    class="form-control has-feedback-left"
                                                    placeholder="Wiek dziecka 4"/>
                                        <span class="fa fa-user-plus form-control-feedback left"
                                              aria-hidden="true"></span>
                                        <form:errors path="kidAge4" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Klient</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:select path="client" class="form-control has-feedback-left">
                                            <form:options items="${clients}" itemValue="id"/>
                                        </form:select>
                                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>

                                        <form:errors path="client" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Miejsce</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:select path="place" class="form-control has-feedback-left">
                                            <form:options items="${places}" itemValue="id"/>
                                        </form:select>
                                        <span class="fa fa-map-marker form-control-feedback left" aria-hidden="true"></span>

                                        <form:errors path="place" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="form-group has-feedback">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Hotel</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <form:select path="hotel" class="form-control has-feedback-left">
                                            <form:options items="${hotels}" itemValue="id"/>
                                        </form:select>
                                        <span class="fa fa-fort-awesome form-control-feedback left" aria-hidden="true"></span>

                                        <form:errors path="hotel" cssClass="error"/>
                                    </div>
                                </div>

                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                        <p class="text-muted font-13 m-b-30">
                                            * - wymagane informacje
                                        </p>
                                        <a href="<c:url value='/trip/'/>" class="btn btn-danger">Cofnij</a>
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
<script type="text/javascript">
    $(document).ready(function () {
        $('#kids1').hide();
        $('#kids2').hide();
        $('#kids3').hide();
        $('#kids4').hide();
        $('#kidsAmount').on('change', function () {
            if (this.value == '0') {
                $('#kids1').hide();
                $('#kids2').hide();
                $('#kids3').hide();
                $('#kids4').hide();
            }
            if (this.value == '1') {
                $('#kids1').show();
                $('#kids2').hide();
                $('#kids3').hide();
                $('#kids4').hide();
            }
            if (this.value == '2') {
                $('#kids1').show();
                $('#kids2').show();
                $('#kids3').hide();
                $('#kids4').hide();
            }
            if (this.value == '3') {
                $('#kids1').show();
                $('#kids2').show();
                $('#kids3').show();
                $('#kids4').hide();
            }
            if (this.value == '4') {
                $('#kids1').show();
                $('#kids2').show();
                $('#kids3').show();
                $('#kids4').show();
            }
        });
    });
</script>
</body>
</html>