package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import logic.Categories;
import logic.Products;


public interface ProductMapperInterface {
    
    public void jsonInsertOrUpdateToDB(ArrayList<Products> list, String propertyname) throws SQLException, ClassNotFoundException;
    
    public void excelInsertOrUpdateToDB(ArrayList<Products> list, String propertyname) throws ClassNotFoundException, NumberFormatException, SQLException;
    
    public boolean checkIfProductExists(String s, String propertyname) throws SQLException, ClassNotFoundException;
    
    public void addProduct(ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException;
    
    public void deleteProduct(int ProductID) throws SQLException, ClassNotFoundException;
}
