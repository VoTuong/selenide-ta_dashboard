package com.tadashboard.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    // Define Selenide elements using locators
    private final SelenideElement usernameLbl = $x("//div[@id='header']//a[@href='#Welcome']");
    private final SelenideElement mainMenu = $("#main-menu");
    private final SelenideElement userMenu = $x("//a[contains(text(),'%s')]");


    public boolean isMainMenuDisplayed() {
        return mainMenu.isDisplayed();
    }

    public void logout() {
        usernameLbl.click();
        userMenu.setValue("Logout").click();
    }
}
