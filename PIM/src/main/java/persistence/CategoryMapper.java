package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

}
