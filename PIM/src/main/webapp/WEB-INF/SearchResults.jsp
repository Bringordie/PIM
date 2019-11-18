<%-- 
    Document   : SearchResults
    Created on : Nov 13, 2019, 11:49:26 AM
    Author     : THOMA
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultater på ID:</h1>
        <table width = "50%" border = "1" align = "center">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Name Description</td>
                    <td>Description</td>
                    <td>Company Name</td>
                    <td>Price</td>
                    <td>Qty</td>
                    <td>Picture Name</td>
                    <td>Published Status</td>
                    <td>Minor Cat</td>
                    <td>Main Cat</td>


                </tr>
            </thead>
            <tbody>
            <c:forEach var="Products" items="${searchResult}">
                <tr>
                <td><c:out value="${Products.getId()}" /></td>
                <td><c:out value="${Products.getName()}" /></td>
                <%--<td><c:out value="${Products.getNameDescription}" /></td>--%>
                <td><c:out value="${Products.getDescription()}" /></td>
                <td><c:out value="${Products.getCompanyName()}" /></td>
                <td><c:out value="${Products.getPrice()}" /></td>
                <td><c:out value="${Products.getQty()}" /></td>
                <td><c:out value="${Products.getPictureName()}" /></td>
                <td><c:out value="${Products.getPublishedStatus()}" /></td>
                <td><c:out value="${Products.getMinorCategory()}" /></td>
                <td><c:out value="${Products.getMainCategory()}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table
</body>
</html>
