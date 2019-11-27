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
//                if (search.toLowerCase().contains("yes") || search.contains("1")|| search.toLowerCase().contains("true")) {
//                    searchresults = dbSearch("1", dropdown);
//                } else if (search.toLowerCase().contains("no") || search.contains("0") || search.toLowerCase().contains("false"))
//                    searchresults = dbSearch("0", dropdown);
                break;
            case "Main Category":
                dropdown = "mainCategory";
                edit = String.valueOf(cm.getMainValuesFromDBFile(edit, "/db.properties"));
                break;
            case "Minor Category":
                dropdown = "minorCategory";
//                searchresults = dbSearch(edit, dropdown);
                edit = String.valueOf(cm.getMinorValuesFromDBFile(edit, "/db.properties"));
                break;
            default:
                System.err.print("Something went wrong");
        }
        pm.BulkEditProducts(dropdown, edit, selectedProducts, "/db.properties");
        
        return "BulkEditProducts";
    }
    
}
