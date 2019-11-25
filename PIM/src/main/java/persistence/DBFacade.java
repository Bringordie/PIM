package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import logic.Categories;
import logic.Products;

public class DBFacade implements Facade {
    ProductMapper productMapper = new ProductMapper();
    CategoryMapper categoryMapper = new CategoryMapper();

    @Override
    public void jsonInsertOrUpdateToDB(ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException {
        productMapper.jsonInsertOrUpdateToDB(products, propertyname);
    }

    @Override
    public void excelInsertOrUpdateToDB(ArrayList<Products> product, String propertyname) throws SQLException, ClassNotFoundException {
        productMapper.excelInsertOrUpdateToDB(product, propertyname);
    }

    @Override
    public String addProduct(ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException {
        return productMapper.addProduct(products, propertyname);
    } 

    @Override
    public String addMainCategory(String category, String propertyname) throws ClassNotFoundException, SQLException {
        return categoryMapper.addMainCategory(category, propertyname);
    }

    @Override
    public String addMinorCategory(String category, String propertyname) throws ClassNotFoundException, SQLException {
        return categoryMapper.addMinorCategory(category, propertyname);
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
    
    @Override
    public ArrayList<Products> searchProduct(int i, String propertyname) throws ClassNotFoundException, SQLException {
        return productMapper.getSearchResults(i, propertyname);
    }

    @Override
    public ArrayList<Products> showAllProducts(String propertyname) throws SQLException, ClassNotFoundException {
        return productMapper.showAllProducts(propertyname);
    }
    
    @Override
    public void EditProduct (int id, Products product, String propertyname) throws SQLException, ClassNotFoundException {
        productMapper.EditProduct(id, product, propertyname);
    } 
    
    
    @Override
    public String DeleteProduct (int id, String propertyname) throws SQLException, ClassNotFoundException {
      return productMapper.DeleteProduct(id, propertyname);
    } 
    
    @Override
    public ArrayList<Products> showSearchedProduct(String s, String attribute, String propertyname) throws SQLException, ClassNotFoundException {
        return productMapper.showSearchedProduct(s, attribute, propertyname);
    }

    @Override
    public ArrayList<Products> dbDownload(String propertyname) throws SQLException, ClassNotFoundException {
        return productMapper.dbDownload(propertyname);
    }

        
}