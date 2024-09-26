package utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class FileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);


    public static void savePropertiesToFile(Properties properties, String filePath) {
        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            properties.store(outputStream, null);
        } catch (IOException e) {
            LOGGER.error("Cannot save to file", e);
        }
    }

    public static String getCurrentDir() {
        return System.getProperty("user.dir") + File.separator;
    }
}
