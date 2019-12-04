<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload File</title>
    </head>
    <%@ include file = "../header.jsp" %>
    <link rel="stylesheet" href="UploadFile.css">
    <body>
        <div class="fullbinder">
    
    <div class="binder">
        <h3>Upload File</h3>
        Select a <b>JSON</b> or <b>EXCEL</b> file to upload: 
        <br />
        <form action = "Upload" method = "POST" enctype = "multipart/form-data">
         <input type = "file" name = "file" size = "50" required accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,.csv,.json"/>
         <br />
         <input type = "submit" value = "Upload File to Website" />
      </form>
          </div>
          
          <div class="binder2">
        <h3>Upload Picture</h3>
        Select pictures to upload: 
        <br />
        <form action = "UploadImage" method = "POST" enctype = "multipart/form-data">
         <input name="file" type="file" id="file" multiple required accept=".JPG">
         <br />
         <input type = "submit" value = "Upload File to Website" />
      </form>
      </div>
      </div>
    </body>
</html>
