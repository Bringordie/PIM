package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import logic.Products;


public interface ProductMapperInterface {
    
    public void jsonInsertOrUpdateToDB(ArrayList<Products> list, String propertyname) throws SQLException, ClassNotFoundException;
    
    public void excelInsertOrUpdateToDB(ArrayList<Products> list, String propertyname) throws ClassNotFoundException, NumberFormatException, SQLException;
    
    public boolean checkIfProductExists(String productid, String propertyname) throws SQLException, ClassNotFoundException;
    
    public String addProduct(ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException;
    
    public String deleteProduct(int id, String propertyname) throws SQLException, ClassNotFoundException;
    
    public ArrayList<Products> getSearchResults(int productid, String propertyname) throws SQLException, ClassNotFoundException;
    
    public ArrayList<Products> showAllProducts(String propertyname) throws SQLException, ClassNotFoundException;
    
    public ArrayList<Products> showSearchedProduct(String search, String attribute, String propertyname) throws SQLException, ClassNotFoundException;
    
    public ArrayList<Products> dbDownload(String propertyname) throws SQLException, ClassNotFoundException;
    
    public String bulkEditPublished(String attribute, boolean changeValue, ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException;
    
    public String bulkEditProducts(String attribute, String changeValue, ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException;
    
    public void editProduct(int id, Products product, String propertyname) throws SQLException, ClassNotFoundException;
}
