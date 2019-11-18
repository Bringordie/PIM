package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Categories;
import static persistence.DBConnection.getConnection;

/**
 *
 * @author Malthe
 */
public class CategoryMapper implements CategoryMapperInterface {

    @Override
    public void addMainCategory(String category, String propertyname) {
        String sql = "INSERT INTO mainCategories (mainCategoryName) VALUES (?)";
        try {

            PreparedStatement statement = getConnection(propertyname).prepareStatement(sql);
            statement.setString(1, category);
            statement.executeUpdate();
            //int id = getMainMaxID();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoryMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addMinorCategory(String category, String propertyname) {
        String sql = "INSERT INTO minorCategories (minorCategoryName) VALUES (?)";
        try {

            PreparedStatement statement = getConnection(propertyname).prepareStatement(sql);
            statement.setString(1, category);
            statement.executeUpdate();
            //int id = getMainMaxID();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoryMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editMainCategory(int categoryInt, String categoryStr, String propertyname) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE mainCategories SET mainCategoryName = ? WHERE categoryid =" + categoryInt;

        PreparedStatement statement = getConnection(propertyname).prepareStatement(sql);
        statement.setString(1, categoryStr);
        statement.executeUpdate();
    }

    @Override
    public void editMinorCategory(int categoryInt, String categoryStr, String propertyname) throws ClassNotFoundException, SQLException {

        String sql = "UPDATE minorCategories SET minorCategoryName = ? WHERE categoryid =" + categoryInt;

        PreparedStatement statement = getConnection(propertyname).prepareStatement(sql);
        statement.setString(1, categoryStr);
        statement.executeUpdate();
    }

    @Override
    public ArrayList<Categories> getMinorValuesFromDB(String propertyname) throws SQLException, ClassNotFoundException {
        String minorName = "";
        int minorID;
        ArrayList<Categories> hashminor = new ArrayList();
        String sql = "select * from minorCategories ORDER BY minorCategoryName ASC";
        ResultSet result = getConnection(propertyname).prepareStatement(sql).executeQuery();

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
    public ArrayList<Categories> getMainValuesFromDB(String propertyname) throws SQLException, ClassNotFoundException {
        String mainName = "";
        int mainID;
        //HashSet<String> hashmain = new HashSet();
        ArrayList<Categories> hashmain = new ArrayList();
        String sql = "select * from mainCategories ORDER BY mainCategoryName ASC";
        ResultSet result = getConnection(propertyname).prepareStatement(sql).executeQuery();

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

    //NEW
    
    /**
     *
     * @author - Bringordie - Frederik Braagaard
     */
    @Override
    public int getMinorValuesFromDBFile(String s, String propertyname) throws SQLException, ClassNotFoundException {
        String minorName = "";
        int minorID;
        int resturnMinorID = 0;
        String sql = "select * from minorCategories where minorCategoryName = '" + s + "'";
        ResultSet result = getConnection(propertyname).prepareStatement(sql).executeQuery();

        try {
            while (result.next()) {
                minorID = result.getInt(1);
                minorName = result.getString(2);
                if (minorName.contains(s)) {
                    resturnMinorID = minorID;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resturnMinorID;
    }

    /**
     *
     * @author - Bringordie - Frederik Braagaard
     */
    @Override
    public int getMainValuesFromDBFile(String s, String propertyname) throws SQLException, ClassNotFoundException {
        String mainName = "";
        int mainID;
        int resturnMainID = 0;
        String sql = "select * from maincategories where mainCategoryName ='" + s + "'";
        ResultSet result = getConnection(propertyname).prepareStatement(sql).executeQuery();

        try {
            while (result.next()) {
                mainID = result.getInt(1);
                mainName = result.getString(2);
                if (mainName.contains(s)) {
                    resturnMainID = mainID;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resturnMainID;
    }

    /**
     *
     * @author - Bringordie - Frederik Braagaard
     */
    @Override
    public int createMainIDInDB(String s, String propertyname) throws SQLException, ClassNotFoundException {
        int newlycreatedID = 0;
        String sqlGetID = "select COUNT(mainCategoryName) from mainCategories";
        ResultSet result = getConnection(propertyname).prepareStatement(sqlGetID).executeQuery();

        try {
            while (result.next()) {
                newlycreatedID = result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "INSERT INTO mainCategories(mainCategoryName)"
                    + "VALUES(?)";
            PreparedStatement statement = getConnection(propertyname).prepareStatement(sql);
            statement.setString(1, s);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ++newlycreatedID;
    }

    /**
     *
     * @author - Bringordie - Frederik Braagaard
     */
    @Override
    public int createMinorIDInDB(String s, String propertyname) throws SQLException, ClassNotFoundException {
        int newlycreatedID = 0;
        String sqlGetID = "select COUNT(minorCategoryName) from minorCategories";
        ResultSet result = getConnection(propertyname).prepareStatement(sqlGetID).executeQuery();

        try {
            while (result.next()) {
                newlycreatedID = result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "INSERT INTO minorCategories(minorCategoryName)"
                    + "VALUES(?)";
            PreparedStatement statement = getConnection(propertyname).prepareStatement(sql);
            statement.setString(1, s);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ++newlycreatedID;
    }

    /**
     *
     * @author - Bringordie - Frederik Braagaard
     */
    @Override
    public void checkOrCreateLinkminormain(int mainid, int minorid, String propertyname) throws SQLException, ClassNotFoundException {
        int returncall = 0;
        String sqlGetID = "SELECT COUNT(mainid) FROM linkminormain WHERE mainid = " + mainid + " AND minorid = " + minorid;
        ResultSet result = getConnection(propertyname).prepareStatement(sqlGetID).executeQuery();

        try {
            while (result.next()) {
                returncall = result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (returncall == 0) {

            try {
                String sql = "insert into linkMinorMain (mainid, minorid) values (?, ?)";
                PreparedStatement statement = getConnection(propertyname).prepareStatement(sql);
                statement.setInt(1, mainid);
                statement.setInt(2, minorid);
                statement.executeUpdate();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
        @Override
    public void deleteMainCategory(int category, String propertyname) throws ClassNotFoundException, SQLException {
        String sql1 = "DELETE FROM linkminormain WHERE mainid=" + category;
        String sql2 = "DELETE FROM mainCategories WHERE categoryid=" + category;
        
        getConnection(propertyname).prepareStatement(sql1).executeUpdate();
        getConnection(propertyname).prepareStatement(sql2).executeUpdate();
        
    }

    @Override
    public void deleteMinorCategory(int category, String propertyname) throws ClassNotFoundException, SQLException {
        String sql1 = "DELETE FROM linkminormain WHERE minorid=" + category;
        String sql2 = "DELETE FROM minorCategories WHERE categoryid=" + category;
        
        getConnection(propertyname).prepareStatement(sql1).executeUpdate();
        getConnection(propertyname).prepareStatement(sql2).executeUpdate();
        
    }

}
