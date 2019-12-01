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
    public int getMainCategoriesID(String mainname, String propertyname) throws ClassNotFoundException, SQLException {
        return categoryMapper.getMainValuesFromDBFile(mainname, propertyname);
    }
    
    @Override
    public int getMinorCategoriesID(String mainname, String propertyname) throws ClassNotFoundException, SQLException {
        return categoryMapper.getMinorValuesFromDBFile(mainname, propertyname);
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
    public void editProduct (int id, Products product, String propertyname) throws SQLException, ClassNotFoundException {
        productMapper.editProduct(id, product, propertyname);
    } 
    
    @Override
    public String deleteProduct (int id, String propertyname) throws SQLException, ClassNotFoundException {
      return productMapper.deleteProduct(id, propertyname);
    } 
    
    @Override
    public ArrayList<Products> showSearchedProduct(String search, String attribute, String propertyname) throws SQLException, ClassNotFoundException {
        return productMapper.showSearchedProduct(search, attribute, propertyname);
    }

    @Override
    public ArrayList<Products> dbDownload(String propertyname) throws SQLException, ClassNotFoundException {
        return productMapper.dbDownload(propertyname);
    }

    @Override
    public String bulkEditPublished(String attribute, boolean changeValue, ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException {
        return productMapper.bulkEditPublished(attribute, changeValue, products, propertyname);
    }

    @Override
    public String bulkEditProducts(String attribute, String changeValue, ArrayList<Products> products, String propertyname) throws SQLException, ClassNotFoundException {
        return productMapper.bulkEditProducts(attribute, changeValue, products, propertyname);
    }
    
    

        
}