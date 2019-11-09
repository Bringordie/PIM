package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import logic.Products;


public interface Facade { 
    
    public void reqisterProducts(ArrayList<Products> products) throws SQLException, ClassNotFoundException;
    
    
}
