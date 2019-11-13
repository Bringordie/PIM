package logic;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;


public class Products {

    private final int ProductID;
    private final String ProductName;
    private final String ProductNameDescription;
    private final String ProductDescription;
    private final String CompanyName;
    private final double Price;
    private final int Quantity;
    private final String PictureName;
    private final boolean PublishedStatus;
    private final String MinorCategory;
    private final String MainCategory;
    private static ArrayList<Products> productTempHolder;

    public static void setProductsTempHolder(ArrayList<Products> products) {
        Products.productTempHolder = products;
    }

    public static ArrayList<Products> getProductsTempHolder() {
        return productTempHolder;
    }

    public Products(int ProductID, String ProductName, String ProductNameDescription, 
             String ProductDescription, String CompanyName, double Price, int Quantity, 
             String PictureName, boolean PublishedStatus, String MinorCategory, String MainCategory) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductNameDescription = ProductNameDescription;
        this.ProductDescription = ProductDescription;
        this.CompanyName = CompanyName;
        this.Price = Price;
        this.Quantity = Quantity;
        this.PictureName = PictureName;
        this.PublishedStatus = PublishedStatus;
        this.MinorCategory = MinorCategory;
        this.MainCategory = MainCategory;
    }

    public String getName() {
        return ProductName;
    }

    public String getDescription() {
        return ProductNameDescription;
    }

    public String getNameDescription() {
        return ProductDescription;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getPictureName() {
        return PictureName;
    }

    public boolean getPublishedStatus() {
        return PublishedStatus;
    }

    public String getMinorCategory() {
        return MinorCategory;
    }

    public String getMainCategory() {
        return MainCategory;
    }

    public static ArrayList<Products> getProductTempHolder() {
        return productTempHolder;
    }

    public int getId() {
        return ProductID;
    }

    public static void emptyProductHolder() {
        productTempHolder.clear();
    }

    public double getPrice() {
        return Price;
    }

    public int getQty() {
        return Quantity;
    }

    @Override
    public String toString() {
        return "\nOrderID: " + getId() + "\nName: " + getName() + "\nDescription: " + 
                getNameDescription() + "\nCompany: " + getCompanyName() + "\nPrice: " 
                + getPrice() + "\nQuantity: " + getQty() + "\nPicture name: " + 
                getPictureName() + "\npublished: " + getPublishedStatus() + 
                "\nMinor Category: " + getMinorCategory() + "\nMajor Category: " +
                getMainCategory();
    }
    
}
