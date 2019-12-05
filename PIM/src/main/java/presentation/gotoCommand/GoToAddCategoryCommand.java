package presentation.gotoCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import presentation.Command;
import presentation.*;

/**
 *
 * @author Malthe
 */
public class GoToAddCategoryCommand extends Command {
    
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("mainResponse", "");
        request.getSession().setAttribute("minorResponse", "");
        return "AddCategory";
    }
    
}
