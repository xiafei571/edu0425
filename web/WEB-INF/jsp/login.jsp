<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
    href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
<meta charset="UTF-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login</title>
</head>
<body>
    <div class="container">
        <form:form method="post" id="login_form" modelAttribute="user"
            action="/edu0425/login">

            <div class="form-group row">
                <img class="mb-4"
                    src="${pageContext.request.contextPath}/img/logo-spongebob.png" alt=""
                    width="72" height="72">
            </div>
            <h3 class="h3 mb-3 font-weight-normal">
                Please sign in
                </h1>
                <h4 class="h3 mb-3 font-weight-normal">${msg}</h2>
                    <div class="form-group row">
                        <label for="loginId" class="col-sm-2 col-form-label">LoginId</label>
                        <div class="col-sm-4">
                            <form:input type="text" id="loginId" path="loginId"
                                class="form-control" placeholder="LoginId" required=""
                                autofocus="" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
                        <div class="col-sm-4">
                            <form:input type="password" id="inputPassword" path="password"
                                class="form-control" placeholder="Password" required="" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="checkbox mb-3">
                            <label> <form:checkbox path="remember"
                                    value="remember-me" /> Remember me
                            </label>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <button type="submit" class="btn btn-primary">Sign in</button>
                        </div>
                    </div>
                    <p class="mt-5 mb-3 text-muted">© 2019-2020</p>
        </form:form>
    </div>



    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script
        src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script
        src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>