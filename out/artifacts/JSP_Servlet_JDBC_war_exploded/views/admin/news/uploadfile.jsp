<%--
  Created by IntelliJ IDEA.
  User: Smurf3r
  Date: 11/21/2020
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="UploadfileURL" value="/admin-news-list/uploadfile"/>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="col-sm-12 margin-15" >
        <div class="col-xs-12">
            <form enctype="multipart/form-data" id="formUpload">
                <div class="form-group">
                    <label for="file">Upload Hình Ảnh</label>
                    <input type="file" class="form-control-file" id="file" name="file">
                </div>
                <div>
                    <input id="btnUploadFile" type="button" class="btn btn-primary" value="Upload File"/>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    //Hàm xử lý uploadfile
    $('#btnUploadFile').click(function(e){
        console.log("he");
        e.preventDefault();
        var data ;
        data = new FormData();
        data.append('file',$( '#file' )[0].files[0]);
        $.ajax({
            url:'${UploadfileURL}',
            type: 'POST',
            data: data,
            processData:false,
            contentType: false,
            success:(data)=>{
                console.log(data);
                console.log("gửi file lên thành công");
            },
            error:(data)=>{
                console.log(data);
                console.log("gửi file thất bại");
            }
        });
    });

</script>
</body>
</html>
