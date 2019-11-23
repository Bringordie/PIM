package logic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import persistence.ProductMapper;

/**
 *
 * @author Bringordie - Frederik Braagaard
 */
public class JsonWriter {

    public void DataBaseToJson(String property) throws Exception {
        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        //Creating a json array
        JSONArray array = new JSONArray();
        ProductMapper product = new ProductMapper();
        ArrayList<Products> writer = product.dbWriter(property);

        for (Products products : writer) {
            JSONObject record = new JSONObject();
            record.put("ID", products.getId() + "/n");
            record.put("Product Name", products.getName());
            record.put("Product Name Description", products.getNameDescription());
            record.put("Product Description", products.getDescription());
            record.put("Company Name", products.getCompanyName());
            record.put("Price", products.getPrice());
            record.put("Quantity", products.getQty());
            record.put("Picture Name", products.getPictureName());
            record.put("Minor Category", products.getMinorCategory());
            record.put("Main Category", products.getMainCategory());
            array.add(record);
        }
        jsonObject.put("Product_data", array);
        try {
            String home = System.getProperty("user.home");
            FileWriter file = new FileWriter(home + "/Downloads/" + "jsondownload.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("JSON file created......");
    }
}
