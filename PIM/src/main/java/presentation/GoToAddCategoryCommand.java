package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malthe
 */
public class GoToAddCategoryCommand extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("mainResponse", "");
        request.getSession().setAttribute("minorResponse", "");
        return "AddCategory";
    }
    
}
