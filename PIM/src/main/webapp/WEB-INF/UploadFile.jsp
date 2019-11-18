<%-- 
    Document   : UploadFile
    Created on : 08-11-2019, 17:04:22
    Author     : Frederik Braagaard - Bringordie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload File</title>
    </head>
    <body>
        <h3>File Upload:</h3>
        Select a <b>JSON</b> or <b>EXCEL</b> file to upload: 
        <br />
        <form action = "Upload" method = "POST" enctype = "multipart/form-data">
         <input type = "file" name = "file" size = "50" required/>
         <br />
         <input type = "submit" value = "Upload File to Website" />
      </form>
        <h3>File Picture</h3>
        Select pictures to upload: 
        <br />
        <form action = "UploadImage" method = "POST" enctype = "multipart/form-data">
         <%--<input type = "file" name = "file" size = "50" required/>--%>
         <input <input name="file" type="file" id="file" multiple required>
         <br />
         <input type = "submit" value = "Upload File to Website" />
      </form>
    </body>
</html>
