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
    <body>
      
        <h1>Hello World!</h1>
        
        <form action="FrontController" name="addProduct" method="POST">
            
            <input type="hidden" name="cmd" value="deleteProduct" /><br>
            
             Add ProductID: <br />
            <input type="text" name="ProductId" value="" /><br>
             
            Add Productname: <br />
            <input type="text" name="ProductName" value="" /><br>
            
            
             Add ProductnameDescription: <br />
            <input type="text" name="ProductNameDescription" value="" /><br>
            
             Add Productdescription: <br />
            <input type="text" name="ProductDescription" value="" /><br>
            
             Add Companyname: <br />
            <input type="text" name="CompanyName" value="" /><br>
            
             Add Price: <br />
            <input type="text" name="Price" value="" /><br>
            
             Add Quantity: <br />
            <input type="text" name="Quantity" value="" /><br>
            
             Add Picturename: <br />
            <input type="text" name="PictureName" value="" /><br>
            
            
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
