package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import logic.Categories;


public interface CategoryMapperInterface {
    
    public String addMainCategory (String category, String propertyname) throws ClassNotFoundException, SQLException;
    
    public String addMinorCategory (String category, String propertyname) throws ClassNotFoundException, SQLException;
        
    public void deleteMainCategory (int category, String propertyname) throws ClassNotFoundException, SQLException;
    
    public void deleteMinorCategory (int category, String propertyname) throws ClassNotFoundException, SQLException;
    
    public void editMainCategory (int categoryInt, String categoryStr, String propertyname) throws ClassNotFoundException, SQLException;
    
    public void editMinorCategory (int categoryInt, String categoryStr, String propertyname) throws ClassNotFoundException, SQLException;
    
    public ArrayList<Categories> getMinorValuesFromDB(String propertyname) throws SQLException, ClassNotFoundException;
    
    public ArrayList<Categories> getMainValuesFromDB(String propertyname) throws SQLException, ClassNotFoundException;
        
    public int getMinorValuesFromDBFile(String minorname, String propertyname) throws SQLException, ClassNotFoundException;
    
    public int getMainValuesFromDBFile(String mainname, String propertyname) throws SQLException, ClassNotFoundException;
    
    public int createMainIDInDB(String mainname, String propertyname) throws SQLException, ClassNotFoundException;
    
    public int createMinorIDInDB(String minorname, String propertyname) throws SQLException, ClassNotFoundException;
    
    public void checkOrCreateLinkminormain(int mainid, int minorid, String propertyname) throws SQLException, ClassNotFoundException;
    
    public Boolean checkMainCategory(String category, String propertyname) throws SQLException, ClassNotFoundException;
    
    public Boolean checkMinorCategory(String category, String propertyname) throws SQLException, ClassNotFoundException;
}
