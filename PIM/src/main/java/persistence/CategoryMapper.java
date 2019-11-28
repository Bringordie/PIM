package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public String addMainCategory(String category, String propertyname) throws ClassNotFoundException, SQLException {
        String returnvalue = "";
        String sql = "INSERT INTO mainCategories (mainCategoryName) VALUES (?)";
        Boolean booleanNameCheck = checkMainCategory(category, propertyname);
        if (booleanNameCheck == false) {
            returnvalue = "Category added!";
        
        try {

            PreparedStatement statement = getConnection(propertyname).prepareStatement(sql);
            statement.setString(1, category);
            statement.executeUpdate();
            

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoryMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
            returnvalue = "Category already exists!"; 
        }
        return returnvalue;
    }

    @Override
    public String addMinorCategory(String category, String propertyname) throws ClassNotFoundException, SQLException {
        String returnvalue = "";
        String sql = "INSERT INTO minorCategories (minorCategoryName) VALUES (?)";
        Boolean booleanNameCheck = checkMinorCategory(category, propertyname);
        if (booleanNameCheck == false) {
            returnvalue = "Category added!";
        try {

            PreparedStatement statement = getConnection(propertyname).prepareStatement(sql);
            statement.setString(1, category);
            statement.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoryMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
            returnvalue = "Category already exists!"; 
        }
        return returnvalue;
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
        String sql1 = "update products set publishedStatus = 0 where mainCategory =" + category;
        String sql2 = "update products set mainCategory = NULL where mainCategory =" + category;
        String sql3 = "DELETE FROM linkminormain WHERE mainid=" + category;
        String sql4 = "DELETE FROM mainCategories WHERE categoryid=" + category;
        
        getConnection(propertyname).prepareStatement(sql1).executeUpdate();
        getConnection(propertyname).prepareStatement(sql2).executeUpdate();
        getConnection(propertyname).prepareStatement(sql3).executeUpdate();
        getConnection(propertyname).prepareStatement(sql4).executeUpdate();
        
    }

    @Override
    public void deleteMinorCategory(int category, String propertyname) throws ClassNotFoundException, SQLException {
        String sql1 = "update products set publishedStatus = 0 where minorCategory =" + category;
        String sql2 = "update products set minorCategory = NULL where minorCategory =" + category;
        String sql3 = "DELETE FROM linkminormain WHERE minorid=" + category;
        String sql4 = "DELETE FROM minorCategories WHERE categoryid=" + category;
        
        getConnection(propertyname).prepareStatement(sql1).executeUpdate();
        getConnection(propertyname).prepareStatement(sql2).executeUpdate();
        getConnection(propertyname).prepareStatement(sql3).executeUpdate();
        getConnection(propertyname).prepareStatement(sql4).executeUpdate();
        
    }

    @Override
    public Boolean checkMainCategory(String category, String propertyname) throws SQLException, ClassNotFoundException {
        Boolean returnvalue = false;
        int tempholder;
        String sql = "select COUNT(categoryid) FROM mainCategories WHERE mainCategoryName = '" + category + "'";
        ResultSet result = getConnection(propertyname).prepareStatement(sql).executeQuery();
        
        try {
            while (result.next()) {
                tempholder = result.getInt(1);
                if (tempholder == 0) {
                    returnvalue = false;
                } else {
                    returnvalue = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return returnvalue;
    }

    @Override
    public Boolean checkMinorCategory(String category, String propertyname) throws SQLException, ClassNotFoundException {
        Boolean returnvalue = false;
        int tempholder;
        String sql = "select COUNT(categoryid) FROM minorCategories WHERE minorCategoryName = '" + category + "'";
        ResultSet result = getConnection(propertyname).prepareStatement(sql).executeQuery();
        
        try {
            while (result.next()) {
                tempholder = result.getInt(1);
                if (tempholder == 0) {
                    returnvalue = false;
                } else {
                    returnvalue = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return returnvalue;
    }

}
