package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bringordie - Frederik Braagaard
 */
public class GoToDownloadFileCommand extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
               
        return "DownloadFile";
    }
    
}
