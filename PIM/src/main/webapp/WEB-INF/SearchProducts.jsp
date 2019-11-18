<%-- 
    Document   : SearchProducts
    Created on : Nov 12, 2019, 10:55:15 AM
    Author     : THOMA
--%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Products</title>
    </head>
    <body>
        <h1>Brug søgefunktionen til at finde produkter efter ID</h1>
        <br>
                        <br>
                        <form action="FrontController">
                            <input type="hidden" name="cmd" value="searchResults">
                            
                            <input type="number" name="id" placeholder="Number" min="00000000" max="99999999" required>
                            <input type="submit" value="submit" />
                        </form>
    
    
    
    </body>
</html>
