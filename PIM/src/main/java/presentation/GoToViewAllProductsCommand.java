/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Categories;
import logic.FileReaderLogic;
import logic.Products;
import persistence.ProductMapper;

/**
 *
 * @author Slantefar
 */
public class GoToViewAllProductsCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        FileReaderLogic filechecker = new FileReaderLogic();

        ProductMapper productmapper = new ProductMapper();
        ArrayList<Products> viewallproducts = new ArrayList();
        viewallproducts = productmapper.showAllProducts("/db.properties");
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
        request.getSession().setAttribute("viewallproducts", viewallproducts);

        return "ShowProducts";
    }

}
