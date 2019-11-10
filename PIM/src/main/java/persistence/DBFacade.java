package persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import logic.Products;
import static persistence.DBConnection.getConnection;

public class DBFacade implements Facade {

    /**
     * @author Bringordie - Frederik Braagaard
     * @param products - Takes an ArrayList of products which is then added to
     * DB.
     *
     */
    @Override
    public void reqisterProductsJson(ArrayList<Products> products) throws SQLException, ClassNotFoundException {

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

    /**
     * @author Bringordie - Frederik Braagaard
     * @param dataHolder - takes a Vector and reads a file.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void saveToDatabaseExcel(Vector dataHolder) throws SQLException, ClassNotFoundException {
        String ProductID;
        String ProductName;
        String ProductNameDescription;
        String ProductDescription;
        String CompanyName;
        String Price;
        String Quantity;
        String PictureName;
        String PublishedStatus;
        String MinorCategory;
        String MainCategory;

        //for (Iterator iterator = dataHolder.iterator(); iterator.hasNext();) {
        Iterator iterator = dataHolder.iterator();
        if (iterator.hasNext()) {
            iterator.next();
        }

        while (iterator.hasNext()) {
            List list = (List) iterator.next();
            iterator.hasNext();
            ProductID = list.get(0).toString();
            ProductName = list.get(1).toString();
            //Might want to consider making an extra method to make it nicer.
            if (list.get(2).toString() == "") {
                ProductNameDescription = null;
            } else {
                ProductNameDescription = list.get(2).toString();
            }
            //Might want to consider making an extra method to make it nicer.
            if (list.get(3).toString() == "") {
                ProductDescription = null;
            } else {
                ProductDescription = list.get(3).toString();
            }
            //Might want to consider making an extra method to make it nicer.
            if (list.get(4).toString() == "") {
                CompanyName = null;
            } else {
                CompanyName = list.get(4).toString();
            }
            //Might want to consider making an extra method to make it nicer.
            if (list.get(5).toString() == "") {
                Price = null;
            } else {
                Price = list.get(5).toString();
            }

            Quantity = list.get(6).toString();
            PictureName = list.get(7).toString();
            PublishedStatus = list.get(8).toString();
            MinorCategory = list.get(9).toString();
            MainCategory = list.get(10).toString();

            try {
                String sql = "INSERT INTO products(productid, name, nameDescription, "
                        + "description, companyName, price, quantity, pictureName, "
                        + "publishedStatus, minorCategory, mainCategory)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = getConnection().prepareStatement(sql);
                statement.setString(1, ProductID);
                statement.setString(2, ProductName);
                statement.setString(3, ProductNameDescription);
                statement.setString(4, ProductDescription);
                statement.setString(5, CompanyName);
                statement.setDouble(6, Double.parseDouble(Price));
                statement.setString(7, Quantity);
                statement.setString(8, PictureName);
                statement.setString(9, PublishedStatus);
                statement.setString(10, MinorCategory);
                statement.setString(11, MainCategory);
                statement.executeUpdate();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
