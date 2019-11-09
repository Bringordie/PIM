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
      Select a file to upload: <br />
      <form action = "Upload" method = "post" enctype = "multipart/form-data">
         <input type = "file" name = "file" size = "50" />
         <br />
         <input type = "submit" value = "Upload File" />
      </form>
    </body>
</html>
