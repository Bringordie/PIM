package logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import persistence.ProductMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import presentation.UploadFiles;

/**
 *
 * @author Bringordie - Frederik Braagaard
 */
public class ExcelWriter {

    public void DataBaseToExcel(String property) throws Exception {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Product Data");

        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"ProductID", "ProductName", "ProductNameDescription",
            "ProductDescription", "CompanyName", "Price", "Quantity", "PictureName",
            "MinorCategory", "MainCategory"});
        ProductMapper product = new ProductMapper();
        ArrayList<Products> writer = product.dbWriter(property);
        int count = 1;
        for (Products products : writer) {
            ++count;
            data.put(String.valueOf(count), new Object[]{products.getId(),
                products.getName(), products.getNameDescription(), products.getDescription(),
                products.getCompanyName(), String.valueOf(products.getPrice()), products.getQty(),
                products.getPictureName(), products.getMinorCategory(), products.getMainCategory()});
        }
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
        try {
            // load the properties file
            InputStream sa = UploadFiles.class.getResourceAsStream("/filepath.properties");
            Properties properties = new Properties();
            properties.load(sa);
            // assign properties parameters
            String path = properties.getProperty("filepath");

            FileOutputStream out = new FileOutputStream(path + "Products.xlsx");
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
