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
        <title>Edit Page</title>
    </head>
    <%@ include file = "header.jsp" %>
    <body>
      
         <h1>Edit product!</h1>
         
         <form action="FrontController" method="POST">
             <input type="hidden" name="cmd" value="editProductSearch" />
             <p>Please enter the ID of the product you want to edit:</p>
             <input type="number" name="ProductID" value="" required onkeydown="return event.keyCode !== 69"/>
             <input type="submit" value="Submit" />
         </form>
         
         <% if (session.getAttribute("resulthits").equals("empty")) { %>
         <p>No product found with this id.</p>
         <%}else if (session.getAttribute("resulthits").equals("gotoempty")){
        } else {%>
        <% if (session.getAttribute("productupdated").equals("Productupdated")) { %>
        <h3>Product has been updated</h3>
        <%} else { %>
        <form action="FrontController" name="editProduct" method="POST">
            
            <input type="hidden" name="cmd" value="editProduct" /><br>
            <c:forEach var="productarray" items="${productarray}">
             Edit ProductID: <br />
            <input type="number" name="ProductId" value="${productarray.getId()}" readonly style="color:#888;"/><br>
             
            Edit Productname: <br />
            <input type="text" name="ProductName" value="${productarray.getName()}" required/><br>
            
             Edit ProductnameDescription: <br />
            <input type="text" name="ProductNameDescription" value="${productarray.getNameDescription()}" required/><br>
            
             Edit Productdescription: <br />
            <input type="text" name="ProductDescription" value="${productarray.getDescription()}"/><br>
            
             Edit Companyname: <br />
            <input type="text" name="CompanyName" value="${productarray.getCompanyName()}" required/><br>
            
             Edit Price: <br />
            <input type="number" step="0.01" name="Price" value="${productarray.getPrice()}" onkeydown="return event.keyCode !== 69" step=".01" required/><br>
            
             Edit Quantity: <br />
            <input type="number" name="Quantity" value="${productarray.getQty()}" onkeydown="return event.keyCode !== 69" step="" required/><br>
            
             Edit Picturename: <br />
            <input type="text" name="PictureName" value="${productarray.getPictureName()}" required/><br>
            </c:forEach>
            
            <p>Main Category</p>
            <select id="maincategory" name="maincategory">
                <option>${currentmain}</option>
                <c:forEach var="maincategoriesarray" items="${maincategoriesarray}">
                <option>${maincategoriesarray.getName()}</option>
                </c:forEach>
            </select>
            
            <p>Minor Category</p>
            <select id="minorcategory" name="minorcategory">
                <option>${currentminor}</option>
                <c:forEach var="minorcategoriesarray" items="${minorcategoriesarray}">
                <option>${minorcategoriesarray.getName()}</option>
                </c:forEach>
            </select>
                <br> <br>
            
            <input type="submit" value="Submit" />
        </form>
         <%}%>
         <%}%>
    </body>
</html>
