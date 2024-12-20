package com.tadashboard.pages;

import com.codeborne.selenide.SelenideElement;
import com.epam.reportportal.annotations.Step;
import com.tadashboard.enums.GlobalSettingOptions;
import com.tadashboard.model.page.Page;
import utilities.AlertHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage{

    private final SelenideElement usernameLbl = $x("//div[@id='header']//a[@href='#Welcome']//parent::li");
    private final SelenideElement mainMenu = $("#main-menu");
    private final SelenideElement globalSettingBtn = $(".mn-setting");
    private final SelenideElement logoutBtn = $x("//a[text()='Logout']");
    private final SelenideElement administerLink = $x("//a[@href='#Administer']");
    private final SelenideElement dataProfilesBtn = $x("//li/a[text()='Data Profiles']");
    private static final SelenideElement okBtn = $("#OK");

    private final String pageNameInMenuXpath = "//div[@id='main-menu']//a[normalize-space()='%s']";


    @Step
    public void clickPanelOKButton() {
        okBtn.shouldBe(visible).click();
    }

    @Step
    public void shouldMainMenuDisplay() {
        logInfo("Verify that the main menu is displayed");
        mainMenu.shouldBe(visible);
    }

    @Step
    public void logout() {
        logInfo("Logout from TA DashBoard");
        if (usernameLbl.isDisplayed()) {
            usernameLbl.hover();
            logoutBtn.click();
        }
    }

    @Step
    public String getPageName(Object pageName) {
        if (pageName instanceof String) {
            return (String) pageName;
        } else if (pageName instanceof Page) {
            return ((Page) pageName).getPageName();
        }
        return null;
    }

    @Step
    public void shouldPageBeExisted(Object pageName) {
        String pageNameText = getPageName(pageName);
        logInfo("Verify " + pageNameText + " page is displayed with another valid user");
        $x(String.format(pageNameInMenuXpath, pageNameText)).shouldBe(visible);
    }

    @Step
    public void selectPage(Object pageName){
        String pageNameText = getPageName(pageName);
        logInfo("Select page: " + pageNameText);
        $x(String.format(pageNameInMenuXpath, pageNameText)).shouldBe(visible).click();
    }

    @Step
    public void deletePage(Object pageName) {
        String pageNameText = getPageName(pageName);
        logInfo("Delete " + pageNameText);

        selectPage(pageName);
        clickGlobalSettingOption(GlobalSettingOptions.DELETE);
        AlertHelper.confirmAlert();
    }

    @Step
    public void clickGlobalSettingOption(GlobalSettingOptions option) {
        logInfo("Click Setting Option " + option.getValue());
        openGlobalSettingMenu();
        String globalSettingOptionXpath = "//div[@id='main-menu']//li[@class='mn-setting']//a[contains(text(),'%s')]";
        $x(String.format(globalSettingOptionXpath,option.getValue())).click();
    }

    @Step
    private void openGlobalSettingMenu() {
        logInfo("Select Global Setting");
        globalSettingBtn.shouldBe(visible).hover();
    }

    @Step
    public void openDataProfile(){
        logInfo("Open panel manager");
        administerLink.hover();
        dataProfilesBtn.click();
    }


}
