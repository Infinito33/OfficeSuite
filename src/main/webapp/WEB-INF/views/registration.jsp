<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="<c:url value='/static/images/favicon.ico' />" type="image/ico"/>
    <title>Registration page</title>
    <jsp:include page="/WEB-INF/includes/cssIncludes.jsp"/>
    <jsp:include page="/WEB-INF/includes/jsIncludes.jsp"/>
</head>

<body class="login">
<div class="login_wrapper">
    <div class="animate form login_form">
        <section class="login_content">
            <form:form method="POST" modelAttribute="user" action="/newuser">
                <form:input type="hidden" path="id" id="id"/>
                <h1>Create Account</h1>
                <div>
                    <form:input type="text" path="firstName" id="firstName" class="form-control"
                                placeholder="Imię"/>
                    <div class="has-error">
                        <form:errors path="firstName" class="help-inline"/>
                    </div>
                </div>

                <div>
                    <form:input type="text" path="lastName" id="lastName" class="form-control"
                                placeholder="Nazwisko"/>
                    <div class="has-error">
                        <form:errors path="lastName" class="help-inline"/>
                    </div>
                </div>

                <div>
                    <c:choose>
                        <c:when test="${edit}">
                            <form:input type="text" path="ssoId" id="ssoId" class="form-control" disabled="true"
                                        placeholder="SSO"/>
                        </c:when>
                        <c:otherwise>
                            <form:input type="text" path="ssoId" id="ssoId" class="form-control" placeholder="Login"/>
                            <div class="has-error">
                                <form:errors path="ssoId" class="help-inline"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div>
                    <form:input type="text" path="email" id="email" class="form-control" placeholder="Email"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>

                <div>
                    <form:input type="password" path="password" id="password" class="form-control"
                                placeholder="Hasło"/>
                    <div class="has-error">
                        <form:errors path="password" class="help-inline"/>
                    </div>
                </div>

                <div>
                    <form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id"
                                 itemLabel="type" class="form-control"/>
                    <div class="has-error">
                        <form:errors path="userProfiles" class="help-inline"/>
                    </div>
                </div>

                <div>
                    <br/>
                    <input type="submit" class="btn btn-default submit" value="Register"/>
                </div>

                <div class="clearfix"></div>

                <div class="separator">
                    <div class="clearfix"></div>
                    <br/>
                    <div>
                        <h1><i class="fa fa-paw"></i> OfficeSuite</h1>
                    </div>
                </div>
            </form:form>
        </section>
    </div>


    <%--<%@include file="authheader.jsp" %>--%>

    <%--<div class="well lead">User Registration Form</div>--%>
    <%--<form:form method="POST" modelAttribute="user" class="form-horizontal">--%>
    <%--<form:input type="hidden" path="id" id="id"/>--%>

    <%--<div class="row">--%>
    <%--<div class="form-group col-md-12">--%>
    <%--<label class="col-md-3 control-lable" for="firstName">First Name</label>--%>
    <%--<div class="col-md-7">--%>
    <%--<form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>--%>
    <%--<div class="has-error">--%>
    <%--<form:errors path="firstName" class="help-inline"/>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
    <%--<div class="form-group col-md-12">--%>
    <%--<label class="col-md-3 control-lable" for="lastName">Last Name</label>--%>
    <%--<div class="col-md-7">--%>
    <%--<form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />--%>
    <%--<div class="has-error">--%>
    <%--<form:errors path="lastName" class="help-inline"/>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
    <%--<div class="form-group col-md-12">--%>
    <%--<label class="col-md-3 control-lable" for="ssoId">SSO ID</label>--%>
    <%--<div class="col-md-7">--%>
    <%--<c:choose>--%>
    <%--<c:when test="${edit}">--%>
    <%--<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" disabled="true"/>--%>
    <%--</c:when>--%>
    <%--<c:otherwise>--%>
    <%--<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" />--%>
    <%--<div class="has-error">--%>
    <%--<form:errors path="ssoId" class="help-inline"/>--%>
    <%--</div>--%>
    <%--</c:otherwise>--%>
    <%--</c:choose>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
    <%--<div class="form-group col-md-12">--%>
    <%--<label class="col-md-3 control-lable" for="password">Password</label>--%>
    <%--<div class="col-md-7">--%>
    <%--<form:input type="password" path="password" id="password" class="form-control input-sm" />--%>
    <%--<div class="has-error">--%>
    <%--<form:errors path="password" class="help-inline"/>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
    <%--<div class="form-group col-md-12">--%>
    <%--<label class="col-md-3 control-lable" for="email">Email</label>--%>
    <%--<div class="col-md-7">--%>
    <%--<form:input type="text" path="email" id="email" class="form-control input-sm" />--%>
    <%--<div class="has-error">--%>
    <%--<form:errors path="email" class="help-inline"/>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
    <%--<div class="form-group col-md-12">--%>
    <%--<label class="col-md-3 control-lable" for="userProfiles">Roles</label>--%>
    <%--<div class="col-md-7">--%>
    <%--<form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />--%>
    <%--<div class="has-error">--%>
    <%--<form:errors path="userProfiles" class="help-inline"/>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
    <%--<div class="form-actions floatRight">--%>
    <%--<c:choose>--%>
    <%--<c:when test="${edit}">--%>
    <%--<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>--%>
    <%--</c:when>--%>
    <%--<c:otherwise>--%>
    <%--<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>--%>
    <%--</c:otherwise>--%>
    <%--</c:choose>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</form:form>--%>
</div>
</body>
</html>