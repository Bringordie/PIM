/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class DeleteMinorCategoryCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        //category.deleteMinorCategory(id, "/db.properties");
        db.deleteMinorCategory(id, "/db.properties");

        ArrayList<Categories> mainCategories = new ArrayList();
        //mainCategories = category.getMainValuesFromDB("/db.properties");
        mainCategories = db.getMainCategories("/db.properties");
        request.getSession().setAttribute("mainCategories", mainCategories);

        ArrayList<Categories> minorCategories = new ArrayList();
        //minorCategories = category.getMinorValuesFromDB("/db.properties");
        minorCategories = db.getMinorCategories("/db.properties");
        request.getSession().setAttribute("minorCategories", minorCategories);

        return "DeleteCategory";
    }

}
