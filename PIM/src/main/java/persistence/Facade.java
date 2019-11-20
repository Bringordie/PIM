package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import logic.Categories;
import logic.Products;



public interface Facade { 
    
    public void jsonInsertOrUpdateToDB(ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException;
    
    public void excelInsertOrUpdateToDB(ArrayList<Products> product, String propertyname) throws SQLException, ClassNotFoundException;
    
    public String addProduct(ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException;
    
    public void addMainCategory (String category, String propertyname);
    
    public void addMinorCategory (String category, String propertyname);
    
    public void deleteMainCategory (int category, String propertyname) throws ClassNotFoundException, SQLException;
    
    public void deleteMinorCategory (int category, String propertyname) throws ClassNotFoundException, SQLException;
    
    public void editMainCategory (int categoryInt, String categoryStr, String propertyname) throws ClassNotFoundException, SQLException;
    
    public void editMinorCategory (int categoryInt, String categoryStr, String propertyname) throws ClassNotFoundException, SQLException;
    
    public ArrayList<Categories> getMainCategories (String propertyname) throws ClassNotFoundException, SQLException;
    
    public ArrayList<Categories> getMinorCategories (String propertyname) throws ClassNotFoundException, SQLException;
    
    public ArrayList<Products> searchProduct(int i, String propertyname) throws ClassNotFoundException, SQLException;
    
    public ArrayList<Products> showAllProducts(String propertyname) throws SQLException, ClassNotFoundException;
}
