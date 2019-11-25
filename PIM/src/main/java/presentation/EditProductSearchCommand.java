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
public class EditProductSearchCommand extends Command {
    

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException, SQLException, ClassNotFoundException{

        String results = "empty";
        int idsearch = 0;
        idsearch = Integer.parseInt(request.getParameter("ProductID"));
        ArrayList<Products> search = new ArrayList();
        search = db.searchProduct(idsearch, "/db.properties");
        
        if (search.isEmpty()){
            results = "empty";
        } else if (search.size() == 1){
            results = "hit";
        }
        
        request.getSession().setAttribute("resulthits", results);
        request.getSession().setAttribute("productarray", search);
        request.getSession().setAttribute("productupdated", "empty");
        
       
      
      
        return"EditProduct"; 
    }
    
}