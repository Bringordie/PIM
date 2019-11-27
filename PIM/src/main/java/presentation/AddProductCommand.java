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
 * @author ClausFindinge - Claus Mikkelsen Findinge
 */
public class AddProductCommand extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException, SQLException, ClassNotFoundException{
        //TODO
       ArrayList<Products> products = new ArrayList();
       int id = Integer.parseInt(request.getParameter("ProductId"));
       String productname = (request.getParameter("ProductName"));
       String productnamedescription = (request.getParameter("ProductNameDescription"));
       String productdescription = (request.getParameter("ProductDescription"));
       String companyname = (request.getParameter("CompanyName"));
       double price = Double.parseDouble(request.getParameter("Price"));
       int quantity = Integer.parseInt(request.getParameter("Quantity"));
       String picturename = (request.getParameter("PictureName"));
       String minorcategory = request.getParameter("minorid");
       String maincategory = request.getParameter("mainid");
       
       String returnvalue = "";
       
       products.add(new Products(id, productname, productnamedescription, productdescription, companyname, price, quantity, picturename, true ,minorcategory, maincategory));
       returnvalue = db.addProduct(products, "/db.properties");
      
       request.getSession().setAttribute("returnproductvalue", returnvalue); 
       
       
        return"AddProduct"; 
    }
    
}