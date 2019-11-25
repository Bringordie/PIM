<%-- 
    Document   : index
    Created on : 19-11-2019, 15:50:12
    Author     : Frederik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@ include file = "header.jsp" %>

    <body>

        <form action="FrontController">
            <input type="hidden" name="cmd" value="gotoSearchProducts">
            <input type="Submit" value="Go to search" />
        </form>
        
        <form action="FrontController">
            <input type="hidden" name="cmd" value="gotoViewAllProducts">
            <input type="Submit" value="Go to view all products" />
        </form>

    </body>
</html>
