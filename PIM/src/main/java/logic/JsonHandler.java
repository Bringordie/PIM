package logic;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;
import java.util.Arrays;

/**
 *
 * @author Frederik Braagaard - Bringordie
 */
public class JsonHandler {

    Gson gson = new Gson();

        
        public ArrayList<Products> makeJSonFileIntoArray(String location) throws FileNotFoundException  {
            ArrayList<Products> products = new ArrayList();
            
            //Products[] userArray = gson.fromJson(new FileReader("C:\\Users\\Frederik\\Desktop\\PIM\\programlanguage.json"), Products[].class);
            Products[] userArray = gson.fromJson(new FileReader(location), Products[].class);
            for (Products products1 : userArray) {
                products.add(products1);
            }
            return products;
        }

        
}
