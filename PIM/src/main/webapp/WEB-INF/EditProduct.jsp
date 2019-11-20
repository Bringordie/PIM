<%-- 
    Document   : ProductAdd
    Created on : 13-11-2019, 12:46:29
    Author     : ClausFindinge - Claus Mikkelsen Findinge
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
      
         <h1>Edit product!</h1>
        
        <form action="FrontController" name="editProduct" method="POST">
            
            <input type="hidden" name="cmd" value="editProduct" /><br>
            
             Edit ProductID: <br />
            <input type="text" name="ProductId" value="" /><br>
             
            Edit Productname: <br />
            <input type="text" name="ProductName" value="" /><br>
            
            
             Edit ProductnameDescription: <br />
            <input type="text" name="ProductNameDescription" value="" /><br>
            
             Edit Productdescription: <br />
            <input type="text" name="ProductDescription" value="" /><br>
            
             Edit Companyname: <br />
            <input type="text" name="CompanyName" value="" /><br>
            
             Edit Price: <br />
            <input type="text" name="Price" value="" /><br>
            
             Edit Quantity: <br />
            <input type="text" name="Quantity" value="" /><br>
            
             Edit Picturename: <br />
            <input type="text" name="PictureName" value="" /><br>
            
            
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
