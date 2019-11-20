/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Categories;


/**
 *
 * @author Malthe
 */
public class EditMinorCategoryCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        String MinorName = request.getParameter("MinorName");
        db.editMinorCategory(id, MinorName, "/db.properties");
        
        ArrayList<Categories> minorCategories = new ArrayList();
        minorCategories = category.getMinorValuesFromDB("/db.properties");
        request.getSession().setAttribute("minorCategories", minorCategories);
        
        return "EditCategory";
    }
    
}
