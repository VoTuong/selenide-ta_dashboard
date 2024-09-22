package com.tadashboard.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    // Define Selenide elements using locators
    private final SelenideElement usernameLbl = $x("//div[@id='header']//a[@href='#Welcome']");
    private final SelenideElement mainMenu = $("#main-menuA");
    private final SelenideElement logoutBtn = $x("//a[text()='Logout']");


    public boolean isMainMenuDisplayed() {
        return mainMenu.isDisplayed();
    }

    public void logout() {
        if (usernameLbl.isDisplayed()){
            usernameLbl.hover();
            logoutBtn.shouldBe(visible).click();
        }

    }
}
