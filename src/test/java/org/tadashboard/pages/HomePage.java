package org.tadashboard.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    // Define Selenide elements using locators
    private final SelenideElement mainMenu = $("#main-menu");
//    private final SelenideElement helpOption = $x("//ul[@class='head-menu']//li[@class='hasbg h-help']");
//    private final SelenideElement labManagerOption = $x("//ul[@class='head-menu']//li[@class='hasbg h-lab']");

    public boolean isMainMenuDisplayed() {
        return mainMenu.isDisplayed();
    }
}
