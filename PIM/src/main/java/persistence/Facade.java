package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import logic.Categories;
import logic.Products;

public interface Facade { 
    
    public void jsonInsertOrUpdateToDB(ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException;
    
    public void excelInsertOrUpdateToDB(ArrayList<Products> product, String propertyname) throws SQLException, ClassNotFoundException;
    
    public String addProduct(ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException;
    
    public String addMainCategory (String category, String propertyname) throws ClassNotFoundException, SQLException;
    
    public String addMinorCategory (String category, String propertyname) throws ClassNotFoundException, SQLException;
    
    public void deleteMainCategory (int category, String propertyname) throws ClassNotFoundException, SQLException;
    
    public void deleteMinorCategory (int category, String propertyname) throws ClassNotFoundException, SQLException;
    
    public void editMainCategory (int categoryInt, String categoryStr, String propertyname) throws ClassNotFoundException, SQLException;
    
    public void editMinorCategory (int categoryInt, String categoryStr, String propertyname) throws ClassNotFoundException, SQLException;
    
    public ArrayList<Categories> getMainCategories (String propertyname) throws ClassNotFoundException, SQLException;
    
    public ArrayList<Categories> getMinorCategories (String propertyname) throws ClassNotFoundException, SQLException;
    
    public int getMainCategoriesID(String mainname, String propertyname) throws ClassNotFoundException, SQLException;
    
    public int getMinorCategoriesID(String mainname, String propertyname) throws ClassNotFoundException, SQLException;
    
    public ArrayList<Products> searchProduct(int i, String propertyname) throws ClassNotFoundException, SQLException;
    
    public ArrayList<Products> showAllProducts(String propertyname) throws SQLException, ClassNotFoundException;
        
    public void editProduct(int id, Products product, String propertyname) throws SQLException, ClassNotFoundException;
    
    public String deleteProduct(int id, String propertyname) throws SQLException, ClassNotFoundException;
    
    public ArrayList<Products> showSearchedProduct(String search, String attribute, String propertyname) throws SQLException, ClassNotFoundException;
    
    public ArrayList<Products> dbDownload(String propertyname) throws SQLException, ClassNotFoundException;
    
    public String bulkEditPublished(String attribute, boolean changeValue, ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException;
    
    public String bulkEditProducts(String attribute, String changeValue, ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException;
}
