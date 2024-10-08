package com.auto.tiki.pages;


import com.auto.tiki.enums.DoDungNhaBepCategory;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductCategoryPage extends HomePage {

    private final SelenideElement allFiltersButton = $("button.styles__StyledButton-sc-kqbl3f-0.bQYwcw");

    @Step("Click on All filters button")
    public void clickOnAllFiltersButton() {
        allFiltersButton.shouldBe(visible).click();
    }

    @Step("Select category item name \"{item.value}\"")
    public void selectCategoryItem(DoDungNhaBepCategory item) {
        String categoryItemLink = "//div[@class='styles__TreeSubItem-sc-1uq9a9i-6 divFYE']//a[text()='%s']";
        $x(String.format(categoryItemLink, item.getValue())).should(visible).click();
    }

}
