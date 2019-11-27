package logic;

import java.io.File;

/**
 *
 * @author Bringordie - Frederik Braagaard
 */
public class FileReaderLogic {

    public String FileCheck(String path) throws Exception {
        String test = "C:\\Users\\Frederik\\Desktop\\apache-tomcat-8.5.47\\webapps\\pictures\\"+path+".jpg";
        String returnpath = "";
        
        File file = new File(test);
        if(file.exists()) {
            returnpath = "http://localhost:8080/pictures/"+path+".jpg";
        } else {
            returnpath = "http://localhost:8080/pictures/noimage.jpg";
        }
        return returnpath;

    }
}
