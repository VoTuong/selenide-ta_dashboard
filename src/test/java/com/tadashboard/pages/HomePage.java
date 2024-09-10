package com.tadashboard.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    // Define Selenide elements using locators
    private final SelenideElement mainMenu = $("#main-menu");
    private final SelenideElement helpOption = $x("//ul[@class='head-menu']//li[@class='hasbg h-help']");
//    private final SelenideElement labManagerOption = $x("//ul[@class='head-menu']//li[@class='hasbg h-lab']");

    public boolean isMainMenuDisplayed() {
        return mainMenu.isDisplayed();
    }

    public boolean isHelpOptionDisplayed() {
        return helpOption.isDisplayed();
    }
}
