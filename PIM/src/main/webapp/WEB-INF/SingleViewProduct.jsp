<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Product</title>
    </head>
    <%@ include file = "header.jsp" %>
    <body>
        <br>
        <br>
        <form>
            <table width = "50%" border = "1" align = "center" class="table">
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Name Description</td>
                        <td>Description</td>
                        <td>Company Name</td>
                        <td>Price</td>
                        <td>Qty</td>
                        <%--<td>Picture Name</td>--%>
                        <td>Published Status</td>
                        <td>Minor Category</td>
                        <td>Main Category</td>
                        <td>Edit</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="selected" items="${selected}">
                        <tr id="test">
                            <td><c:out value="${selected.getId()}" /></td>
                            <td><c:out value="${selected.getName()}" /></td>
                            <td><c:out value="${selected.getNameDescription()}" /></td>
                            <td><c:out value="${selected.getDescription()}" /></td>
                            <td><c:out value="${selected.getCompanyName()}" /></td>
                            <td><c:out value="${selected.getPrice()}" /></td>
                            <td><c:out value="${selected.getQty()}" /></td>
                            <td><c:out value="${selected.getPictureName()}" /></td>
                            <%--<td><img src="${selected.getPictureName()}" border="0" with=70px height=70px></td>--%>
                            <td><c:out value="${selected.getPublishedStatus()}" /></td>
                            <td><c:out value="${selected.getMinorCategory()}" /></td>
                            <td><c:out value="${selected.getMainCategory()}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </body>
</html>
