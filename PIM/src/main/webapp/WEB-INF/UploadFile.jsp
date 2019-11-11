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
        Select a <b>JSON</b> file to upload: 
        <br />
        <form action = "Upload" method = "POST" enctype = "multipart/form-data">
          <input type="hidden" name="cmd" value="gotoUploadFile" />
         <input type = "file" name = "file" size = "50" required/>
         <br />
         <input type = "submit" value = "Upload File to Website" />
      </form>
        <br />
        Select a <b>EXCEL</b> file to upload: 
        <br />
      <form action = "Upload" method = "POST" enctype = "multipart/form-data">
         <input type = "file" name = "file" size = "50" required/>
         <br />
         <input type = "submit" value = "Upload File to Website" />
      </form>
    </body>
</html>
