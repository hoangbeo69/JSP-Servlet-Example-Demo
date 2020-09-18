<%--
  Created by IntelliJ IDEA.
  User: Smurf3r
  Date: 9/18/2020
  Time: 06:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>

<head>
    <title>Danh Sách Bài Viết</title>
</head>

<body>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Tên Bài Viết</th>
                                        <th>Mô Tả Ngắn</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${model.listResult}" >
                                    <tr>
                                        <td>${item.title}</td>
                                        <td>${item.shortDescription}</td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <ul id="pagination" class="pagination-sm"></ul>
                    </div>
                </div>
            </div>
        </div>
    </div><!-- /.main-content -->
    <script type="text/javascript">
    $('#pagination').twbsPagination({
        startPage:2,
        totalPages: 16,
        visiblePages: 6,
        next: 'Next',
        prev: 'Prev',
            onPageClick: function (event, page) {
            //fetch content and render here
            $('#page-content').text('Page ' + page) + ' content here';
            }
    });
    </script>
</body>

</html>