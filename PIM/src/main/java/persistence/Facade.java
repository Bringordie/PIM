package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import logic.Categories;
import logic.Products;



public interface Facade { 
    
    public void reqisterProductsJson(ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException;
    
    public void saveToDatabaseExcel(Vector dataHolder, String propertyname) throws SQLException, ClassNotFoundException;
    
    public int getMinorValuesFromDB(String s, String propertyname) throws SQLException, ClassNotFoundException;
    
    public int getMainValuesFromDB(String s, String propertyname) throws SQLException, ClassNotFoundException;
    
    public int createMainIDInDB(String s, String propertyname) throws SQLException, ClassNotFoundException;
    
    public int createMinorIDInDB(String s, String propertyname) throws SQLException, ClassNotFoundException;
    
    public boolean checkIfProductExists(String s, String propertyname) throws SQLException, ClassNotFoundException;
    
    public void excelInsertToDB(List list, String propertyname) throws ClassNotFoundException, NumberFormatException, SQLException;
    
    public void excelUpdateToDB(List list, String productid, String propertyname) throws ClassNotFoundException, NumberFormatException, SQLException;
}
