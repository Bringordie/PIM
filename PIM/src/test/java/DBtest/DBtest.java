package DBtest;

import java.sql.SQLException;
import java.util.ArrayList;
import logic.ExcelHandler;
import logic.JsonHandler;
import logic.Products;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import persistence.CategoryMapper;
import persistence.DBConnection;
import persistence.DBFacade;
import persistence.ProductMapper;



public class DBtest {
    DBFacadeExtra dbextra = new DBFacadeExtra();
    DBFacade dbfacade = new DBFacade();
    ProductMapper productmapper = new ProductMapper();
    CategoryMapper categorymapper = new CategoryMapper();
    JsonHandler jsonhandler = new JsonHandler();
    ExcelHandler excelhandler = new ExcelHandler();
    String DBPROPERTYTEST = "/dbtest.properties";
    

    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        dbextra.droptable(DBPROPERTYTEST);
        dbextra.createtable(DBPROPERTYTEST);
        
    }
    
    @Test
    public void testConnectionIsOK() throws SQLException, ClassNotFoundException {
        
        assertNotNull( DBConnection.getConnection(DBPROPERTYTEST) );

    }
    
    @Test
    public void testEmptyRowIsNullExcel() throws SQLException, ClassNotFoundException {
        String fileName = "src\\test\\java\\files\\linewithemptyrow.xlsx";
        ArrayList<Products> product = excelhandler.extractInfo(fileName);
        dbfacade.excelInsertOrUpdateToDB(product, DBPROPERTYTEST);
        
        String description = dbextra.getCustomDataFromDB("select description from products where productid = 8337");
        
        assertNull (description);

    }
    
    //Need to change the import of excel sheet first before something like this would work.
    @Ignore
    @Test
    public void testUpdateOfUpload() throws SQLException, ClassNotFoundException {
        
        String fileName = "src\\test\\java\\files\\linewithemptyrow.xlsx";
        //Vector dataHolder = read(fileName);
        DBFacade db = new DBFacade();
        //db.uploadExcelFileToDB(dataHolder, "/dbtest.properties");
        
        DBFacadeExtra dbextra = new DBFacadeExtra();
        int expected = 1;
        String actually = dbextra.getCustomDataFromDB("select COUNT(name) from products;");
        
        assertEquals(expected, Integer.parseInt(actually));

    }
    

    
    }