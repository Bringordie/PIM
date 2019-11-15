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
public class EditMainCategoryCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        String MainName = request.getParameter("MainName");
        //category.editMainCategory(id, MainName, "/db.properties");
        db.editMainCategory(id, MainName, "/db.properties");
        ArrayList<Categories> mainCategories = new ArrayList();
        //mainCategories = category.getMainValuesFromDB("/db.properties");
        mainCategories = db.getMainCategories("/db.properties");
        request.getSession().setAttribute("mainCategories", mainCategories);
        return "EditCategory";
    }
    
}
