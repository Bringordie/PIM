<%-- 
    Document   : ProductAdd
    Created on : 13-11-2019, 12:46:29
    Author     : ClausFindinge - Claus Mikkelsen Findinge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add product</title>
    </head>
    <body>

        <h1>Add a product!</h1>

        <form action="FrontController" name="addProduct" method="POST">

            <input type="hidden" name="cmd" value="addProduct" required /><br>

            Add ProductID: <br />
            <input type="text" name="ProductId" value="" required /><br>

            Add Productname: <br />
            <input type="text" name="ProductName" value="" required /><br>


            Add ProductnameDescription: <br />
            <input type="text" name="ProductNameDescription" value="" required /><br>

            Add Productdescription: <br />
            <input type="text" name="ProductDescription" value="" required /><br>

            Add Companyname: <br />
            <input type="text" name="CompanyName" value="" required /><br>

            Add Price: <br />
            <input type="text" name="Price" value="" required /><br>

            Add Quantity: <br />
            <input type="text" name="Quantity" value="" required /><br>

            Add Picturename: <br />
            <input type="text" name="PictureName" value="" required /><br>

            Choose Main category: <br />
            <% if (session.getAttribute("mainCategories") != null) { %>
            <table width = "10%" border = "1">
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Select</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="Categories" items="${mainCategories}">
                        <tr>
                            <td><c:out value="${Categories.getName()}" /></td>
                            <td><input type="radio" name="mainid" value="${Categories.getID()}" required></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <% } else {%>
            <p>There are no main categories!</p>
            <% }%>
            <br>
            Choose Minor category: <br />
            <% if (session.getAttribute("minorCategories") != null) { %>
            <table width = "10%" border = "1">
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Select</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="Categories" items="${minorCategories}">
                        <tr>
                            <td><c:out value="${Categories.getName()}" /></td>
                            <td><input type="radio" name="minorid" value="${Categories.getID()}" required></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <%--
            <select name="Minor">
                <option></option>
                    <c:forEach var="Categories" items="${minorCategories}">
                        <tr>
                            <option> ${Categories.getName()} </option>
                        </tr>
                    </c:forEach>
            </select>
            
            <select name="Main">
                <option></option>
                    <c:forEach var="Categories" items="${mainCategories}">
                        <tr>
                            <option> ${Categories.getName()} </option>
                        </tr>
                    </c:forEach>
            </select> --%>

            <input type="submit" value="Submit" />
            <% } else {%>
            <p>There are no minor categories!</p>
            <% }%>
        </form>
    </body>
</html>
