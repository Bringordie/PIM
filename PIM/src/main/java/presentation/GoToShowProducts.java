package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GoToShowProducts extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        
        return "ShowProducts";
    }
    
}
