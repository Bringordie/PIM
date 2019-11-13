package persistence;

import java.sql.SQLException;
import java.util.HashSet;
import logic.Categories;

/**
 *
 * @author Malthe
 */
public interface CategoryMapperInterface {
    
    public void addMainCategory (String category);
    
    public void addMinorCategory (String category);
    
    public int getMainMaxID() throws ClassNotFoundException, SQLException;
    
    public void deleteMainCategory (int category) throws ClassNotFoundException, SQLException;
    
    public void deleteMinorCategory (int category) throws ClassNotFoundException, SQLException;
    
    public void editMainCategory (int categoryInt, String categoryStr) throws ClassNotFoundException, SQLException;
    
    public void editMinorCategory (int categoryInt, String categoryStr) throws ClassNotFoundException, SQLException;
    
    public HashSet<Categories> getMinorValuesFromDB() throws SQLException, ClassNotFoundException;
    
    public HashSet<Categories> getMainValuesFromDB() throws SQLException, ClassNotFoundException;
    
}
