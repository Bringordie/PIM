package DBtest;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    public void setUp() throws SQLException, ClassNotFoundException, IOException {
        dbextra.droptable(DBPROPERTYTEST);
        dbextra.createtable(DBPROPERTYTEST);

    }
    
    @Test
    public void uploadOfExcelUploadEmptyRow() throws SQLException, ClassNotFoundException, IOException, IOException {
        String fileName = "src/test/java/files/linewithemptyrow.xlsx";
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
    public void uploadOfExcelUpload() throws SQLException, ClassNotFoundException, IOException, IOException {
        String fileName = "src/test/java/files/linewithoutemptyrow.xlsx";
        ArrayList<Products> product = excelhandler.extractInfo(fileName);
        dbfacade.excelInsertOrUpdateToDB(product, DBPROPERTYTEST);

        String expected = "1";
        String actually = dbextra.getCustomDataFromDB("select publishedStatus from products;");
        assertEquals(expected, actually);

    }
    
    
    @Test
    public void updateOfExcelUpload() throws SQLException, ClassNotFoundException, IOException, IOException {
        String fileName = "src/test/java/files/linewithoutemptyrow.xlsx";
        ArrayList<Products> product = excelhandler.extractInfo(fileName);
        dbfacade.excelInsertOrUpdateToDB(product, DBPROPERTYTEST);
        dbfacade.excelInsertOrUpdateToDB(product, DBPROPERTYTEST);
        dbfacade.excelInsertOrUpdateToDB(product, DBPROPERTYTEST);
        dbfacade.excelInsertOrUpdateToDB(product, DBPROPERTYTEST);

        String expected = "1";
        String actually = dbextra.getCustomDataFromDB("select publishedStatus from products;");
        assertEquals(expected, actually);

    }
    
    
    @Test
    public void creationOfLinkedMMOfExcelUpload() throws SQLException, ClassNotFoundException, IOException, IOException {
        String fileName = "src/test/java/files/linewithoutemptyrow.xlsx";
        ArrayList<Products> product = excelhandler.extractInfo(fileName);
        dbfacade.excelInsertOrUpdateToDB(product, DBPROPERTYTEST);
        String expectedminor = "1";
        String expectedmain = "1";
        
        String actuallymain = dbextra.getCustomDataFromDB("select mainid from linkMinorMain;");
        assertEquals(expectedmain, actuallymain);
        
        String actuallyminor = dbextra.getCustomDataFromDB("select minorid from linkMinorMain;");
        assertEquals(expectedminor, actuallyminor);
        
    }
    
    
    @Test
    public void uploadOfJsonUpload() throws SQLException, ClassNotFoundException, IOException, FileNotFoundException {
        String fileName = "src/test/java/files/singledata.json";
        ArrayList<Products> product = jsonhandler.makeJSonFileIntoArray(fileName);
        dbfacade.jsonInsertOrUpdateToDB(product, DBPROPERTYTEST);

        int expected = 1;
        String dbcall = dbextra.getCustomDataFromDB("select COUNT(name) from products;");

        assertEquals(expected, Integer.parseInt(dbcall));

    }
    
    
    @Test
    public void updateOfJsonUpload() throws SQLException, ClassNotFoundException, IOException, FileNotFoundException {
        String fileName = "src/test/java/files/singledata.json";
        ArrayList<Products> product = jsonhandler.makeJSonFileIntoArray(fileName);
        dbfacade.jsonInsertOrUpdateToDB(product, DBPROPERTYTEST);
        dbfacade.jsonInsertOrUpdateToDB(product, DBPROPERTYTEST);
        dbfacade.jsonInsertOrUpdateToDB(product, DBPROPERTYTEST);
        dbfacade.jsonInsertOrUpdateToDB(product, DBPROPERTYTEST);

        int expected = 1;
        String dbcall = dbextra.getCustomDataFromDB("select COUNT(name) from products;");

        assertEquals(expected, Integer.parseInt(dbcall));

    }

    
    @Test
    public void emptyRowIsNullExcel() throws SQLException, ClassNotFoundException, IOException, IOException {
        String fileName = "src/test/java/files/linewithemptyrow.xlsx";
        ArrayList<Products> product = excelhandler.extractInfo(fileName);
        dbfacade.excelInsertOrUpdateToDB(product, DBPROPERTYTEST);

        String description = dbextra.getCustomDataFromDB("select description from products where productid = 8337");

        assertNull(description);

    }

    
    @Test
    public void creationOfMainCategory() throws SQLException, ClassNotFoundException, IOException {
        dbfacade.addMainCategory("Frost", DBPROPERTYTEST);

        String dbcall = dbextra.getCustomDataFromDB("select mainCategoryName from mainCategories");

        assertEquals("Frost", dbcall);

    }

    
    @Test
    public void creationOfMinorCategory() throws SQLException, ClassNotFoundException, IOException {
        dbfacade.addMinorCategory("Salat", DBPROPERTYTEST);

        String dbcall = dbextra.getCustomDataFromDB("select minorCategoryName from minorCategories");

        assertEquals("Salat", dbcall);

    }

    
    @Test
    public void deletionOfMainCategory() throws SQLException, ClassNotFoundException, IOException {
        dbfacade.addMainCategory("Salat", DBPROPERTYTEST);

        String dbcall = dbextra.getCustomDataFromDB("select COUNT(mainCategoryName) from mainCategories");
        String expected = "1";
        assertEquals(dbcall, expected);

        dbfacade.deleteMainCategory(1, DBPROPERTYTEST);
        String dbcall2 = dbextra.getCustomDataFromDB("select COUNT(mainCategoryName) from mainCategories");
        String expectednow = "0";
        assertEquals(expectednow, dbcall2);
    }

    
    @Test
    public void deletionOfMinorCategory() throws SQLException, ClassNotFoundException, IOException {
        dbfacade.addMinorCategory("Salat", DBPROPERTYTEST);

        String dbcall = dbextra.getCustomDataFromDB("select COUNT(minorCategoryName) from minorCategories");
        String expected = "1";
        assertEquals(dbcall, expected);

        dbfacade.deleteMinorCategory(1, DBPROPERTYTEST);
        String dbcall2 = dbextra.getCustomDataFromDB("select COUNT(minorCategoryName) from minorCategories");
        String expectednow = "0";
        assertEquals(expectednow, dbcall2);
    }

    
    @Test
    public void editMainCategory() throws SQLException, ClassNotFoundException, IOException {
        dbfacade.addMainCategory("Oksekød", DBPROPERTYTEST);

        dbfacade.editMainCategory(1, "Svinekød", DBPROPERTYTEST);
        String dbcall = dbextra.getCustomDataFromDB("select mainCategoryName from mainCategories");
        String expected = "Svinekød";
        assertEquals(expected, dbcall);
    }

    
    @Test
    public void editMinorCategory() throws SQLException, ClassNotFoundException, IOException {
        dbfacade.addMinorCategory("Salat", DBPROPERTYTEST);
        dbfacade.editMinorCategory(1, "Frugt", DBPROPERTYTEST);
        String dbcall = dbextra.getCustomDataFromDB("select minorCategoryName from minorCategories");
        String expected = "Frugt";
        assertEquals(expected, dbcall);
    }
    
    
    @Test
    public void addProductManually() throws SQLException, ClassNotFoundException, IOException {
        dbfacade.addMainCategory("Frugt", DBPROPERTYTEST);
        dbfacade.addMinorCategory("Økologisk", DBPROPERTYTEST);
        ArrayList<Products> products = new ArrayList();
        products.add(new Products(34, "Prudctname", "Productnamedescription", "productdescription", "companyname", 34, 50, "picturename", true ,"1", "1"));
        dbfacade.addProduct(products, DBPROPERTYTEST);

        String dbcall = dbextra.getCustomDataFromDB("select COUNT(productid) from products;");
        String expected = "1";
        assertEquals(expected, dbcall);
    }
    
    
    @Test
    public void getMainCategories() throws SQLException, ClassNotFoundException, IOException {
        dbfacade.addMainCategory("Salat", DBPROPERTYTEST);
        dbfacade.addMainCategory("Frugt og Grønt", DBPROPERTYTEST);
        dbfacade.addMainCategory("Is", DBPROPERTYTEST);
        
        String expected = "3";
        String dbcall = dbextra.getCustomDataFromDB("select COUNT(mainCategoryName) from maincategories;");
        
        assertEquals(expected, dbcall);
    }
    
    
    @Test
    public void getMinorCategories() throws SQLException, ClassNotFoundException, IOException {
        dbfacade.addMinorCategory("Frost", DBPROPERTYTEST);
        dbfacade.addMinorCategory("Drikkevarer", DBPROPERTYTEST);
        dbfacade.addMinorCategory("Kød", DBPROPERTYTEST);
        dbfacade.addMinorCategory("Slik", DBPROPERTYTEST);
        
        String expected = "4";
        String dbcall = dbextra.getCustomDataFromDB("select COUNT(minorCategoryName) from minorCategories;");
        
        assertEquals(expected, dbcall);
    }
    
    
    @Test
    public void searchProductByID() throws SQLException, ClassNotFoundException, IOException {
        dbfacade.addMainCategory("Frugt", DBPROPERTYTEST);
        dbfacade.addMinorCategory("Økologisk", DBPROPERTYTEST);
        ArrayList<Products> products = new ArrayList();
        products.add(new Products(34, "Grønne æbler", "Productnamedescription", "productdescription", "companyname", 34, 50, "picturename", true ,"1", "1"));
        products.add(new Products(55, "Test1", "Productnamedescription", "productdescription", "companyname", 34, 50, "picturename", true ,"1", "1"));
        products.add(new Products(35, "Test2", "Productnamedescription", "productdescription", "companyname", 34, 50, "picturename", true ,"1", "1"));
        products.add(new Products(500, "Test3", "Productnamedescription", "productdescription", "companyname", 34, 50, "picturename", true ,"1", "1"));
        dbfacade.addProduct(products, DBPROPERTYTEST);
        
        String expected = "Grønne æbler";
        ArrayList<Products> dbcall = dbfacade.searchProduct(34, DBPROPERTYTEST);
        String actually = "";
        for (Products productsdb : dbcall) {
            actually = productsdb.getName();
        }
        
        assertEquals(expected, actually);
    }
    
    
    @Test
    public void showAllProducts() throws SQLException, ClassNotFoundException, IOException {
        dbfacade.addMainCategory("Frugt", DBPROPERTYTEST);
        dbfacade.addMinorCategory("Økologisk", DBPROPERTYTEST);
        ArrayList<Products> products = new ArrayList();
        products.add(new Products(34, "Gulerødder øko.", "Productnamedescription", "productdescription", "companyname", 34, 50, "picturename", true ,"1", "1"));
        products.add(new Products(35, "Solsikkeskud øko.", "Productnamedescription", "productdescription", "companyname", 34, 50, "picturename", true ,"1", "1"));
        products.add(new Products(55, "Radisemix øko.", "Productnamedescription", "productdescription", "companyname", 34, 50, "picturename", true ,"1", "1"));
        products.add(new Products(500, "Kaki frugter", "Productnamedescription", "productdescription", "companyname", 34, 50, "picturename", true ,"1", "1"));
        dbfacade.addProduct(products, DBPROPERTYTEST);
        
        ArrayList<Products> dbcall = dbfacade.showAllProducts(DBPROPERTYTEST);
        
        String productnames = "";
        final StringBuilder builder = new StringBuilder();
        String expected = "Gulerødder øko.+Solsikkeskud øko.+Radisemix øko.+Kaki frugter+";
        for (Products productsdb : dbcall) {
            builder.append(productsdb.getName() + "+");
        }
        String concatenatedString = builder.toString();
        assertEquals(expected, concatenatedString);
    }
    
    
    @Test
    public void checkOrCreateLinkedMM() throws SQLException, ClassNotFoundException, IOException, IOException {
        dbfacade.addMainCategory("Frugt", DBPROPERTYTEST);
        dbfacade.addMainCategory("Økologisk", DBPROPERTYTEST);

        dbfacade.addMinorCategory("Frost", DBPROPERTYTEST);
        dbfacade.addMinorCategory("Drikkevarer", DBPROPERTYTEST);
        dbfacade.addMinorCategory("Kød", DBPROPERTYTEST);
        dbfacade.addMinorCategory("Slik", DBPROPERTYTEST);
        
        categorymapper.checkOrCreateLinkminormain(2, 3, DBPROPERTYTEST);
        categorymapper.checkOrCreateLinkminormain(2, 3, DBPROPERTYTEST);
        categorymapper.checkOrCreateLinkminormain(2, 3, DBPROPERTYTEST);
        categorymapper.checkOrCreateLinkminormain(2, 3, DBPROPERTYTEST);
        
        String expected = "1";
        String actually = dbextra.getCustomDataFromDB("select COUNT(minorid) from linkMinorMain;");
        
        assertEquals(expected, actually);
    }
    
    
    @Test
    public void checkCreationOfSeveralLinkMM() throws SQLException, ClassNotFoundException, IOException, IOException {
        dbfacade.addMainCategory("Frugt", DBPROPERTYTEST);
        dbfacade.addMainCategory("Økologisk", DBPROPERTYTEST);

        dbfacade.addMinorCategory("Frost", DBPROPERTYTEST);
        dbfacade.addMinorCategory("Drikkevarer", DBPROPERTYTEST);
        dbfacade.addMinorCategory("Kød", DBPROPERTYTEST);
        dbfacade.addMinorCategory("Slik", DBPROPERTYTEST);
        
        categorymapper.checkOrCreateLinkminormain(2, 3, DBPROPERTYTEST);
        categorymapper.checkOrCreateLinkminormain(1, 1, DBPROPERTYTEST);
        categorymapper.checkOrCreateLinkminormain(2, 2, DBPROPERTYTEST);
        categorymapper.checkOrCreateLinkminormain(1, 4, DBPROPERTYTEST);
        
        String expected = "4";
        String actually = dbextra.getCustomDataFromDB("select COUNT(minorid) from linkMinorMain;");
        
        assertEquals(expected, actually);
    }
    
}
