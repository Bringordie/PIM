<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@ include file = "header.jsp" %>
    <body>
      
       <h1>Delete product!</h1>
        
        <form action="FrontController" name="deleteProduct" method="POST">
            
            <input type="hidden" name="cmd" value="deleteProduct" /><br>
            
             Delete ProductID: <br />
            <input type="number" name="ProductId" value="" required onkeydown="return event.keyCode !== 69" step=""/><br>
             
            
            <input type="submit" value="Submit" />
        </form>
          <% if (session.getAttribute("returndeleteproductvalue").toString().equals("empty")) {
                
            } else if (session.getAttribute("returndeleteproductvalue").toString().equals("deleteproduct")) { %>
            <p> Product has been deleted</p>                                  
            <%} else if (session.getAttribute("returndeleteproductvalue").toString().equals("deletealreadyexists")) {%>
            <p>Product ID doesn't exist, the product has not been deleted!</p>
            <%} else { %>
            <h1>svans</h1>
            <%}%>
    </body>
</html>
