package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.FileReaderLogic;
import logic.Products;

/**
 *
 * @author Malthe
 */
public class GoToBulkEditProductsCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        String[] products = request.getParameterValues("selected");
        ArrayList<Products> allProducts = db.showAllProducts("/db.properties");
        Products obj = null;
        ArrayList<Products> selectedProducts = new ArrayList();
        String website = "";
        String errormsg = "";
        if (!(products == null)) {
            for (int i = 0; i < products.length; ++i) {
                int id = Integer.parseInt(products[i]);
                for (int j = 0; j < allProducts.size(); ++j) {
                    obj = allProducts.get(j);

                    if (obj.getId() == id) {
                        selectedProducts.add(obj);
                    }
                }
            }
            website = "BulkEditProducts";
        } else {
            ArrayList<Products> viewallproducts = db.showAllProducts("/db.properties");
            errormsg = "noinput";
            website = "ShowProducts";
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
            request.getSession().setAttribute("viewallproducts", viewallproducts);
        }
        
        request.getSession().setAttribute("selected", selectedProducts);
        request.getSession().setAttribute("errormsg", "noinput");
        Products.setProductTempholder(selectedProducts);
        return website;
    }

}
