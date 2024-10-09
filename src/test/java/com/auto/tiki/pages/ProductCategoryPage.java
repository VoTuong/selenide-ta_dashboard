package com.auto.tiki.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class ProductCategoryPage extends HomePage {

    private final SelenideElement allFiltersButton = $("button.styles__StyledButton-sc-kqbl3f-0.bQYwcw");

    @Step("Click on All filters button")
    public void clickOnAllFiltersButton() {
        allFiltersButton.shouldBe(visible).click();
    }

    @Step("Select category item name randomly")
    public void selectRandomItemContainer() {
        String categoryItemContainer = "//div[@class='styles__TreeName-sc-1uq9a9i-3 hFhoJP']";
        System.out.println($$x(categoryItemContainer).size());
        Random random = new Random();
        int randomNum = random.nextInt($$x(categoryItemContainer).size());
        System.out.println(randomNum);
        $$x(categoryItemContainer).get(randomNum).click();
    }

}
