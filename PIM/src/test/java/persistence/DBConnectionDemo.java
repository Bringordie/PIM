package persistence;

import persistence.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionDemo {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection singleton;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        if (singleton == null) {
            try (InputStream sa = DBConnectionDemo.class.getResourceAsStream("/dbtest.properties")) {

                // load the properties file
                Properties properties = new Properties();
                properties.load(sa);
                Class.forName(DRIVER);
                // assign db parameters
                String password = properties.getProperty("password");
                String user = properties.getProperty("user");
                String url = properties.getProperty("url");

                // create a connection to the database
                singleton = DriverManager.getConnection(url + "?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8", user, password);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return singleton;
    }

}
