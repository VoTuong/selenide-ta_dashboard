package com.tadashboard.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.epam.reportportal.annotations.Step;
import com.tadashboard.enums.AdministerOptions;
import com.tadashboard.enums.GlobalSettingOptions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage{
//    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);


    // Define Selenide elements using locators
    private final SelenideElement usernameLbl = $x("//div[@id='header']//a[@href='#Welcome']");
    private final SelenideElement mainMenu = $("#main-menu");
    private final SelenideElement logoutBtn = $x("//a[text()='Logout']");
    private final SelenideElement globalSettingBtn = $x("//div[@id='main-menu']//li[@class='mn-setting']//a[contains(text(),'%s')]");
    private final SelenideElement mainMenuAdminister = $("#ulAdminister");
    private final SelenideElement dataProfilesBtn = $x("//*[@id='ulAdminister']/li/a");


    @Step
    public boolean isMainMenuDisplayed() {
        return mainMenu.isDisplayed();
    }

    @Step
    public void logout() {
        if (usernameLbl.isDisplayed()){
            usernameLbl.hover();
            logoutBtn.shouldBe(visible).click();
        }
    }

    @Step
    public boolean isMenuSettingOptionVisible(GlobalSettingOptions option) {
        boolean rs = false;

        try {
            globalSettingBtn.setValue(option.getValue());
            globalSettingBtn.hover();
            rs = globalSettingBtn.exists();
        } catch (Exception ignore) {
        }
        return rs;
    }

    @Step
    public void clickAdministerMenuOptions(AdministerOptions option) {
//        openAdministerMenu();
        if(mainMenuAdminister.isDisplayed()){
            mainMenuAdminister.hover();
        }
        mainMenuAdminister.hover();
        dataProfilesBtn.setValue(option.getValue());
        dataProfilesBtn.click();
    }

    @Step
    public void clickDataProfile(){
        actions().moveToElement(mainMenuAdminister).perform();
        dataProfilesBtn.find(String.valueOf(visible)).find(String.valueOf(Condition.text("Data Profiles")));
        dataProfilesBtn.shouldBe(visible).click();
    }

    public void openAdministerMenu() {
        mainMenuAdminister.hover();

    }

}
