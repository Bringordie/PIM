<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload File</title>
    </head>
    <%@ include file = "header.jsp" %>
    <body>
         <h3>Download products as a .json file</h3>
        <form action = "DownloadJson">
         <input type = "submit" value = "Download File" />
      </form>
         <h3>Download products as a .xlsx file</h3>
        <form action = "DownloadExcel">
         <input type = "submit" value = "Download File" />
      </form>
    </body>
</html>
