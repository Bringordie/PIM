/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author THOMA
 */
public class GoToSearchProductsCommand extends Command{

    @Override
    String execute(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        
        return "SearchProducts";
    }
    
}
