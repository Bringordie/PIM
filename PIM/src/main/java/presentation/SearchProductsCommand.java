/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author THOMA
 */
public class SearchProductsCommand extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        
//        String sql = "SELECT * from Products WHERE ID=?";
//        int id = Integer.parseInt(request.getParameter("id"));
//        products.

          int id = Integer.parseInt(request.getParameter("id"));
          
          
          ArrayList<Products>product= new ArrayList();
          product = db.getSearchResults(id);
          request.getSession().setAttribute("searchResult", product);
        
        
          return "SearchResults";
    }
    
}
