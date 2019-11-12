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
    
    public void getUniqueMainValuesFromExcel(Vector dataHolder) throws SQLException, ClassNotFoundException;
    
    public void getUniqueMinorValuesFromExcel(Vector dataHolder) throws SQLException, ClassNotFoundException;
    
    public void getUniqueMainValuesFromJson(ArrayList<Products> products) throws SQLException, ClassNotFoundException;
    
    public void getUniqueMinorValuesFromJSON(ArrayList<Products> products) throws SQLException, ClassNotFoundException;
    
    public HashSet<Categories> getMinorValuesFromDB() throws SQLException, ClassNotFoundException;
    
    public HashSet<Categories> getMainValuesFromDB() throws SQLException, ClassNotFoundException;
    
}
