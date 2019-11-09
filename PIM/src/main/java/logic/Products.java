package logic;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;

import logic.JsonHandler;

public class Products {

    private int ProductID;
    private String ProductName;
    private String ProductNameDescription;
    private String ProductDescription;
    private String companyName;
    private double Price;
    private int Quantity;
    private String PictureName;
    private boolean PublishedStatus;
    private int MinorCategory;
    private int MainCategory;
    private static ArrayList<Products> productTempHolder;

    public static void setProductsTempHolder(ArrayList<Products> products) {
        Products.productTempHolder = products;
    }

    public static ArrayList<Products> getProductsTempHolder() {
        return productTempHolder;
    }

    public Products(int ProductID, String ProductName, String ProductNameDescription, 
             String ProductDescription, String companyName, double Price, int Quantity, 
             String PictureName, boolean PublishedStatus, int MinorCategory, int MainCategory) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductNameDescription = ProductNameDescription;
        this.ProductDescription = ProductDescription;
        this.companyName = companyName;
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
        return companyName;
    }

    public String getPictureName() {
        return PictureName;
    }

    public boolean getPublishedStatus() {
        return PublishedStatus;
    }

    public int getMinorCategory() {
        return MinorCategory;
    }

    public int getMainCategory() {
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
