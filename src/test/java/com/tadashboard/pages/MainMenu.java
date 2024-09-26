package com.tadashboard.pages;


import com.tadashboard.enums.GlobalSettingOptions;


public class MainMenu extends BasePage{
//    private static final Logger LOGGER = LoggerFactory.getLogger(MainMenu.class);

    HomePage homePage = new HomePage();

    public boolean isGlobalSettingOptionVisible(GlobalSettingOptions option) {
        return homePage.isMenuSettingOptionVisible(option);
    }
    public boolean isGlobalSettingOptionInvisible(GlobalSettingOptions option) {
        return !(homePage.isMenuSettingOptionVisible(option));
    }
}
