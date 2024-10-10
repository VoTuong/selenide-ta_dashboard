package com.tadashboard.dataprovider;

import com.google.gson.JsonObject;
import com.tadashboard.model.page.Page;
import com.tadashboard.model.user.User;
import org.testng.annotations.DataProvider;
import utilities.FileUtils;
import utilities.JsonUtils;

import java.util.List;

import static com.tadashboard.constants.Constants.*;

public class TestDataProviders {

    @DataProvider(name = "validUser")
    public static Object[][] validUser() {

        String filePath = FileUtils.getCurrentDir() + USER_JSON_DATA_PATH;
        JsonObject dataObject = JsonUtils.getJsonObjects(filePath);

        JsonObject accountData = dataObject.getAsJsonObject("USER_VALID_CREDENTIAL");

        User validUser = JsonUtils.convertJsonToObjects(accountData, User.class);
        return new Object[][]{
                {validUser}
        };
    }

    @DataProvider(name = "validUser2")
    public static Object[][] validUser2() {

        String filePath = FileUtils.getCurrentDir() + USER_JSON_DATA_PATH;
        JsonObject dataObject = JsonUtils.getJsonObjects(filePath);

        JsonObject accountData = dataObject.getAsJsonObject("USER_VALID_CREDENTIAL_2");

        User validUser = JsonUtils.convertJsonToObjects(accountData, User.class);
        return new Object[][]{
                {validUser}
        };
    }

    @DataProvider(name = "invalidUser")
    public static Object[][] invalidUser() {

        String filePath = FileUtils.getCurrentDir() + USER_JSON_DATA_PATH;
        JsonObject dataObject = JsonUtils.getJsonObjects(filePath);

        JsonObject accountData = dataObject.getAsJsonObject("USER_INVALID_CREDENTIALS");

        User validUser = JsonUtils.convertJsonToObjects(accountData, User.class);
        return new Object[][]{
                {validUser}
        };
    }

    @DataProvider(name = "DA_MP_TC014")
    public static Object[][] dataForTC014() {
        String pageJSONPath = FileUtils.getCurrentDir() + PAGE_JSON_DATA_PATH;
        JsonObject pageDataObject = JsonUtils.getJsonObjects(pageJSONPath);

        User validUser = (User) validUser()[0][0];
        User validUser2 = (User) validUser2()[0][0];
        JsonObject pageData = pageDataObject.getAsJsonObject("PUBLIC_PAGE");

        Page publicPage = JsonUtils.convertJsonToObjects(pageData, Page.class);
        return new Object[][]{
                {validUser, validUser2, publicPage}
        };
    }

    @DataProvider
    public static Object[][] DA_DP_TC065() {
        String presetDataProfilesJSONPath = FileUtils.getCurrentDir() + PRE_SET_DATA_PROFILES_DATA_PATH;

        User validUser = (User) validUser()[0][0];
        List<String> listDataProfiles = JsonUtils.toStringList(presetDataProfilesJSONPath);
        return new Object[][]{
                {validUser, listDataProfiles}
        };
    }
}
