package com.tadashboard.constants;

import utilities.PropertiesUtils;

public class Constants {

    public static final int SHORT_TIME = Integer.parseInt(PropertiesUtils.getValue("SHORT_TIME"));
    public static final int RETRY_TEST_FAIL = Integer.parseInt(PropertiesUtils.getValue("RETRY_TEST_FAIL"));
    public static final String DATA_PATH_ROOT = PropertiesUtils.getValue("DATA_PATH_ROOT");
    public static final String USER_JSON_DATA_PATH = DATA_PATH_ROOT + "accounts.json";
    public static final String PAGE_JSON_DATA_PATH = DATA_PATH_ROOT + "pages.json";
    public static final String PRE_SET_DATA_PROFILES_DATA_PATH = DATA_PATH_ROOT +"preset_data_profiles.json";

}
