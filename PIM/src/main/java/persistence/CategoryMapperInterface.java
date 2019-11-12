package persistence;

import java.sql.SQLException;

/**
 *
 * @author Malthe
 */
public interface CategoryMapperInterface {
    
    public void addMainCategory (String category);
    
    public int getMainMaxID()throws ClassNotFoundException, SQLException;
    
    
}
