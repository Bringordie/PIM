<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Products</title>
    </head>
    <%@ include file = "header.jsp" %>
    <body>
        <br>
        <br>
        <form action="FrontController">
            <input type="hidden" name="cmd" value="gotoBulkEditProducts">
            <input type="submit" value="Edit Selected Products">
            <table width = "50%" border = "1" align = "center">
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Name Description</td>
                        <%--<td>Description</td>--%>
                        <td>Company Name</td>
                        <td>Price</td>
                        <td>Qty</td>
                        <td>Picture Name</td>
                        <td>Published Status</td>
                        <td>Minor Category</td>
                        <td>Main Category</td>
                        <td>Edit</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="viewallproducts" items="${viewallproducts}">
                        <tr>
                            <td><c:out value="${viewallproducts.getId()}" /></td>
                            <td><c:out value="${viewallproducts.getName()}" /></td>
                            <td><c:out value="${viewallproducts.getNameDescription()}" /></td>
                            <%--<td><c:out value="${viewallproducts.getDescription()}" /></td>--%>
                            <td><c:out value="${viewallproducts.getCompanyName()}" /></td>
                            <td><c:out value="${viewallproducts.getPrice()}" /></td>
                            <td><c:out value="${viewallproducts.getQty()}" /></td>
                            <td><c:out value="${viewallproducts.getPictureName()}" /></td>
                            <td><c:out value="${viewallproducts.getPublishedStatus()}" /></td>
                            <td><c:out value="${viewallproducts.getMinorCategory()}" /></td>
                            <td><c:out value="${viewallproducts.getMainCategory()}" /></td>
                            <td><input type="checkbox" name="selected" value="${viewallproducts.getId()}"></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </body>
</html>
