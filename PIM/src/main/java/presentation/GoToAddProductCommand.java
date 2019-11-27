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
 * @author Slantefar
 */
public class GoToAddProductCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
     
        ArrayList<Categories> mainCategories = new ArrayList();
        mainCategories = db.getMainCategories("/db.properties");
        if (mainCategories.size() != 0) {
            request.getSession().setAttribute("mainCategories", mainCategories);
        } else {
            request.getSession().setAttribute("mainCategories", null);
        }
        
        ArrayList<Categories> minorCategories = new ArrayList();
        minorCategories = db.getMinorCategories("/db.properties");
        if (minorCategories.size() != 0) {
            request.getSession().setAttribute("minorCategories", minorCategories);
        } else {
            request.getSession().setAttribute("minorCategories", null);
        }
        request.getSession().setAttribute("returnproductvalue", "empty"); 
        return "AddProduct";
    }
    
}
