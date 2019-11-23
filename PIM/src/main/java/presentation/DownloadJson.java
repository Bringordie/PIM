package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.JsonWriter;

/**
 *
 * @author Bringordie - Frederik Braagaard
 */
public class DownloadJson extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        JsonWriter jsonwriter = new JsonWriter();
        try {
            jsonwriter.DataBaseToJson("/db.properties");
        } catch (Exception ex) {
            Logger.getLogger(DownloadJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "UploadFile";
    }
    
}
