package persistence;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Categories;
import static persistence.DBConnection.getConnection;

public class CategoryMapper implements CategoryMapperInterface {

    /**
     *
     * @author - Malthe
     */
    @Override
    public String addMainCategory(String category, String propertyname) throws ClassNotFoundException, SQLException, IOException, IOException {
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

    /**
     *
     * @author - Malthe
     */
    @Override
    public String addMinorCategory(String category, String propertyname) throws ClassNotFoundException, SQLException, IOException {
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

    /**
     *
     * @author - Malthe
     */
    @Override
    public void editMainCategory(int categoryInt, String categoryStr, String propertyname) throws ClassNotFoundException, SQLException, IOException {
        String sql = "UPDATE mainCategories SET mainCategoryName = ? WHERE categoryid =" + categoryInt;

        PreparedStatement statement = getConnection(propertyname).prepareStatement(sql);
        statement.setString(1, categoryStr);
        statement.executeUpdate();
    }

    /**
     *
     * @author - Malthe
     */
    @Override
    public void editMinorCategory(int categoryInt, String categoryStr, String propertyname) throws ClassNotFoundException, SQLException, IOException {

        String sql = "UPDATE minorCategories SET minorCategoryName = ? WHERE categoryid =" + categoryInt;

        PreparedStatement statement = getConnection(propertyname).prepareStatement(sql);
        statement.setString(1, categoryStr);
        statement.executeUpdate();
    }

    /**
     *
     * Used for getting all the minor categories in an ascending order for a
     * more pleasing view for the user when they see the table with all the
     * different categories that they can choose from.
     *
     * @author - Bringordie - Frederik Braagaard
     * @param propertyname - for db connection
     * @return - returns all the minor values in an ascending order.
     */
    @Override
    public ArrayList<Categories> getMinorValuesFromDB(String propertyname) throws ClassNotFoundException, SQLException, IOException {
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

    /**
     *
     * Used for getting all the main categories in an ascending order for a more
     * pleasing view for the user when they see the table with all the different
     * categories that they can choose from.
     *
     * @author - Bringordie - Frederik Braagaard
     * @param propertyname - for db connection
     * @return - returns all the main values in an ascending order.
     */
    @Override
    public ArrayList<Categories> getMainValuesFromDB(String propertyname) throws ClassNotFoundException, SQLException, IOException {
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

    /**
     *
     * Used for checking if a minor value already exists in the db. If it
     * doesn't exist the value 0 will be given back and the upload knows it has
     * to create the category.
     *
     * @author - Bringordie - Frederik Braagaard
     * @param minorname - category minorname
     * @param propertyname - for db connection
     * @return returns the ID of the matching name
     */
    @Override
    public int getMinorValuesFromDBFile(String minorname, String propertyname) throws ClassNotFoundException, SQLException, IOException {
        String minorName = "";
        int minorID;
        int resturnMinorID = 0;
        String sql = "select * from minorCategories where minorCategoryName = '" + minorname + "'";
        ResultSet result = getConnection(propertyname).prepareStatement(sql).executeQuery();

        try {
            while (result.next()) {
                minorID = result.getInt(1);
                minorName = result.getString(2);
                if (minorName.contains(minorname)) {
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
     * Used for checking if a main value already exists in the db. If it doesn't
     * exist the value 0 will be given back and the upload knows it has to
     * create the category.
     *
     * @author - Bringordie - Frederik Braagaard
     * @param mainname - category mainname
     * @param propertyname - for db connection
     * @return returns the ID of the matching name
     */
    @Override
    public int getMainValuesFromDBFile(String mainname, String propertyname) throws ClassNotFoundException, SQLException, IOException {
        String mainName = "";
        int mainID;
        int resturnMainID = 0;
        String sql = "select * from maincategories where mainCategoryName ='" + mainname + "'";
        ResultSet result = getConnection(propertyname).prepareStatement(sql).executeQuery();

        try {
            while (result.next()) {
                mainID = result.getInt(1);
                mainName = result.getString(2);
                if (mainName.contains(mainname)) {
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
     * When adding a product we must know if the category has to be created what
     * mainid the product should have. This method is used for getting the count
     * of all maincategories and once it gets the return value it knows what is
     * next.
     *
     * @author - Bringordie - Frederik Braagaard
     * @param mainname - category mainname
     * @param propertyname - for db connection
     * @return returns the ID value of the newly created category.
     */
    @Override
    public int createMainIDInDB(String mainname, String propertyname) throws ClassNotFoundException, SQLException, IOException {
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
            statement.setString(1, mainname);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ++newlycreatedID;
    }

    /**
     *
     * When adding a product we must know if the category has to be created what
     * minorid the product should have. This method is used for getting the
     * count of all minorcategories and once it gets the return value it knows
     * what is next.
     *
     * @author - Bringordie - Frederik Braagaard
     * @param minorname - category minorname
     * @param propertyname - for db connection
     * @return returns the ID value of the newly created category.
     */
    @Override
    public int createMinorIDInDB(String minorname, String propertyname) throws ClassNotFoundException, SQLException, IOException {
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
            statement.setString(1, minorname);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ++newlycreatedID;
    }

    /**
     *
     * Checked if a link has been created between a minor and main category. If
     * a link doesn't already exists a link is created in DB.
     *
     * @author - Bringordie - Frederik Braagaard
     * @param mainid - category mainid
     * @param minorid - category minorid
     * @param propertyname - for db connection
     */
    @Override
    public void checkOrCreateLinkminormain(int mainid, int minorid, String propertyname) throws ClassNotFoundException, SQLException, IOException {
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

    /**
     *
     * @author - Malthe
     */
    @Override
    public void deleteMainCategory(int category, String propertyname) throws ClassNotFoundException, SQLException, IOException {
        String sql1 = "update products set publishedStatus = 0 where mainCategory =" + category;
        String sql2 = "update products set mainCategory = NULL where mainCategory =" + category;
        String sql3 = "DELETE FROM linkminormain WHERE mainid=" + category;
        String sql4 = "DELETE FROM mainCategories WHERE categoryid=" + category;

        getConnection(propertyname).prepareStatement(sql1).executeUpdate();
        getConnection(propertyname).prepareStatement(sql2).executeUpdate();
        getConnection(propertyname).prepareStatement(sql3).executeUpdate();
        getConnection(propertyname).prepareStatement(sql4).executeUpdate();

    }

    /**
     *
     * @author - Malthe
     */
    @Override
    public void deleteMinorCategory(int category, String propertyname) throws ClassNotFoundException, SQLException, IOException {
        String sql1 = "update products set publishedStatus = 0 where minorCategory =" + category;
        String sql2 = "update products set minorCategory = NULL where minorCategory =" + category;
        String sql3 = "DELETE FROM linkminormain WHERE minorid=" + category;
        String sql4 = "DELETE FROM minorCategories WHERE categoryid=" + category;

        getConnection(propertyname).prepareStatement(sql1).executeUpdate();
        getConnection(propertyname).prepareStatement(sql2).executeUpdate();
        getConnection(propertyname).prepareStatement(sql3).executeUpdate();
        getConnection(propertyname).prepareStatement(sql4).executeUpdate();

    }

    /**
     *
     * @author - Malthe
     */
    @Override
    public Boolean checkMainCategory(String category, String propertyname) throws ClassNotFoundException, SQLException, IOException {
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

    /**
     *
     * @author - Malthe
     */
    @Override
    public Boolean checkMinorCategory(String category, String propertyname) throws ClassNotFoundException, SQLException, IOException {
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

    /**
     *
     * @author - Bringordie - Frederik Braagaard
     * @param propertyname - for db connection
     */
   @Override
    public List<Map<Object, Object>> chartMinorCategory(String propertyname) throws ClassNotFoundException, SQLException, IOException {
        HashMap<Object, Object> map = null;
        List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
        int total = getMinorAmount(propertyname);
        String sql = "SELECT minorcategories.minorCategoryName, COUNT(*)"
                + " FROM products"
                + " inner join minorcategories on products.minorCategory = minorcategories.categoryid"
                + " GROUP BY minorcategories.minorCategoryName"
                + " HAVING COUNT(*) > 0"
                + " ORDER BY minorcategories.minorCategoryName ASC";
        ResultSet result = getConnection(propertyname).prepareStatement(sql).executeQuery();

        try {
            while (result.next()) {
                map = new HashMap<Object, Object>();
                map.put("label", String.valueOf(result.getString(1)));
                map.put("y", String.valueOf((result.getInt(2) * 100) / total));
                list.add(map);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    /**
     *
     * @author - Bringordie - Frederik Braagaard
     * @param propertyname - for db connection
     */
    @Override
    public int getMinorAmount(String propertyname) throws ClassNotFoundException, SQLException, IOException {
        int total = 0;
        String sql = "SELECT minorcategories.minorCategoryName, COUNT(*)"
                + " FROM products"
                + " inner join minorcategories on products.minorCategory = minorcategories.categoryid"
                + " GROUP BY minorcategories.minorCategoryName"
                + " HAVING COUNT(*) > 0"
                + " ORDER BY minorcategories.minorCategoryName ASC";
        ResultSet result = getConnection(propertyname).prepareStatement(sql).executeQuery();
        try {
            while (result.next()) {
                total += result.getInt(2);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return total;
    }

    /**
     *
     * @author - Bringordie - Frederik Braagaard
     * @param propertyname - for db connection
     */
    @Override
    public List<Map<Object, Object>> chartMainCategory(String propertyname) throws ClassNotFoundException, SQLException, IOException {
        HashMap<Object, Object> map = null;
        List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
        int total = getMainAmount(propertyname);
        String sql = "SELECT maincategories.mainCategoryName, COUNT(*)"
                + " FROM products "
                + " inner join maincategories on products.mainCategory = maincategories.categoryid"
                + " GROUP BY maincategories.mainCategoryName"
                + " HAVING COUNT(*) > 0"
                + " ORDER BY maincategories.mainCategoryName ASC";
        ResultSet result = getConnection(propertyname).prepareStatement(sql).executeQuery();

        try {
            while (result.next()) {
                map = new HashMap<Object, Object>();
                map.put("label", String.valueOf(result.getString(1)));
                map.put("y", String.valueOf((result.getInt(2) * 100) / total));
                list.add(map);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    /**
     *
     * @author - Bringordie - Frederik Braagaard
     * @param propertyname - for db connection
     */
    @Override
    public int getMainAmount(String propertyname) throws ClassNotFoundException, SQLException, IOException {
        int total = 0;
        String sql = "SELECT maincategories.mainCategoryName, COUNT(*)"
                + " FROM products "
                + " inner join maincategories on products.mainCategory = maincategories.categoryid"
                + " GROUP BY maincategories.mainCategoryName"
                + " HAVING COUNT(*) > 0"
                + " ORDER BY maincategories.mainCategoryName ASC";
        ResultSet result = getConnection(propertyname).prepareStatement(sql).executeQuery();
        try {
            while (result.next()) {
                total += result.getInt(2);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return total;
    }

}
