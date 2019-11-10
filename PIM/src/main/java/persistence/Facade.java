package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import logic.Products;


public interface Facade { 
    
    public void reqisterProductsJson(ArrayList<Products> products) throws SQLException, ClassNotFoundException;
    
    public void saveToDatabaseExcel(Vector dataHolder) throws SQLException, ClassNotFoundException;
    
}
