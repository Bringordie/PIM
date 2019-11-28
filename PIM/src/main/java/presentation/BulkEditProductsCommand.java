package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Products;
import persistence.CategoryMapper;
import persistence.ProductMapper;

/**
 *
 * @author Malthe
 */

public class BulkEditProductsCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        CategoryMapper cm = new CategoryMapper();
        ArrayList<Products> selectedProducts = Products.getProductTempholder();
        ProductMapper pm = new ProductMapper();
        String dropdown = request.getParameter("chosenAttribute");
        String edit = request.getParameter("bulkEditProducts");
        String callback = "";
        
        ArrayList<Products> searchresults = new ArrayList();
        switch (dropdown) {
            case "ProductID":
                dropdown = "productid";
                break;
            case "Product Name":
                dropdown = "name";
                break;
            case "Product Name Description":
                dropdown = "nameDescription";
                break;
            case "Product Description":
                dropdown = "description";
                break;
            case "Company Name":
                dropdown = "companyName";
                break;
            case "Price":
                dropdown = "price";
                break;
            case "Quantity":
                dropdown = "quantity";
                break;
            case "Picture Name (associated with product)":
                dropdown = "pictureName";
                break;
            case "Published Status":
                dropdown = "publishedStatus";
                if (edit.toLowerCase().contains("yes") || edit.contains("1")|| edit.toLowerCase().contains("true")) {
                    edit = "true";
                } else if (edit.toLowerCase().contains("no") || edit.contains("0") || edit.toLowerCase().contains("false"))
                    edit = "false";
                break;
            case "Main Category":
                dropdown = "mainCategory";
                edit = String.valueOf(cm.getMainValuesFromDBFile(edit, "/db.properties"));
                break;
            case "Minor Category":
                dropdown = "minorCategory";
                edit = String.valueOf(cm.getMinorValuesFromDBFile(edit, "/db.properties"));
                break;
            default:
                System.err.print("Something went wrong");
        }
        if (edit.equals("true") || edit.equals("false")) {
            callback = pm.BulkEditPublished(dropdown, Boolean.parseBoolean(edit), selectedProducts, "/db.properties");
        } else {
            callback = pm.BulkEditProducts(dropdown, edit, selectedProducts, "/db.properties");
        }
        
        request.getSession().setAttribute("callback", callback);
        
        return "BulkEditProducts";
    }
    
}
