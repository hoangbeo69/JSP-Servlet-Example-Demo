<%--
  Created by IntelliJ IDEA.
  User: Smurf3r
  Date: 11/3/2020
  Time: 07:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="/common/taglib.jsp"%>
<!doctype html>
<html>
<head>
    <title>Đăng Nhập</title>
</head>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <!-- Icon -->
        <div class="fadeIn first">
            <img src="<c:url value="/images/skull.svg"/>" id="icon" alt="User Icon" />
        </div>
        <!-- Login Form -->
        <form id="login" action="<c:url value="/login"/>" method="post">
            <input type="text" required="" id="username" class="fadeIn second" name="userName" placeholder="UserName">
            <input type="text" required="" id="password" class="fadeIn third" name="passWord" placeholder="Password">
            <input type="hidden" id="action" name="action" value="login">
            <input type="submit" class="fadeIn fourth" value="Log In">
            <c:if test="${not empty message}">
                <div class="alert alert-${alert} w90">
                    <strong>Fail!</strong> ${message}
                </div>
            </c:if>
        </form>
        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="#">Forgot Password ?</a>
        </div>

    </div>
</div>
</html>
