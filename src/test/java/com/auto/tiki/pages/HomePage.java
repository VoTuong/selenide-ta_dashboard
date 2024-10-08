package com.auto.tiki.pages;

import com.auto.tiki.enums.LeftMenu;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private final SelenideElement searchTextbox = $x("//input[@data-view-id='main_search_form_input']");
    private final SelenideElement searchButton = $x("//button[@data-view-id='main_search_form_button']");
    private static final SelenideElement advertisementPopUp = $("img[alt='close-icon']");
    private final SelenideElement breadcrumb = $("div.breadcrumb");
    private final SelenideElement pageTitle = $("h1");


    @Step("Close popup advertisement")
    public static void closePopupAdvertisement() {
        if (advertisementPopUp.exists()) {
            advertisementPopUp.click();
        }
    }

    @Step("Check if Search textbox is displayed")
    public void shouldSearchTextboxDisplayed() {
        searchTextbox.shouldBe(visible);
    }

    @Step("Check if Search button is displayed")
    public void shouldSearchButtonDisplayed() {
        searchButton.shouldBe(visible);
    }

    @Step("Enter \"{keyword}\" in search textbox")
    public void enterValueInSearchTextBox(String keyword) {
        searchTextbox.setValue(keyword);
    }

    @Step("Click on Search button")
    public void clickOnSearchButton() {
        searchButton.click();
    }

    @Step("Select left menu: \"{menu.value}\"")
    public void selectLeftMenu(LeftMenu menu) {
        String leftMenuLink = "//div[@class='styles__StyledItemV2-sc-oho8ay-1 bHIPhv']//div[text()='%s']";
        $x(String.format(leftMenuLink, menu.getValue())).should(visible).click();
//        PageUtils.waitForPageLoad();
    }

    @Step("Get current breadcrumb text")
    public String getBreadcrumbText() {
        String breadcrumbText = breadcrumb.getText();
        return breadcrumbText.replaceAll("\n", " > ");
    }

    @Step("Method to verify page title")
    public boolean verifyPageTitle(String expectedTitle) {
        return Objects.requireNonNull(pageTitle.getAttribute("textContent")).contains(expectedTitle);
    }

}
