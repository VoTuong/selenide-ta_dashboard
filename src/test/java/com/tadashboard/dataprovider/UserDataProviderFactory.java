package com.tadashboard.dataprovider;

import com.google.gson.JsonObject;
import com.tadashboard.constants.Constants;
import com.tadashboard.model.user.User;
import org.testng.annotations.DataProvider;
import utilities.FileUtils;
import utilities.JsonUtils;

public class UserDataProviderFactory {

    @DataProvider(name = "validUser")
    public static Object[][] validUser() {

        String filePath = FileUtils.getCurrentDir() + Constants.USER_JSON_DATA_PATH;
        JsonObject dataObject = JsonUtils.getJsonObjects(filePath);

        JsonObject accountData = dataObject.getAsJsonObject("USER_VALID_CREDENTIAL");

        User validUser = JsonUtils.convertJsonToObjects(accountData, User.class);
        return new Object[][]{
                {validUser}
        };
    }

    @DataProvider(name = "validUser2")
    public static Object[][] validUser2() {

        String filePath = FileUtils.getCurrentDir() + Constants.USER_JSON_DATA_PATH;
        JsonObject dataObject = JsonUtils.getJsonObjects(filePath);

        JsonObject accountData = dataObject.getAsJsonObject("USER_VALID_CREDENTIAL_2");

        User validUser = JsonUtils.convertJsonToObjects(accountData, User.class);
        return new Object[][]{
                {validUser}
        };
    }

    @DataProvider(name = "invalidUser")
    public static Object[][] invalidUser() {

        String filePath = FileUtils.getCurrentDir() + Constants.USER_JSON_DATA_PATH;
        JsonObject dataObject = JsonUtils.getJsonObjects(filePath);

        JsonObject accountData = dataObject.getAsJsonObject("USER_INVALID_CREDENTIALS");

        User validUser = JsonUtils.convertJsonToObjects(accountData, User.class);
        return new Object[][]{
                {validUser}
        };
    }


}
