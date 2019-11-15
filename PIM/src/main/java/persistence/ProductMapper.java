/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Products;
import static persistence.DBConnection.getConnection;

/**
 *
 * @author - Bringordie - Frederik Braagaard
 */
public class ProductMapper implements ProductMapperInterface {

    CategoryMapper category = new CategoryMapper();

    @Override
    public void reqisterProductsJson(ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException {
        //TO DO
        try {
            for (Products product : products) {
                String sql = "INSERT INTO products(productid, name, nameDescription, "
                        + "description, companyName, price, quantity, pictureName, "
                        + "publishedStatus, minorCategory, mainCategory)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = getConnection(propertyname).prepareStatement(sql);
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

    @Override
    public void saveToDatabaseExcel(Vector dataHolder, String propertyname) throws SQLException, ClassNotFoundException {
        String ProductID;
        Iterator iterator = dataHolder.iterator();
        String propertyfile = propertyname;
        if (iterator.hasNext()) {
            iterator.next();
        }

        while (iterator.hasNext()) {
            List list = (List) iterator.next();
            iterator.hasNext();
            ProductID = list.get(0).toString();

            Boolean booleanIDCheck = checkIfProductExists(ProductID, propertyname);
            if (booleanIDCheck != true) {
                //excelInsertToDB(list, propertyname);
            } else {
                //excelUpdateToDB(list, ProductID, propertyname);
            }
        }
    }

    @Override
    public void saveToDatabaseExcelnew(ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException {
//        String ProductID;
//        String propertyfile = propertyname;
//
//        //for (Products product : products) {
//            ProductID = String.valueOf(product.getId());
//            
//            Boolean booleanIDCheck = checkIfProductExists(ProductID, propertyname);
//            if (booleanIDCheck != true) {
//                excelInsertToDB(products, propertyname);
//            } else {
//                excelUpdateToDB(products, ProductID, propertyname);
//            //}
//        }

    }

    @Override
    public void excelInsertToDB(ArrayList<Products> list, String propertyname) throws ClassNotFoundException, NumberFormatException, SQLException {
        int ProductID;
        String ProductName;
        String ProductNameDescription;
        String ProductDescription;
        String CompanyName;
        Double Price;
        int Quantity;
        String PictureName;
        Boolean PublishedStatus;
        int MinorCategory = 0;
        int MainCategory = 0;

        for (Products products : list) {
            //list.get(0).toString();
            ProductID = products.getId();
            //BOOLEAN CHECK
            Boolean booleanIDCheck = checkIfProductExists(String.valueOf(ProductID), propertyname);
            if (booleanIDCheck == false) {

                //
                ProductName = products.getName();
                //Might want to consider making an extra method to make it nicer.
                if (products.getNameDescription() == "") {
                    ProductNameDescription = null;
                } else {
                    ProductNameDescription = products.getNameDescription();
                }
                //Might want to consider making an extra method to make it nicer.

                if (products.getDescription() == "") {
                    ProductDescription = null;
                } else {
                    ProductDescription = products.getDescription();
                }
                //Might want to consider making an extra method to make it nicer.
                if (products.getCompanyName() == "") {
                    CompanyName = null;
                } else {
                    CompanyName = products.getCompanyName();
                }
                Price = products.getPrice();
                Quantity = products.getQty();
                PictureName = products.getPictureName();

                if (category.getMinorValuesFromDBFile(products.getMinorCategory(), propertyname) == 0) {
                    int minorIDCreated = category.createMinorIDInDB(products.getMinorCategory(), propertyname);
                    MinorCategory = minorIDCreated;
                } else if (category.getMinorValuesFromDBFile(products.getMinorCategory(), propertyname) > 0) {
                    int reuseIDCreated = category.getMinorValuesFromDBFile(products.getMinorCategory(), propertyname);
                    MinorCategory = reuseIDCreated;
                }
                //Checking mainvalue
                if (category.getMainValuesFromDBFile(products.getMainCategory(), propertyname) == 0) {
                    int mainIDCreated = category.createMainIDInDB(products.getMainCategory(), propertyname);
                    MainCategory = mainIDCreated;
                } else if (category.getMainValuesFromDBFile(products.getMainCategory(), propertyname) > 0) {
                    int reuseIDCreated = category.getMainValuesFromDBFile(products.getMainCategory(), propertyname);
                    MainCategory = reuseIDCreated;
                }
                //Requirements for publishing
                if (ProductName == null || ProductNameDescription == null || ProductDescription == null || CompanyName == null) {
                    PublishedStatus = false;
                } else {
                    PublishedStatus = true;
                }
                try {
                    String sql = "INSERT INTO products(productid, name, nameDescription, "
                            + "description, companyName, price, quantity, pictureName, "
                            + "publishedStatus, minorCategory, mainCategory)"
                            + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement statement = getConnection(propertyname).prepareStatement(sql);
                    statement.setInt(1, ProductID);
                    statement.setString(2, ProductName);
                    statement.setString(3, ProductNameDescription);
                    statement.setString(4, ProductDescription);
                    statement.setString(5, CompanyName);
                    statement.setDouble(6, Price);
                    statement.setInt(7, Quantity);
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
            } else {
                ProductID = products.getId();
            ProductName = products.getName();
            //Might want to consider making an extra method to make it nicer.
            if (products.getNameDescription() == "") {
                ProductNameDescription = null;
            } else {
                ProductNameDescription = products.getNameDescription();
            }
            //Might want to consider making an extra method to make it nicer.

            if (products.getDescription() == "") {
                ProductDescription = null;
            } else {
                ProductDescription = products.getDescription();
            }
            //Might want to consider making an extra method to make it nicer.
            if (products.getCompanyName() == "") {
                CompanyName = null;
            } else {
                CompanyName = products.getCompanyName();
            }
            Price = products.getPrice();
            Quantity = products.getQty();
            PictureName = products.getPictureName();

            if (category.getMinorValuesFromDBFile(products.getMinorCategory(), propertyname) == 0) {
                int minorIDCreated = category.createMinorIDInDB(products.getMinorCategory(), propertyname);
                MinorCategory = minorIDCreated;
            } else if (category.getMinorValuesFromDBFile(products.getMinorCategory(), propertyname) > 0) {
                int reuseIDCreated = category.getMinorValuesFromDBFile(products.getMinorCategory(), propertyname);
                MinorCategory = reuseIDCreated;
            }
            //Checking mainvalue
            if (category.getMainValuesFromDBFile(products.getMainCategory(), propertyname) == 0) {
                int mainIDCreated = category.createMainIDInDB(products.getMainCategory(), propertyname);
                MainCategory = mainIDCreated;
            } else if (category.getMainValuesFromDBFile(products.getMainCategory(), propertyname) > 0) {
                int reuseIDCreated = category.getMainValuesFromDBFile(products.getMainCategory(), propertyname);
                MainCategory = reuseIDCreated;
            }
            //Requirements for publishing
            if (ProductName == null || ProductNameDescription == null || ProductDescription == null || CompanyName == null) {
                PublishedStatus = false;
            } else {
                PublishedStatus = true;
            }

            try {
                String sql = "update products set productid = ?, name= ?, "
                        + "nameDescription= ?, description= ?, companyName= ?, "
                        + "price= ?, quantity= ?, pictureName = ?, "
                        + "publishedStatus= ?, minorCategory= ?, mainCategory= ? "
                        + "where productid ='" + ProductID + "'";
                PreparedStatement statement = getConnection(propertyname).prepareStatement(sql);
                statement.setInt(1, ProductID);
                statement.setString(2, ProductName);
                statement.setString(3, ProductNameDescription);
                statement.setString(4, ProductDescription);
                statement.setString(5, CompanyName);
                statement.setDouble(6, Price);
                statement.setInt(7, Quantity);
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
        }
    }


    @Override
    public boolean checkIfProductExists(String s, String propertyname) throws SQLException, ClassNotFoundException {
        Boolean returnvalue = false;
        int tempholder;
        String sql = "select COUNT(productid) from products where productid = '" + s + "'";
        ResultSet result = getConnection("/db.properties").prepareStatement(sql).executeQuery();

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

    @Override
    public void addProduct(ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException {
        try {
            for (Products product : products) {
                String sql = "INSERT INTO products(productid, name, nameDescription, "
                        + "description, companyName, price, quantity, pictureName, "
                        + "publishedStatus, minorCategory, mainCategory)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = getConnection((propertyname)).prepareStatement(sql);
                statement.setInt(1, product.getId());
                statement.setString(2, product.getName());
                statement.setString(3, product.getNameDescription());
                statement.setString(4, product.getDescription());
                statement.setString(5, product.getCompanyName());
                statement.setDouble(6, product.getPrice());
                statement.setInt(7, product.getQty());
                statement.setString(8, product.getPictureName());
                statement.setBoolean(9, product.getPublishedStatus());
                statement.setString(10, product.getMinorCategory());
                statement.setString(11, product.getMainCategory());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteProduct(int ProductID) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
