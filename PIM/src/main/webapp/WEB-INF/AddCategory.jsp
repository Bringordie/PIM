<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
        <link rel="stylesheet" type="text/css" href="AddProduct.css"/>
        <link rel="stylesheet" type="text/css" href="AddCategory.css"/>

        <title>Add Category</title>
    </head>
    <link rel="stylesheet" type="text/css" href="AddCategory.css"/>

    <%@ include file = "../header.jsp" %>

    <body>
        <h1>Add a new category:</h1>
        <table>
            <tr>
                <td>
                    <form name="addMainCategory" action="FrontController" method="POST">
                    <input type="hidden" name="cmd" value="addMainCategory">

                        <div class="isertmaincategory">
                        Name of new minor category:<br>
                        </div>
                                                        
                        
                        <div class="mainnamecategory1">
                        <input type="text" name="MainName1" required>
                         </div>

                        <div class="buttonposition1">
                            <input class="button" input type="submit" name="sub1" value="Add Category">
                        </div>

                    </form>
                    
                    <% if (session.getAttribute("mainResponse").equals("Category added!")) { %>
                    <h3>Main category has been added!</h3>
                    <% } else if (session.getAttribute("mainResponse").equals("Category already exists!")) { %>
                    <h3>Error: That main category already exists!</h3>
                    <% } else {
                        } %>
                        
                        
                    <br>
                    <form name="addMinorCategory" action="FrontController" method="POST">
                        <input type="hidden" name="cmd" value="addMinorCategory">
                        
                        <div class="isertminorcategory">
                        Name of new main category:<br>
                        </div>
                        
                          <div class="mainnamecategory2">
                        <input type="text" name="MainName2" required>
                         </div>
                        
                        
                        <div class="buttonposition2">
                            <input class="button" input type="submit" name="sub2" value="Add Category">
                        </div>
                            </form>
                    
                    
                            <% if (session.getAttribute("minorResponse").equals("Category added!")) { %>
                            <h3>Minor category has been added!</h3>
                            <% } else if (session.getAttribute("minorResponse").equals("Category already exists!")) { %>
                            <h3>Error: That main category already exists!</h3>
                            <% } else {
                        }%>
                            </td>
                            </tr>
                            </table>
                            </body>
                            </html>
