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
    <link rel="stylesheet/css" >
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
            <form action="<c:url value="/admin-news-list"/>" id="formSubmit" method="get">
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
                        <input type="hidden" value="" id="page" name="page"/>
                        <input type="hidden" value="" id="maxPageItem" name="maxPageItem">
                        <input type="hidden" value="" id="sortName" name="sortName">
                        <input type="hidden" value="" id="sortBy" name="sortBy">
                    </div>
                </div>
            </div>
            </form>
        </div>
    </div><!-- /.main-content -->
    <script type="text/javascript">

        /* jQuery Pagination Example (twbs-pagination) */
        var totalPage = ${model.totalPage};
        var currentPage = ${model.page};
        var limit = 2;
        $('#pagination').twbsPagination({
            startPage: currentPage,
            totalPages: totalPage,
            visiblePages: 10,
            next: 'Next',
            prev: 'Prev',
                onPageClick: function (event, page) {
                //fetch content and render here
                    if(currentPage != page ) {
                        $('#maxPageItem').val(limit);
                        $('#page').val(page);
                        $('#sortName').val('title');
                        $('#sortBy').val('desc');
                        $('#formSubmit').submit();
                    }
                }
        });
        /* jQuery Pagination Example (twbs-pagination) */

    </script>
</body>
