package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.ExcelWriter;
import logic.JsonWriter;

/**
 *
 * @author Bringordie - Frederik Braagaard
 */
public class DownloadExcel extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        ExcelWriter excelwriter = new ExcelWriter();
        try {
            excelwriter.DataBaseToExcel("/db.properties");
        } catch (Exception ex) {
            Logger.getLogger(DownloadExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "UploadFile";
    }
    
}
