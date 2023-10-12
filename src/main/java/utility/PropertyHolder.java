package utility;

import database.GetConnection;

import java.io.IOException;
import java.util.Properties;

public class PropertyHolder {

    static private Properties properties = new Properties();

    static {
        try {
            properties.load(PropertyHolder.class.getClassLoader().getResourceAsStream("/resources/configuration.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getValue(String key){
        return properties.getProperty(key);
    }
}
