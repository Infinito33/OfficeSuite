<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="<c:url value='/static/images/favicon.ico' />" type="image/ico"/>
    <title>Login page</title>
    <jsp:include page="/WEB-INF/includes/cssIncludes.jsp"/>
    <jsp:include page="/WEB-INF/includes/jsIncludes.jsp"/>
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <c:url var="loginUrl" value="/login"/>
            <section class="login_content">
                <form action="${loginUrl}" method="post">
                    <h1>Login Form</h1>
                    <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            <p>Invalid username and password.</p>
                        </div>
                    </c:if>
                    <div>
                        <input type="text" id="username" name="ssoId" class="form-control" placeholder="Username"
                               required=""/>
                    </div>
                    <div>
                        <input type="password" id="password" name="password" class="form-control" placeholder="Password"
                               required=""/>
                    </div>
                    <div class="input-group input-sm">
                        <div class="checkbox">
                            <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div>
                        <input type="submit"
                               class="btn btn-default submit" value="Log in">
                        <a class="reset_pass" href="#">Lost your password?</a>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <sec:authorize access="hasRole('ADMIN')">
                            <p class="change_link">New to site?
                                <a href="#signup" class="to_register"> Create Account </a>
                            </p>
                        </sec:authorize>
                        <div class="clearfix"></div>
                        <br/>

                        <div>
                            <h1><i class="fa fa-paw"></i> OfficeSuite</h1>
                        </div>
                    </div>
                </form>
            </section>
        </div>


    </div>
</div>

</body>
</html>