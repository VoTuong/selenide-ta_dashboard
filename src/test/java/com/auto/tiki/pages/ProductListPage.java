package com.auto.tiki.pages;

import com.auto.tiki.model.Product;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static utilities.NumberUtils.parseCurrencyToInt;

public class ProductListPage extends HomePage {

    private final SelenideElement listProducts = $x("//div[@class = 'CatalogProducts__Wrapper-sc-1r8ct7c-0 jOZPiC']");

    public List<Product> getListOfProducts() {
        waitForPageLoad();
        listProducts.shouldBe(visible, Duration.ofSeconds(10));
        List<SelenideElement> productElements = listProducts.$$x("div").stream().toList();

        System.out.println(productElements);
        List<Product> products = new ArrayList<>();
        for (SelenideElement element : productElements) {
            String name = element.$x(".//h3").shouldBe(visible, Duration.ofSeconds(10)).getText();
            String priceString = element.$("div.price-discount__price").shouldBe(visible).getText();
            int price = parseCurrencyToInt(priceString);
            products.add(new Product(name, price));
        }
        return products;
    }

    @Step("Click on random product")
    public Product getRandomProduct() {
        List<Product> products = getListOfProducts();
        if (products.isEmpty()) {
            System.out.println("No random products");
            throw new IllegalStateException("No products found");
        }
        Collections.shuffle(products);
        return products.get(0);
    }

    @Step("Click on item: \"{productName}\"")
    public void clickOnProductItem(String productName) {
        String productLink = "//a[@data-view-id='product_list_item']//h3[text() = '%s']";
        $x(String.format(productLink, productName)).should(visible).click();
    }

    @Step("Check category: \"{category}\" with value: \"{option}\"")
    public boolean isFilterOptionUnderCategoryHighlight(String category, String option) {
        String filterOptionUnderCategory = "//div[div[text()='%s']]//button[div[text()='%s']]";
        return Objects.requireNonNull($x(String.format(filterOptionUnderCategory, category, option)).should(visible)
                .getAttribute("Class")).contains("ksuoUg");
    }
}
