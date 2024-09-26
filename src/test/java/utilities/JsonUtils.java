package utilities;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

    public static <T> List<T> toList(String jsonPath, Type type) {
        LOGGER.debug("Load json from {}", jsonPath);
        JsonReader reader = getJsonReader(jsonPath);
        Gson gson = new Gson();
        return gson.fromJson(reader, type);
    }

    public static <T> T to(String jsonPath, Type type) {
        LOGGER.debug("Load json from {}", jsonPath);
        JsonReader reader = getJsonReader(jsonPath);
        Gson gson = new Gson();
        return gson.fromJson(reader, type);
    }

    public static <T> T to(String jsonPath, Class<T> clazz) {
        LOGGER.debug("Load json from {}", jsonPath);
        JsonReader reader = getJsonReader(jsonPath);
        Gson gson = new Gson();
        return gson.fromJson(reader, clazz);
    }

    private static JsonReader getJsonReader(String jsonPath) {
        try {
            JsonReader reader;
            reader = new JsonReader(new FileReader(jsonPath));
            return reader;
        } catch (FileNotFoundException e) {
            LOGGER.error(",e");
        }
        throw new RuntimeException("Cannot read json file from " + jsonPath);
    }

    public static JsonObject getJsonObjects(String filePath) {

        try {
            JsonObject jsonObject;
            Gson gson = new Gson();
            JsonReader jsonReader = getJsonReader(filePath);
            jsonObject = gson.fromJson(jsonReader, JsonObject.class);

            return jsonObject;
        } catch (Exception e) {
            throw e;
        }
    }

    public static <T> T convertJsonToObjects(JsonObject jsonObject, Class<T> tClass){
        return new Gson().fromJson(jsonObject, tClass);
    }

    public static <T> T convertToObjects(String jsonKey, JsonObject jsonObject, Class<T> tClass){
        JsonObject dataObject = jsonObject.getAsJsonObject(jsonKey);
        return new Gson().fromJson(dataObject, tClass);
    }

    public static String[] convertJsonArrayToArray(JsonObject dataObject, String name){
        JsonArray jsonArray = dataObject.getAsJsonArray(name);

        List<String> list = new ArrayList<>();
        for(int i = 0; i < jsonArray.size(); i++){
            list.add(jsonArray.get(i).getAsString());
        }

        return list.toArray(new String[list.size()]);
    }
}
