package persistence;

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
import static persistence.DBConnection.getConnection;

public class DBFacade implements Facade {
    ProductMapper productMapper = new ProductMapper();
    CategoryMapper categoryMapper = new CategoryMapper();

    @Override
    public void jsonInsertOrUpdateToDB(ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException {
        productMapper.jsonInsertOrUpdateToDB(products, propertyname);
    }

    @Override
    public void excelInsertOrUpdateToDB(ArrayList<Products> product, String propertyname) throws SQLException, ClassNotFoundException {
        //productMapper.saveToDatabaseExcel(dataHolder, propertyname);
        productMapper.excelInsertOrUpdateToDB(product, propertyname);
    }

    @Override
    public void addProduct(ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException {
        productMapper.addProduct(products, propertyname);
    } 

    @Override
    public void addMainCategory(String category, String propertyname) {
        categoryMapper.addMainCategory(category, propertyname);
    }

    @Override
    public void addMinorCategory(String category, String propertyname) {
        categoryMapper.addMinorCategory(category, propertyname);
    }

    @Override
    public void deleteMainCategory(int category, String propertyname) throws ClassNotFoundException, SQLException {
        categoryMapper.deleteMainCategory(category, propertyname);
    }

    @Override
    public void deleteMinorCategory(int category, String propertyname) throws ClassNotFoundException, SQLException {
        categoryMapper.deleteMinorCategory(category, propertyname);
    }

    @Override
    public void editMainCategory(int categoryInt, String categoryStr, String propertyname) throws ClassNotFoundException, SQLException {
        categoryMapper.editMainCategory(categoryInt, categoryStr, propertyname);
    }

    @Override
    public void editMinorCategory(int categoryInt, String categoryStr, String propertyname) throws ClassNotFoundException, SQLException {
        categoryMapper.editMinorCategory(categoryInt, categoryStr, propertyname);
    }

    @Override
    public ArrayList<Categories> getMainCategories(String propertyname) throws ClassNotFoundException, SQLException {
        return categoryMapper.getMainValuesFromDB(propertyname);
    }

    @Override
    public ArrayList<Categories> getMinorCategories(String propertyname) throws ClassNotFoundException, SQLException {
        return categoryMapper.getMinorValuesFromDB(propertyname);
    }
    
    
        
    }