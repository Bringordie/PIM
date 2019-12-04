<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add product</title>
    </head>
    <link rel="stylesheet" href="AddProduct.css"> 
    <%@ include file = "../header.jsp" %>
    <body>

        <h1>Add a product</h1>

        <form action="FrontController" name="addProduct" method="POST">

            <input type="hidden" name="cmd" value="addProduct" required /><br>
            
            <div class="nameAndInput">
            Add Product ID: <br />
            <input type="number" min="1" name="ProductId" value="" required onkeydown="return event.keyCode !== 69" step=""/><br>
            <br>
            
            Add Product Name: <br />
            <input type="text" name="ProductName" value="" required /><br>
            <br>
            
            Add Product Name Description: <br />
            <input type="text" name="ProductNameDescription" value="" required /><br>
            <br>
            
            Add Product Description: <br />
            <input type="text" name="ProductDescription" value="" required /><br>
            <br>
            
            Add Company Name: <br />
            <input type="text" name="CompanyName" value="" required /><br>
            <br>
            
            Add Price: <br />
            <input type="number" min="0" step="0.01" name="Price" value="" required onkeydown="return event.keyCode !== 69" step=".01"/><br>
            <br>
            
            Add Quantity: <br />
            <input type="number" min="0" name="Quantity" value="" required onkeydown="return event.keyCode !== 69" step=""/><br>
            <br>
            
            Add Picturename: <br />
            <input type="text" name="PictureName" value="" required /><br>
            </div>
            <br>
            
            <div class="left">
            Choose Main category: <br />
            <% if (session.getAttribute("mainCategories") != null) { %>
            <select id="maincategory" name="maincategory">
                <c:forEach var="mainCategories" items="${mainCategories}">
                    <option>${mainCategories.getName()}</option>
                </c:forEach>
            </select>
            </div>
            <% } else {%>
            <p>There are no main categories!</p>
            <% }%>
            
            <div class="right">
            Choose Minor category: <br />
            <% if (session.getAttribute("minorCategories") != null) { %>
            <select id="minorcategory" name="minorcategory">
                <c:forEach var="minorCategories" items="${minorCategories}">
                    <option>${minorCategories.getName()}</option>
                </c:forEach>
            </select>
            </div>
            <br>
            <br>
            <div class="buttonAlign">
            <input class="button" type="submit" value="Submit" />
            </div>
            <% } else {%>
            <p>There are no minor categories!</p>
            <% }%>
        </form>
        <% if (session.getAttribute("returnproductvalue") == null) {
            } else if (session.getAttribute("returnproductvalue").toString().equals("productadded")) { %>
        <h1>Product created!</h1>
        <%} else if (session.getAttribute("returnproductvalue").toString().equals("alreadyexists")) {%>
        <h1>Unable to execute request. Product with this ID already exists.</h1>
        <%} else {
                }%>
    </body>
</html>
