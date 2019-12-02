<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Category</title>
    </head>
    <%@ include file = "../header.jsp" %>
    <body>
        <h1>Edit the name of a main or minor category:</h1>
        <table>
            <tr>
                <td>
                    <h3>Edit a main category:</h3>
                    <form name="editMainCategory" action="FrontController" method="POST">
                        <input type="hidden" name="cmd" value="editMainCategory">
                        <% if (session.getAttribute("mainCategories") != null) { %>
                        <table width = "50%" border = "1" align = "center">
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
                                        <td><input type="radio" name="id" value="${Categories.getID()}" required></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <br>
                        Enter new name:
                        <input type="text" name="MainName" required>
                        <input type="submit" value="Submit">
                        <% } else {%>
                        <p>There are no main categories!</p>
                        <% }%>
                    </form>
                    <br>
                    <h3>Edit a minor category:</h3>
                    <form name="editMinorCategory" action="FrontController" method="POST">
                        <input type="hidden" name="cmd" value="editMinorCategory">
                        <% if (session.getAttribute("minorCategories") != null) { %>
                        <table width = "50%" border = "1" align = "center">
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
                                        <td><input type="radio" name="id" value="${Categories.getID()}" required></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <br>
                        Enter new name:
                        <input type="text" name="MinorName" required>
                        <input type="submit" value="Submit">
                        <% } else {%>
                        <p>There are no minor categories!</p>
                        <% }%>
                        <br>
                        <br>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
