package presentation;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import presentation.UploadFiles;

/**
 *
 * @author Bringordie - Frederik Braagaard
 */
public class UploadJSONCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException, SQLException, ClassNotFoundException{
        //TODO
        String filename = request.getParameter("file");
        UploadFiles upload = new UploadFiles();
        upload.init();
        upload.doGet(request, response);
        upload.doPost(request, response);
        
        return"UploadFile";
    }
    
}