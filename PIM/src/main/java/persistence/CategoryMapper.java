package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Categories;
import persistence.DBConnection;
import static persistence.DBConnection.getConnection;

/**
 *
 * @author Malthe
 */
public class CategoryMapper implements CategoryMapperInterface {

    @Override
    public void addMainCategory(String category) {
        String sql = "INSERT INTO mainCategories (mainCategoryName) VALUES (?)";
        try {

            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, category);
            statement.executeUpdate();
            //int id = getMainMaxID();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoryMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void addMinorCategory(String category) {
        String sql = "INSERT INTO minorCategories (minorCategoryName) VALUES (?)";
        try {

            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, category);
            statement.executeUpdate();
            //int id = getMainMaxID();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoryMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getMainMaxID() throws ClassNotFoundException, SQLException {
        int countTotal = 0;
        String sql = "SELECT COUNT (categoryid) from mainCategories";

        boolean returnAnswer = true;
        ResultSet result = getConnection().prepareStatement(sql).executeQuery();
        try {
            while (result.next()) {
                int getTotal = result.getInt(1);
                countTotal = getTotal;
                countTotal++;

            }
        } catch (SQLException ex) {
            System.err.println("SQException Error");
        }
        return countTotal;

    }

    @Override
    public void deleteMainCategory(int category) throws ClassNotFoundException, SQLException {
        String sql1 = "DELETE FROM linkminormain WHERE mainid=" + category;
        String sql2 = "DELETE FROM mainCategories WHERE categoryid=" + category;
        
        getConnection().prepareStatement(sql1).executeUpdate();
        getConnection().prepareStatement(sql2).executeUpdate();
        
    }

    @Override
    public void deleteMinorCategory(int category) throws ClassNotFoundException, SQLException {
        String sql1 = "DELETE FROM linkminormain WHERE minorid=" + category;
        String sql2 = "DELETE FROM minorCategories WHERE categoryid=" + category;
        
        getConnection().prepareStatement(sql1).executeUpdate();
        getConnection().prepareStatement(sql2).executeUpdate();
        
    }

    @Override
    public void editMainCategory(int categoryInt, String categoryStr) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE mainCategories SET mainCategoryName = ? WHERE categoryid =" + categoryInt;
        
        PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, categoryStr);
            statement.executeUpdate();
    }

    @Override
    public void editMinorCategory(int categoryInt, String categoryStr) throws ClassNotFoundException, SQLException {
        
        String sql = "UPDATE minorCategories SET minorCategoryName = ? WHERE categoryid =" + categoryInt;
        
        PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, categoryStr);
            statement.executeUpdate();
    }
    
    @Override
    public HashSet<Categories> getMinorValuesFromDB() throws SQLException, ClassNotFoundException{
        String minorName = "";
        int minorID;
        HashSet<Categories> hashminor = new HashSet();
        String sql = "select * from minorCategories";
        ResultSet result = getConnection().prepareStatement(sql).executeQuery();
        
        try {
            while (result.next()) {
                minorID = result.getInt(1);
                //hashminor.add(minorName);
                minorName = result.getString(2);
                Categories test = new Categories(minorID, minorName);
                hashminor.add(test);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashminor;
    }
    
    @Override
    public HashSet<Categories> getMainValuesFromDB() throws SQLException, ClassNotFoundException{
        String mainName = "";
        int mainID;
        //HashSet<String> hashmain = new HashSet();
        HashSet<Categories> hashmain = new HashSet();
        String sql = "select * from mainCategories";
        ResultSet result = getConnection().prepareStatement(sql).executeQuery();
        
        try {
            while (result.next()) {
                mainID = result.getInt(1);
                mainName = result.getString(2);
                Categories test = new Categories(mainID, mainName);
                hashmain.add(test);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashmain;
    }


}
