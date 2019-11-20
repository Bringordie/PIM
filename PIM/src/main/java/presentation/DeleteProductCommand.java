package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Products;
import persistence.DBFacade;
import persistence.ProductMapper;
import presentation.UploadFiles;

/**
 *
 * @author ClausFindinge - Claus Mikkelsen Findinge
 */
public class DeleteProductCommand extends Command {
    
    ProductMapper productmapper = new ProductMapper();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException, SQLException, ClassNotFoundException{
        //TODO
      productmapper.DeleteProduct(Integer.parseInt(request.getParameter("ProductId")));
 
        return"DeleteProduct"; 
    }
    
}