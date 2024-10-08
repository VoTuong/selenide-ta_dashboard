package com.auto.tiki.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utilities.NumberUtils;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPage {
    private final SelenideElement productTitleLabel = $("h1.Title__TitledStyled-sc-c64ni5-0.iXccQY");
    private final SelenideElement productPriceLabel = $("div.product-price__current-price");

    @Step("Get the current product title")
    public String getProductTitle() {
        return productTitleLabel.getText();
    }

    @Step("Get the current product price")
    public int getProductPrice() {
        $("div.product-price__original-price").shouldBe(visible);
        String price = productPriceLabel.getText();
        return NumberUtils.parseCurrencyToInt(price);
    }
}
