package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Products;

/**
 *
 * When you are in ShowProducts.jsp you can click on the ID of a product and be
 * navigated over to SingleViewProduct.
 * As we we want to see the full specific product we've selected we run through
 * all the products in the database and match it with the id to get all 
 * attributes.
 * 
 * @author Bringordie - Frederik Braagaard
 */
public class GoToSingleProductViewCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        String[] products = request.getParameterValues("selected");
        ArrayList<Products> allProducts = db.showAllProducts("/db.properties");
        ArrayList<Products> selectedProduct = new ArrayList();
        
        Products obj = null;
        for (int i = 0; i < products.length; ++i) {
            int id = Integer.parseInt(products[i]);
            for (int j = 0; j < allProducts.size(); ++j) {
                obj = allProducts.get(j);
                
                if (obj.getId() == id) {
                    selectedProduct.add(obj);
                }
            }
        }
        
        request.setAttribute("selected", selectedProduct);
        
        return "SingleViewProduct";
    }
    
}
