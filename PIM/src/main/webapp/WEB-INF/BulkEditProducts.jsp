<%-- 
    Document   : BulkEditProducts
    Created on : Nov 25, 2019, 9:54:20 AM
    Author     : Malthe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bulk Edit Products</title>
    </head>
    <%@ include file = "header.jsp" %>
    <body>
        <h1>Bulk Edit Multiple Products</h1>
        <br>
        <br>
        <table width = "50%" boder="1" align="center">
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
                    <td>Minor Category</td>
                    <td>Main Category</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="selected" items="${selected}">
                    <tr>
                        <td><c:out value="${selected.getId()}" /></td>
                        <td><c:out value="${selected.getName()}" /></td>
                        <td><c:out value="${selected.getNameDescription()}" /></td>
                        <td><c:out value="${selected.getDescription()}" /></td>
                        <td><c:out value="${selected.getCompanyName()}" /></td>
                        <td><c:out value="${selected.getPrice()}" /></td>
                        <td><c:out value="${selected.getQty()}" /></td>
                        <td><c:out value="${selected.getPictureName()}" /></td>
                        <td><c:out value="${selected.getPublishedStatus()}" /></td>
                        <td><c:out value="${selected.getMinorCategory()}" /></td>
                        <td><c:out value="${selected.getMainCategory()}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
