package persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import logic.Products;
import static persistence.DBConnection.getConnection;


public class DBFacade implements Facade{

    @Override
    public void reqisterProducts(ArrayList<Products> products) throws SQLException, ClassNotFoundException {
        
        try {
            for (Products product : products) {
                String sql = "INSERT INTO products(productid, name, nameDescription, "
                        + "description, companyName, price, quantity, pictureName, "
                        + "publishedStatus, minorCategory, mainCategory)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            statement.setString(3, product.getDescription());
            statement.setString(4, product.getNameDescription());
            statement.setString(5, product.getCompanyName());
            statement.setDouble(6, product.getPrice());
            statement.setInt(7, product.getQty());
            statement.setString(8, product.getPictureName());
            statement.setBoolean(9, product.getPublishedStatus());
            statement.setInt(10, product.getMinorCategory());
            statement.setInt(11, product.getMainCategory());
            statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }


    

}
