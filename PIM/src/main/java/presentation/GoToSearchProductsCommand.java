package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Products;

/**
 *
 * @author Bringordie - Frederik Braagaard
 */
public class GoToSearchProductsCommand extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException, SQLException, ClassNotFoundException{
        ArrayList<Products> searchresults = null;
        request.getSession().setAttribute("resulthits", "");
        request.getSession().setAttribute("searchresults", searchresults);
        request.getSession().setAttribute("resultDBhits", 0);
        
        return "Search";
    }
    
}
