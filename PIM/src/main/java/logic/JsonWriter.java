package logic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import persistence.DBFacade;
import presentation.UploadFiles;

/**
 *
 * @author Bringordie - Frederik Braagaard
 */
public class JsonWriter {

    public void DataBaseToJson(String property) throws Exception {
        //Creating a JSONObject object
        //Creating a json array
        JSONArray array = new JSONArray();
        DBFacade db = new DBFacade();
        ArrayList<Products> writer = db.dbDownload(property);

        for (Products products : writer) {
            JSONObject record = new JSONObject();
            record.put("ProductID", products.getId());
            record.put("ProductName", products.getName());
            record.put("ProductNameDescription", products.getNameDescription());
            record.put("ProductDescription", products.getDescription());
            record.put("CompanyName", products.getCompanyName());
            record.put("Price", products.getPrice());
            record.put("Quantity", products.getQty());
            record.put("PictureName", products.getPictureName());
            record.put("MinorCategory", products.getMinorCategory());
            record.put("MainCategory", products.getMainCategory());
            array.add(record);
        }
        try {
            // load the properties file
            InputStream sa = UploadFiles.class.getResourceAsStream("/filepath.properties");
            Properties properties = new Properties();
            properties.load(sa);
            // assign properties parameters
            String path = properties.getProperty("filepath");
            
            FileWriter file = new FileWriter(path+"Products.json");
            file.write(array.toJSONString());
            file.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
