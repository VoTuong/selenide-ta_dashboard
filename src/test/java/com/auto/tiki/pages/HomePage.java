package com.auto.tiki.pages;

import com.auto.tiki.enums.LeftMenu;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private final SelenideElement advertisementPopUp = $("img[alt='close-icon']");
    private final SelenideElement breadcrumb = $("div.breadcrumb");

    @Step("Close popup advertisement")
    public void closePopupAdvertisement() {
        if (advertisementPopUp.exists()) {
            advertisementPopUp.click();
        }
    }

    @Step("Back to previous page")
    public void backToPreviousPage(){
        Selenide.back();
    }

    @Step("Select left menu: \"{menu.value}\"")
    public void selectLeftMenu(LeftMenu menu) {
        String leftMenuLink = "//div[@class='styles__StyledItemV2-sc-oho8ay-1 bHIPhv']//div[text()='%s']";
        $x(String.format(leftMenuLink, menu.getValue())).should(visible).click();
    }

    @Step("Get current breadcrumb text")
    public String getBreadcrumbText() {
        String breadcrumbText = breadcrumb.getText();
        return breadcrumbText.replaceAll("\n", " > ");
    }

    @Step("Should the recently visited products: \"{productName}\" display in Recently Container")
    public void shouldProductDisplayListRecently(String productName){
        String productRecentlyList = "//div[@data-view-id='product_list_recently_view_container']//h3[text() = '%s']";
        $x(String.format(productRecentlyList, productName)).shouldBe(visible);
    }

    public void waitForPageLoad() {
        Selenide.sleep(2000);
    }

}
