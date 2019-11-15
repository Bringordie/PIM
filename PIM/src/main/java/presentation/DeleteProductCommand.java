//package presentation;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import logic.Products;
//import persistence.DBFacade;
//import presentation.UploadFiles;
//
///**
// *
// * @author ClausFindinge - Claus Mikkelsen Findinge
// */
//public class DeleteProductCommand extends Command {
//    
//    DBFacade dbfacade = new DBFacade();
//
//    @Override
//    String execute(HttpServletRequest request, HttpServletResponse response) 
//       throws ServletException, IOException, SQLException, ClassNotFoundException{
//        //TODO
//       ArrayList<Products> products = new ArrayList();
//       int id = Integer.parseInt(request.getParameter("ProductId"));
//       String productname = (request.getParameter("ProductName"));
//       String productnamedescription = (request.getParameter("ProductNameDescription"));
//       String productdescription = (request.getParameter("ProductDescription"));
//       String companyname = (request.getParameter("CompanyName"));
//       double price = Integer.parseInt(request.getParameter("Price"));
//       int quantity = Integer.parseInt(request.getParameter("Quantity"));
//       String picturename = (request.getParameter("PictureName"));
//       String minorcategory = "1";
//       String maincategory = "1";
//       
//       products.remove(new Products(id, productname, productnamedescription, productdescription, companyname, price, quantity, picturename, true ,minorcategory, maincategory));
//       dbfacade.DeleteProduct(products); 
//      
//      
//      return"deleteProduct"; 
//    }
//    
//}
