/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Categories;
import presentation.GoToDeleteCategoryCommand;

/**
 *
 * @author Malthe
 */
public class DeleteMainCategoryCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        category.deleteMainCategory(id);

        HashSet<Categories> mainCategories = new HashSet();
        mainCategories = category.getMainValuesFromDB();
        request.getSession().setAttribute("mainCategories", mainCategories);

        HashSet<Categories> minorCategories = new HashSet();
        minorCategories = category.getMinorValuesFromDB();
        request.getSession().setAttribute("minorCategories", minorCategories);

        return "DeleteCategory";
    }

}
