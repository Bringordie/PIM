package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        ArrayList<Products> searchresults = new ArrayList();
        switch (dropdown) {
            case "ProductID":
                dropdown = "productid";
                searchresults = dbSearch(search, dropdown);
                break;
            case "Product Name":
                dropdown = "name";
                searchresults = dbSearch(search, dropdown);
                break;
            case "Product Name Description":
                dropdown = "nameDescription";
                searchresults = dbSearch(search, dropdown);
                break;
            case "Product Description":
                dropdown = "description";
                searchresults = dbSearch(search, dropdown);
                break;
            case "Company Name":
                dropdown = "companyName";
                searchresults = dbSearch(search, dropdown);
                break;
            case "Price":
                dropdown = "price";
                searchresults = dbSearch(search, dropdown);
                break;
            case "Quantity":
                dropdown = "quantity";
                searchresults = dbSearch(search, dropdown);
                break;
            case "Picture Name (associated with product)":
                dropdown = "pictureName";
                searchresults = dbSearch(search, dropdown);
                break;
            case "Published Status":
                dropdown = "publishedStatus";
                if (search.toLowerCase().contains("yes") || search.contains("1")|| search.toLowerCase().contains("true")) {
                    searchresults = dbSearch("1", dropdown);
                } else if (search.toLowerCase().contains("no") || search.contains("0") || search.toLowerCase().contains("false"))
                    searchresults = dbSearch("0", dropdown);
                break;
            case "Main Category":
                dropdown = "mainCategoryName";
                searchresults = dbSearch(search, dropdown);
                break;
            case "Minor Category":
                dropdown = "minorCategoryName";
                searchresults = dbSearch(search, dropdown);
                break;
            default:
                System.err.print("Something went wrong");
        }

        int resulthits = searchresults.size();

        if (searchresults.isEmpty()) {
            results = "empty";
        } else if (searchresults.size() > 0) {
            results = "hit";
        }
        request.getSession().setAttribute("resulthits", results);
        request.getSession().setAttribute("searchresults", searchresults);
        request.getSession().setAttribute("resultDBhits", resulthits);

        return "Search";
    }

    private ArrayList<Products> dbSearch(String search, String dropdown) throws SQLException, ClassNotFoundException {
        ArrayList<Products> searchresults;
        searchresults = db.showSearchedProduct(search, dropdown, "/db.properties");
        return searchresults;
    }

}
