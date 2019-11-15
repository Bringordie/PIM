package DBtest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import static logic.ExcelHandler.read;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Ignore;
import org.junit.Test;
import persistence.DBConnectionDemo;
import persistence.DBFacade;



public class DBtest {
    
    
    @Test
    public void testConnectionIsOK() throws SQLException, ClassNotFoundException {
        
        assertNotNull( DBConnectionDemo.getConnection() );

    }
    
    @Test
    public void testEmptyRowIsNull() throws SQLException, ClassNotFoundException {
        
        String fileName = "src\\test\\java\\files\\linewithemptyrow.xlsx";
        Vector dataHolder = read(fileName);
        DBFacade db = new DBFacade();
        db.uploadExcelFileToDB(dataHolder, "/dbtest.properties");
        
        DBFacadeExtra dbextra = new DBFacadeExtra();
        String actually = dbextra.getCustomDataFromDB("select description from products where productid = 9312");
        
        assertNull (actually);

    }
    
    //Need to change the import of excel sheet first before something like this would work.
    @Ignore
    @Test
    public void testUpdateOfUpload() throws SQLException, ClassNotFoundException {
        
        String fileName = "src\\test\\java\\files\\linewithemptyrow.xlsx";
        Vector dataHolder = read(fileName);
        DBFacade db = new DBFacade();
        db.uploadExcelFileToDB(dataHolder, "/dbtest.properties");
        
        DBFacadeExtra dbextra = new DBFacadeExtra();
        int expected = 1;
        String actually = dbextra.getCustomDataFromDB("select COUNT(name) from products;");
        
        assertEquals(expected, Integer.parseInt(actually));

    }
    

    
    }