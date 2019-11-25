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
import logic.Products;
import persistence.ProductMapper;

/**
 *
 * @author Slantefar
 */
public class GoToViewAllProductsCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
     
        
        ProductMapper productmapper = new ProductMapper();
        ArrayList<Products> viewallproducts = new ArrayList();
        viewallproducts = productmapper.showAllProducts("/db.properties");
        
        request.getSession().setAttribute("viewallproducts", viewallproducts);
        
        
        return "ShowProducts";
    }
    
}
