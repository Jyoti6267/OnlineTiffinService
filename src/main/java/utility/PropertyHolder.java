package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHolder {

    static private Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("/home/aniket/IdeaProjects/OnlineTiffinService/src/main/resources/configuration.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getValue(String key){
        return properties.getProperty(key);
    }
}
