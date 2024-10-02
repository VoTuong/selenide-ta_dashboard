package com.tadashboard.constants;

import utilities.PropertiesUtils;

public class Constants {

    public static final int SHORT_TIME = 3;
    public static final int RETRY_TEST_FAIL = 2;
    public static final String DATA_PATH_ROOT = PropertiesUtils.getValue("DATA_PATH_ROOT");
    public static final String USER_JSON_DATA_PATH_ROOT = DATA_PATH_ROOT + "accounts.json";
//    public static final String PANEL_PRESET_JSON_DATA_PATH_ROOT = DATA_PATH_ROOT + "dropdowndatapanelpromt.json";


}
