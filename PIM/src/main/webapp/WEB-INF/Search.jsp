<%-- 
    Document   : Search
    Created on : 22-11-2019, 16:52:43
    Author     : Frederik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <%@ include file = "header.jsp" %>
    <body>
        <h4> What do you want to search for?: </h4>
        <form action="FrontController">
        <select id="searchCriteria" name="searchCriteria">
            
            <tr> 
            <option>ProductID</option>
            <option>Product Name</option>
            <option>Product Name Description</option>
            <option>Product Description</option>
            <option>Company Name</option>
            <option>Price</option>
            <option>Quantity</option>
            <option>Picture Name (associated with product)</option>
            <option>Published Status</option>
            <option>Minor Category</option>
            <option>Main Category</option>
        </tr>
    </select>
        <h4> Search: </h4>
        <input type="text" name="searchInput" value="" required/>
        <input type="hidden" name="cmd" value="searchResults">
            <input type="submit" value="Search" />
        </form>
        
        <% if (session.getAttribute("resulthits").toString().equals("empty")) { %>
        <h3>Your search gave 0 hits.</h3>
        <%} else if (session.getAttribute("resulthits").toString().equals("hit")) { %>
        <h3>Your search gave <%out.print(session.getAttribute("resultDBhits"));%> hits.</h3>
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


                </tr>
            </thead>
            <tbody>
            <c:forEach var="Products" items="${searchresults}">
                <tr>
                <td><c:out value="${Products.getId()}" /></td>
                <td><c:out value="${Products.getName()}" /></td>
                <td><c:out value="${Products.getNameDescription()}" /></td>
                <%--<td><c:out value="${Products.getDescription()}" /></td>--%>
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
        <%} else {}%>
</body>
</html>
