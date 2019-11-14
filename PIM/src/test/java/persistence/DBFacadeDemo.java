package persistence;

import persistence.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Categories;
import logic.Products;
//import logic.Productsint;
import persistence.DBConnectionDemo;

public class DBFacadeDemo implements FacadeDemo {

    /**
     * @author Bringordie - Frederik Braagaard
     * @param products - Takes an ArrayList of products which is then added to
     * DB.
     *
     */
        @Override
    public void reqisterProductsJson(ArrayList<Products> products) throws SQLException, ClassNotFoundException {

        //TO DO
        try {
            for (Products product : products) {
                String sql = "INSERT INTO products(productid, name, nameDescription, "
                        + "description, companyName, price, quantity, pictureName, "
                        + "publishedStatus, minorCategory, mainCategory)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = DBConnectionDemo.getConnection().prepareStatement(sql);
                statement.setInt(1, product.getId());
                statement.setString(2, product.getName());
                statement.setString(3, product.getDescription());
                statement.setString(4, product.getNameDescription());
                statement.setString(5, product.getCompanyName());
                statement.setDouble(6, product.getPrice());
                statement.setInt(7, product.getQty());
                statement.setString(8, product.getPictureName());
                statement.setBoolean(9, product.getPublishedStatus());
                //TODO / FIX
                //statement.setInt(10, product.getMinorCategory());
                //statement.setInt(11, product.getMainCategory());
                //
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
        Iterator iterator = dataHolder.iterator();
        if (iterator.hasNext()) {
            iterator.next();
        }

        
        while (iterator.hasNext()) {
            List list = (List) iterator.next();
            iterator.hasNext();
            ProductID = list.get(0).toString();

            Boolean booleanIDCheck = checkIfProductExists(ProductID);
            if (booleanIDCheck != true) {
                excelInsertToDB(list);
            } else {
                excelUpdateToDB(list, ProductID);
            }
        }

    }

    @Override
    public void excelInsertToDB(List list) throws ClassNotFoundException, NumberFormatException, SQLException {
        String ProductID;
        String ProductName;
        String ProductNameDescription;
        String ProductDescription;
        String CompanyName;
        String Price;
        String Quantity;
        String PictureName;
        Boolean PublishedStatus;
        int MinorCategory = 0;
        int MainCategory = 0;
        
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
        //Checking minorvalue
        if (getMinorValuesFromDB(list.get(8).toString()) == 0) {
            int minorIDCreated = createMinorIDInDB(list.get(8).toString());
            MinorCategory = minorIDCreated;
        } else if (getMinorValuesFromDB(list.get(8).toString()) > 0) {
            int reuseIDCreated = getMinorValuesFromDB(list.get(8).toString());
            MinorCategory = reuseIDCreated;
        }
        //Checking mainvalue
        if (getMainValuesFromDB(list.get(9).toString()) == 0) {
            int mainIDCreated = createMainIDInDB(list.get(9).toString());
            MainCategory = mainIDCreated;
        } else if (getMainValuesFromDB(list.get(9).toString()) > 0) {
            int reuseIDCreated = getMainValuesFromDB(list.get(9).toString());
            MainCategory = reuseIDCreated;
        }
        //Requirements for publishing
        if (ProductID == null || ProductName == null || ProductNameDescription == null || ProductDescription == null) {
            PublishedStatus = false;
        } else {
            PublishedStatus = true;
        }
        try {
            String sql = "INSERT INTO products(productid, name, nameDescription, "
                    + "description, companyName, price, quantity, pictureName, "
                    + "publishedStatus, minorCategory, mainCategory)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = DBConnectionDemo.getConnection().prepareStatement(sql);
            statement.setString(1, ProductID);
            statement.setString(2, ProductName);
            statement.setString(3, ProductNameDescription);
            statement.setString(4, ProductDescription);
            statement.setString(5, CompanyName);
            statement.setDouble(6, Double.parseDouble(Price));
            statement.setString(7, Quantity);
            statement.setString(8, PictureName);
            statement.setBoolean(9, PublishedStatus);
            statement.setInt(10, MinorCategory);
            statement.setInt(11, MainCategory);
            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void excelUpdateToDB(List list, String productid) throws ClassNotFoundException, NumberFormatException, SQLException{
        String ProductID;
        String ProductName;
        String ProductNameDescription;
        String ProductDescription;
        String CompanyName;
        String Price;
        String Quantity;
        String PictureName;
        Boolean PublishedStatus;
        int MinorCategory = 0;
        int MainCategory = 0;
        
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
        //Checking minorvalue
        if (getMinorValuesFromDB(list.get(8).toString()) == 0) {
            int minorIDCreated = createMinorIDInDB(list.get(8).toString());
            MinorCategory = minorIDCreated;
        } else if (getMinorValuesFromDB(list.get(8).toString()) > 0) {
            int reuseIDCreated = getMinorValuesFromDB(list.get(8).toString());
            MinorCategory = reuseIDCreated;
        }
        //Checking mainvalue
        if (getMainValuesFromDB(list.get(9).toString()) == 0) {
            int mainIDCreated = createMainIDInDB(list.get(9).toString());
            MainCategory = mainIDCreated;
        } else if (getMainValuesFromDB(list.get(9).toString()) > 0) {
            int reuseIDCreated = getMainValuesFromDB(list.get(9).toString());
            MainCategory = reuseIDCreated;
        }
        //Requirements for publishing
        if (ProductID == null || ProductName == null || ProductNameDescription == null || ProductDescription == null) {
            PublishedStatus = false;
        } else {
            PublishedStatus = true;
        }
        try {
            String sql = "update products set productid = ?, name= ?, "
                    + "nameDescription= ?, description= ?, companyName= ?, "
                    + "price= ?, quantity= ?, pictureName = ?, "
                    + "publishedStatus= ?, minorCategory= ?, mainCategory= ? "
                    + "where productid ='"+ productid +"'";
            PreparedStatement statement = DBConnectionDemo.getConnection().prepareStatement(sql);
            statement.setString(1, ProductID);
            statement.setString(2, ProductName);
            statement.setString(3, ProductNameDescription);
            statement.setString(4, ProductDescription);
            statement.setString(5, CompanyName);
            statement.setDouble(6, Double.parseDouble(Price));
            statement.setString(7, Quantity);
            statement.setString(8, PictureName);
            statement.setBoolean(9, PublishedStatus);
            statement.setInt(10, MinorCategory);
            statement.setInt(11, MainCategory);
            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getMinorValuesFromDB(String s) throws SQLException, ClassNotFoundException {
        String minorName = "";
        int minorID;
        int resturnMinorID = 0;
        String sql = "select * from minorCategories where minorCategoryName = '" + s + "'";
        ResultSet result = DBConnectionDemo.getConnection().prepareStatement(sql).executeQuery();

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

    @Override
    public int getMainValuesFromDB(String s) throws SQLException, ClassNotFoundException {
        String mainName = "";
        int mainID;
        int resturnMainID = 0;
        String sql = "select * from maincategories where mainCategoryName ='" + s + "'";
        ResultSet result = DBConnectionDemo.getConnection().prepareStatement(sql).executeQuery();

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

    @Override
    public int createMainIDInDB(String s) throws SQLException, ClassNotFoundException {

        int newlycreatedID = 0;
        String sqlGetID = "select COUNT(mainCategoryName) from mainCategories";
        ResultSet result = DBConnectionDemo.getConnection().prepareStatement(sqlGetID).executeQuery();

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
            PreparedStatement statement = DBConnectionDemo.getConnection().prepareStatement(sql);
            statement.setString(1, s);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ++newlycreatedID;
    }

    @Override
    public int createMinorIDInDB(String s) throws SQLException, ClassNotFoundException {
        int newlycreatedID = 0;
        String sqlGetID = "select COUNT(minorCategoryName) from minorCategories";
        ResultSet result = DBConnectionDemo.getConnection().prepareStatement(sqlGetID).executeQuery();

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
            PreparedStatement statement = DBConnectionDemo.getConnection().prepareStatement(sql);
            statement.setString(1, s);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ++newlycreatedID;
    }

    @Override
    public boolean checkIfProductExists(String s) throws SQLException, ClassNotFoundException {
        Boolean returnvalue = false;
        int tempholder;
        String sql = "select COUNT(productid) from products where productid = '" + s + "'";
        ResultSet result = DBConnectionDemo.getConnection().prepareStatement(sql).executeQuery();

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
            Logger.getLogger(DBFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;
    }
    }

