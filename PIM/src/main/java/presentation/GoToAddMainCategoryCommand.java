package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malthe
 */
public class GoToAddMainCategoryCommand extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        
        return "AddMainCategory";
    }
    
}
