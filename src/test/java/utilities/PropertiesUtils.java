package utilities;

import com.tadashboard.constants.Constants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

public class PropertiesUtils {

    private static Properties properties;
    private static String linkFile;
    private static FileInputStream file;

    private static final String propertiesFilePath = "src/test/resources/properties/configs.properties";

    public static Properties loadAllFiles() {
        LinkedList<String> files = new LinkedList<>();

        files.add("src/test/resources/properties/configs.properties");

        try {
            properties = new Properties();

            for (String f : files) {
                Properties tempProp = new Properties();
                linkFile = FileUtils.getCurrentDir() + f;
                file = new FileInputStream(linkFile);
                tempProp.load(file);
                properties.putAll(tempProp);
            }
            return properties;
        } catch (IOException ioe) {
            return new Properties();
        }
    }

    public static void setFile(String relPropertiesFilePath) {
        properties = new Properties();
        try {
            linkFile = FileUtils.getCurrentDir() + relPropertiesFilePath;
            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setDefaultFile() {
        properties = new Properties();
        try {
            linkFile = FileUtils.getCurrentDir() + propertiesFilePath;
            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        String keyval = null;
        try {
            if (file == null) {
                properties = new Properties();
                linkFile = FileUtils.getCurrentDir() + propertiesFilePath;
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

    public static void setValue(String key, String keyValue) {
        try {
            FileOutputStream out;
            if (file == null) {
                properties = new Properties();
                file = new FileInputStream(FileUtils.getCurrentDir() + Constants.PROPERTIES_FILE_PATH_ROOT);
                properties.load(file);
                file.close();
                out = new FileOutputStream(FileUtils.getCurrentDir() + Constants.PROPERTIES_FILE_PATH_ROOT);
            }

            out = new FileOutputStream(linkFile);
            System.out.println(linkFile);
            properties.setProperty(key, keyValue);
            properties.store(out, null);
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
