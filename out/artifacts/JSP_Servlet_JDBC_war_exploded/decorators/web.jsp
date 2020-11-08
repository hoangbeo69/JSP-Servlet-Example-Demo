<%--
  Created by IntelliJ IDEA.
  User: Smurf3r
  Date: 9/2/2020
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="en">
<head>
    <%--    nếu trang nào không định nghĩa title thì lấy tên là trang chủ--%>
    <title><dec:title default="Trang Chủ"/></title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="<c:url value="/template/web/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value="/template/web/css/style.css" />" rel="stylesheet">
</head>
<body>
    <%--    header--%>
    <%@include file="/common/web/header.jsp"%>
    <%--    header--%>

    <div class="container">
        <dec:body/>
    </div>

    <%--    footer--%>
    <%@include file="/common/web/footer.jsp"%>
    <%--    footer--%>

    <!-- Bootstrap core JavaScript -->
    <script src = "<c:url value="/template/web/jquery/jquery.min.js"/>"></script>
    <script src = "<c:url value="/template/web/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>