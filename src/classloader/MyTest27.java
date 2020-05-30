package classloader;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @ClassName MyTest27
 * @Description SPI
 * @Author tan
 * @Date 2020/5/24 18:16
 * @Version 1.0
 **/
public class MyTest27 {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestdb", "username", "password");
    }
}
