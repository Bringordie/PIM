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
        <h1>Bulk Edit Multiple Products:</h1>
        <p>Choose which attribute you want to edit for all selected products: </p>
        <form action="FrontController">
            <select id="chosenAttribute" name="chosenAttribute">
                <tr> 
                <option>Product Name</option>
                <option>Product Name Description</option>
                <option>Product Description</option>
                <option>Company Name</option>
                <option>Price</option>
                <option>Quantity</option>
                <option>Published Status</option>
                <option>Minor Category</option>
                <option>Main Category</option>
                </tr>
            </select>
            <br>
            <br>
            <p>New input:</p>
            <input type="hidden" name="cmd" value="bulkEditProducts" />
            <input type="text" name="bulkEditProducts" value="" />
                <input type="submit" value="Apply Edit" />
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
        </form>
    </body>
</html>e
