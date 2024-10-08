package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {
    private static Properties properties;
    private static FileInputStream file;

    private static final String propertiesFilePath = "src/test/resources/properties/configs.properties";

    public static String getValue(String key) {
        String keyval = null;
        try {
            if (file == null) {
                properties = new Properties();
                String linkFile = System.getProperty("user.dir") + File.separator + propertiesFilePath;
                file = new FileInputStream(linkFile);
                properties.load(file);
                file.close();
            }
            // Get value from file
            keyval = properties.getProperty(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return keyval;
    }
}
