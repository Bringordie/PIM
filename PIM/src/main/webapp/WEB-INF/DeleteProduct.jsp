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
        
        <form action="FrontController" name="deleteProduct" method="POST">
            
            <input type="hidden" name="cmd" value="deleteProduct" /><br>
            
             Delete ProductID: <br />
            <input type="text" name="ProductId" value="" /><br>
             
            Delete Productname: <br />
            <input type="text" name="ProductName" value="" /><br>
            
            
             Delete ProductnameDescription: <br />
            <input type="text" name="ProductNameDescription" value="" /><br>
            
             Delete Productdescription: <br />
            <input type="text" name="ProductDescription" value="" /><br>
            
             Delete Companyname: <br />
            <input type="text" name="CompanyName" value="" /><br>
            
             Delete Price: <br />
            <input type="text" name="Price" value="" /><br>
            
             Delete Quantity: <br />
            <input type="text" name="Quantity" value="" /><br>
            
             Delete Picturename: <br />
            <input type="text" name="PictureName" value="" /><br>
            
            
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
