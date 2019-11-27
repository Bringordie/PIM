package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.FileReaderLogic;
import logic.Products;
import presentation.UploadFiles;

/**
 *
 * @author Bringordie - Frederik Braagaard
 */
public class SearchProductCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        String results = "empty";
        String dropdown = request.getParameter("searchCriteria");
        String search = request.getParameter("searchInput");

        ArrayList<Products> viewallproducts = new ArrayList();
        switch (dropdown) {
            case "ProductID":
                dropdown = "productid";
                viewallproducts = dbSearch(search, dropdown);
                break;
            case "Product Name":
                dropdown = "name";
                viewallproducts = dbSearch(search, dropdown);
                break;
            case "Product Name Description":
                dropdown = "nameDescription";
                viewallproducts = dbSearch(search, dropdown);
                break;
            case "Product Description":
                dropdown = "description";
                viewallproducts = dbSearch(search, dropdown);
                break;
            case "Company Name":
                dropdown = "companyName";
                viewallproducts = dbSearch(search, dropdown);
                break;
            case "Price":
                dropdown = "price";
                viewallproducts = dbSearch(search, dropdown);
                break;
            case "Quantity":
                dropdown = "quantity";
                viewallproducts = dbSearch(search, dropdown);
                break;
            case "Picture Name (associated with product)":
                dropdown = "pictureName";
                viewallproducts = dbSearch(search, dropdown);
                break;
            case "Published Status":
                dropdown = "publishedStatus";
                if (search.toLowerCase().contains("yes") || search.contains("1")|| search.toLowerCase().contains("true")) {
                    viewallproducts = dbSearch("1", dropdown);
                } else if (search.toLowerCase().contains("no") || search.contains("0") || search.toLowerCase().contains("false"))
                    viewallproducts = dbSearch("0", dropdown);
                break;
            case "Main Category":
                dropdown = "mainCategoryName";
                viewallproducts = dbSearch(search, dropdown);
                break;
            case "Minor Category":
                dropdown = "minorCategoryName";
                viewallproducts = dbSearch(search, dropdown);
                break;
            default:
                System.err.print("Something went wrong");
        }

        int resulthits = viewallproducts.size();

        if (viewallproducts.isEmpty()) {
            results = "empty";
        } else if (viewallproducts.size() > 0) {
            results = "hit";
        }
        
        FileReaderLogic filechecker = new FileReaderLogic();
        for (Products viewallproduct : viewallproducts) {
            viewallproduct.getPictureName();
            try {
                String picturestatus = filechecker.FileCheck(viewallproduct.getPictureName());
                viewallproduct.setPictureName(picturestatus);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        request.getSession().setAttribute("errormsg", "empty");
        request.getSession().setAttribute("resulthits", results);
        request.getSession().setAttribute("viewallproducts", viewallproducts);
        request.getSession().setAttribute("resultDBhits", resulthits);

        return "ShowProducts";
    }

    private ArrayList<Products> dbSearch(String search, String dropdown) throws SQLException, ClassNotFoundException {
        ArrayList<Products> viewallproducts;
        viewallproducts = db.showSearchedProduct(search, dropdown, "/db.properties");
        return viewallproducts;
    }

}
