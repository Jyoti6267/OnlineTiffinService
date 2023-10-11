package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnection {

    static private Connection connection;
    static private final Properties properties = new Properties();
    static private String prefix;
    static private String username;
    static private String password;
    static private String port;
    static private String host;
    static private String db_name;

    private static void initializeProperty() throws IOException {

        InputStream stream = GetConnection.class.getClassLoader().getResourceAsStream("/resources/connection_info.properties");
        properties.load(stream);
        prefix = properties.getProperty("prefix");
        username =  properties.getProperty("username");
        password = properties.getProperty("password");
        host = properties.getProperty("host");
        port = properties.getProperty("port");
        db_name = properties.getProperty("database_name");

    }

    static public Connection getConnection() throws IOException, SQLException {

        if (connection == null || connection.isClosed()) {
            initializeProperty();
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(prefix+host+":"+port+"/"+db_name,username,password);
        }
        return connection;

    }


}
