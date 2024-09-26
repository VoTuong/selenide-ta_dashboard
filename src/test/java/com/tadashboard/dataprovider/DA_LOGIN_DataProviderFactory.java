package com.tadashboard.dataprovider;

import com.google.gson.JsonObject;
import com.tadashboard.constants.Constants;
import com.tadashboard.model.user.UserModel;
import org.testng.annotations.DataProvider;
import utilities.FileUtils;
import utilities.JsonUtils;

public class DA_LOGIN_DataProviderFactory {

    @DataProvider(name = "validUser")
    public static Object[][] validUserDataProvider() {

        String filePath = FileUtils.getCurrentDir() + Constants.USER_JSON_DATA_PATH_ROOT;
        JsonObject dataObject = JsonUtils.getJsonObjects(filePath);

        JsonObject accountData = dataObject.getAsJsonObject("USER_VALID_CREDENTIAL");

        UserModel validUser = JsonUtils.convertJsonToObjects(accountData, UserModel.class);
        return new Object[][]{
                {validUser}
        };
    }

    @DataProvider(name = "validUser2")
    public static Object[][] validUser2DataProvider() {

        String filePath = FileUtils.getCurrentDir() + Constants.USER_JSON_DATA_PATH_ROOT;
        JsonObject dataObject = JsonUtils.getJsonObjects(filePath);

        JsonObject accountData = dataObject.getAsJsonObject("USER_VALID_CREDENTIAL_2");

        UserModel validUser = JsonUtils.convertJsonToObjects(accountData, UserModel.class);
        return new Object[][]{
                {validUser}
        };
    }

    @DataProvider(name = "invalidUser")
    public static Object[][] invalidUserDataProvider() {

        String filePath = FileUtils.getCurrentDir() + Constants.USER_JSON_DATA_PATH_ROOT;
        JsonObject dataObject = JsonUtils.getJsonObjects(filePath);

        JsonObject accountData = dataObject.getAsJsonObject("USER_INVALID_CREDENTIALS");

        UserModel validUser = JsonUtils.convertJsonToObjects(accountData, UserModel.class);
        return new Object[][]{
                {validUser}
        };
    }


}
