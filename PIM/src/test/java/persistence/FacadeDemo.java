package persistence;

import persistence.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import logic.Categories;
import logic.Products;



public interface FacadeDemo { 
    
    public void reqisterProductsJson(ArrayList<Products> products) throws SQLException, ClassNotFoundException;
    
    public void saveToDatabaseExcel(Vector dataHolder) throws SQLException, ClassNotFoundException;
    
    public int getMinorValuesFromDB(String s) throws SQLException, ClassNotFoundException;
    
    public int getMainValuesFromDB(String s) throws SQLException, ClassNotFoundException;
    
    public int createMainIDInDB(String s) throws SQLException, ClassNotFoundException;
    
    public int createMinorIDInDB(String s) throws SQLException, ClassNotFoundException;
    
    public boolean checkIfProductExists(String s) throws SQLException, ClassNotFoundException;
    
    public void excelInsertToDB(List list) throws ClassNotFoundException, NumberFormatException, SQLException;
    
    public void excelUpdateToDB(List list, String productid) throws ClassNotFoundException, NumberFormatException, SQLException;
    
}
