<%--
    Document   : AddCategory
    Created on : Nov 11, 2019, 11:27:45 AM
    Author     : Malthe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
    </head>
    <%@ include file = "header.jsp" %>
    <body>
        <h1>Add a new category:</h1>
        <table>
            <tr>
                <td>
                    <form name="addMainCategory" action="FrontController" method="POST">
                        <input type="hidden" name="cmd" value="addMainCategory">
                        Name of new main category:<br>
                        <input type="text" name="MainName" required>
                        <input type="submit" value="Submit">
                    </form>
                    <% if (session.getAttribute("mainResponse").equals("Category added!")) { %>
                    <h3>Main category has been added!</h3>
                    <% } else if (session.getAttribute("mainResponse").equals("Category already exists!")) { %>
                    <h3>Error: That main category already exists!</h3>
                    <% } else {} %>
                    <br>
                    <form name="addMinorCategory" action="FrontController" method="POST">
                        <input type="hidden" name="cmd" value="addMinorCategory">
                        Name of new minor category:<br>
                        <input type="text" name="MinorName" required>
                        <input type="submit" value="Submit">
                    </form>
                    <% if (session.getAttribute("minorResponse").equals("Category added!")) { %>
                    <h3>Minor category has been added!</h3>
                    <% } else if (session.getAttribute("minorResponse").equals("Category already exists!")) { %>
                    <h3>Error: That main category already exists!</h3>
                    <% } else {} %>
                </td>
            </tr>
        </table>
    </body>
</html>
