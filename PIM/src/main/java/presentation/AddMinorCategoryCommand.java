package presentation;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malthe
 */
public class AddMinorCategoryCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        String minorCatName = request.getParameter("MinorName");
        category.addMinorCategory(minorCatName);
        
        return "AddCategory";
    }
    
}
