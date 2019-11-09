package logic;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;


import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Arrays;


public class JsonHandler {

    Gson gson = new Gson();


        public Products makeJSonFileIntoObject() throws FileNotFoundException {
        Products object = gson.fromJson(new FileReader("C:\\Users\\Frederik\\Desktop\\PIM\\singledata.json"), Products.class);  
        return object;
    }
        
        public Products[] makeJSonFileIntoObjects() throws FileNotFoundException {
        Products[] objects = gson.fromJson(new FileReader("C:\\Users\\Frederik\\Desktop\\PIM\\programlanguage.json"), Products[].class);
        return objects;
    }
        
        public ArrayList<Products> makeJSonFileIntoArray() throws FileNotFoundException  {
            ArrayList<Products> products = new ArrayList();
            
            Products[] userArray = gson.fromJson(new FileReader("C:\\Users\\Frederik\\Desktop\\PIM\\programlanguage.json"), Products[].class);
            for (Products products1 : userArray) {
                products.add(products1);
            }
            return products;
        }

        
}
