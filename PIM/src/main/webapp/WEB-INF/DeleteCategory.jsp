<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Category</title>
    </head>
    <%@ include file = "../header.jsp" %>
    <body>
        <h1>Delete a main or a minor category:</h1>
        <table>
            <tr>
                <td>
                    <h3>Delete a main category:</h3>
                    <form name="deleteMainCategory" action="FrontController" method="POST">
                        <input type="hidden" name="cmd" value="deleteMainCategory">
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
                        <input type="submit" value="Submit">
                        <% } else {%>
                        <p>There are no main categories!</p>
                        <% }%>
                    </form>
                    <br>
                    <h3>Delete a minor category:</h3>
                    <form name="deleteMinorCategory" action="FrontController" method="POST">
                        <input type="hidden" name="cmd" value="deleteMinorCategory">
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
                        <input type="submit" value="Submit">
                        <% } else {%>
                        <p>There are no minor categories!</p>
                        <% }%>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
