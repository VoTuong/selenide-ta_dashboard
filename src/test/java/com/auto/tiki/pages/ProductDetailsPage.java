package com.auto.tiki.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPage {
    private final SelenideElement productTitleLabel = $("h1.Title__TitledStyled-sc-c64ni5-0.iXccQY");

    @Step("Get the current product title")
    public String getProductTitle() {
        return productTitleLabel.getText();
    }

}
