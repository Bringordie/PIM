package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;
import logic.Categories;
import logic.Products;



public interface Facade { 
    
    public void reqisterProductsJson(ArrayList<Products> products) throws SQLException, ClassNotFoundException;
    
    public void saveToDatabaseExcel(Vector dataHolder) throws SQLException, ClassNotFoundException;
    
    public int getMinorValuesFromDB(String s) throws SQLException, ClassNotFoundException;
    
    public int getMainValuesFromDB(String s) throws SQLException, ClassNotFoundException;
    
    public int createMainIDInDB(String s) throws SQLException, ClassNotFoundException;
    
    public int createMinorIDInDB(String s) throws SQLException, ClassNotFoundException;
    
}
