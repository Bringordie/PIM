package DBtest;

import java.io.FileNotFoundException;
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
        assertNotNull(DBConnection.getConnection(DBPROPERTYTEST));

    }

    @Test
    public void testUploadOfExcelUploadEmptyRow() throws SQLException, ClassNotFoundException {
        String fileName = "src\\test\\java\\files\\linewithemptyrow.xlsx";
        ArrayList<Products> product = excelhandler.extractInfo(fileName);
        dbfacade.excelInsertOrUpdateToDB(product, DBPROPERTYTEST);

        int expected = 1;
        String actually = dbextra.getCustomDataFromDB("select COUNT(name) from products;");

        assertEquals(expected, Integer.parseInt(actually));

        String expectedrequired = "0";
        String actuallyrequired = dbextra.getCustomDataFromDB("select publishedStatus from products;");
        assertEquals(expectedrequired, actuallyrequired);

    }

    @Test
    public void testUploadOfExcelUpload() throws SQLException, ClassNotFoundException {
        String fileName = "src\\test\\java\\files\\linewithoutemptyrow.xlsx";
        ArrayList<Products> product = excelhandler.extractInfo(fileName);
        dbfacade.excelInsertOrUpdateToDB(product, DBPROPERTYTEST);

        String expectedrequired = "1";
        String actuallyrequired = dbextra.getCustomDataFromDB("select publishedStatus from products;");
        assertEquals(expectedrequired, actuallyrequired);

    }

    @Test
    public void testUploadOfJsonUpload() throws SQLException, ClassNotFoundException, FileNotFoundException {
        String fileName = "src\\test\\java\\files\\singledata.json";
        ArrayList<Products> product = jsonhandler.makeJSonFileIntoArray(fileName);
        dbfacade.jsonInsertOrUpdateToDB(product, DBPROPERTYTEST);

        int expected = 1;
        String dbcall = dbextra.getCustomDataFromDB("select COUNT(name) from products;");

        assertEquals(expected, Integer.parseInt(dbcall));

    }

    @Test
    public void testEmptyRowIsNullExcel() throws SQLException, ClassNotFoundException {
        String fileName = "src\\test\\java\\files\\linewithemptyrow.xlsx";
        ArrayList<Products> product = excelhandler.extractInfo(fileName);
        dbfacade.excelInsertOrUpdateToDB(product, DBPROPERTYTEST);

        String description = dbextra.getCustomDataFromDB("select description from products where productid = 8337");

        assertNull(description);

    }

    @Test
    public void testCreationOfMainCategory() throws SQLException, ClassNotFoundException {
        dbfacade.addMainCategory("Frost", DBPROPERTYTEST);

        String dbcall = dbextra.getCustomDataFromDB("select mainCategoryName from mainCategories");

        assertEquals("Frost", dbcall);

    }

    @Test
    public void testCreationOfMinorCategory() throws SQLException, ClassNotFoundException {
        dbfacade.addMinorCategory("Salat", DBPROPERTYTEST);

        String dbcall = dbextra.getCustomDataFromDB("select minorCategoryName from minorCategories");

        assertEquals("Salat", dbcall);

    }

    @Test
    public void testDeletionOfMainCategory() throws SQLException, ClassNotFoundException {
        dbfacade.addMainCategory("Salat", DBPROPERTYTEST);

        String dbcall = dbextra.getCustomDataFromDB("select COUNT(mainCategoryName) from mainCategories");
        String expected = "1";
        assertEquals(dbcall, expected);

        dbfacade.deleteMainCategory(1, DBPROPERTYTEST);
        String dbcall2 = dbextra.getCustomDataFromDB("select COUNT(mainCategoryName) from mainCategories");
        String expectednow = "0";
        assertEquals(dbcall2, expectednow);
    }

    @Test
    public void testDeletionOfMinorCategory() throws SQLException, ClassNotFoundException {
        dbfacade.addMinorCategory("Salat", DBPROPERTYTEST);

        String dbcall = dbextra.getCustomDataFromDB("select COUNT(minorCategoryName) from minorCategories");
        String expected = "1";
        assertEquals(dbcall, expected);

        dbfacade.deleteMinorCategory(1, DBPROPERTYTEST);
        String dbcall2 = dbextra.getCustomDataFromDB("select COUNT(minorCategoryName) from minorCategories");
        String expectednow = "0";
        assertEquals(dbcall2, expectednow);
    }

    @Test
    public void testEditMainCategory() throws SQLException, ClassNotFoundException {
        dbfacade.addMainCategory("Oksekød", DBPROPERTYTEST);

        dbfacade.editMainCategory(1, "Svinekød", DBPROPERTYTEST);
        String dbcall2 = dbextra.getCustomDataFromDB("select mainCategoryName from mainCategories");
        String expectednow = "Svinekød";
        assertEquals(dbcall2, expectednow);
    }

    @Test
    public void testEditMinorCategory() throws SQLException, ClassNotFoundException {
        dbfacade.addMinorCategory("Salat", DBPROPERTYTEST);

        dbfacade.editMinorCategory(1, "Frugt", DBPROPERTYTEST);
        String dbcall2 = dbextra.getCustomDataFromDB("select minorCategoryName from minorCategories");
        String expectednow = "Frugt";
        assertEquals(dbcall2, expectednow);
    }
    
}
