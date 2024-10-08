package com.auto.tiki.pages;


import com.auto.tiki.model.Product;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static utilities.NumberUtils.parseCurrencyToInt;

public class ProductListPage extends HomePage {

    private final SelenideElement listProducts = $x("//div[@class = 'CatalogProducts__Wrapper-sc-1r8ct7c-0 jOZPiC']");
    private final SelenideElement veryCheapCheckbox = $x("//div[span[text()='Siêu rẻ']]/preceding-sibling::div[@class='style__CheckboxV2Container-sc-1ewjwu4-3 hqFudj']/span");


//    public List<Product> getListOfProducts() {
//        return listProducts.stream().map(element -> {
//            String name = element.findElement(By.xpath("./descendant::h3")).getText().toLowerCase();
//            boolean isTopDeal;
//            try {
//                element.findElement(By.xpath("./descendant::img[contains(@class, 'styles__StyledImg-sc-p9s3t3-0 hbqSye') and @alt='is_hero']"));
//                isTopDeal = true;
//            } catch (Exception e) {
//                isTopDeal = false;
//            }
//            String priceString = element.findElement(By.xpath("./descendant::div[@class='price-discount__price']")).getText();
//            int price = parseCurrencyToInt(priceString);
//            return new Product(
//                    name,
//                    isTopDeal,
//                    price
//            );
//        }).collect(Collectors.toList());
//    }

    public List<Product> getListOfProducts() {
        Selenide.sleep(1000); // Set sleep time to avoid StaleElementReferenceException
        listProducts.shouldBe(visible, Duration.ofSeconds(10));

        List<SelenideElement> productElements = listProducts.$$x("div").stream().toList();
        List<Product> products = new ArrayList<>();

        for (SelenideElement element : productElements) {

            String name = element.$x(".//h3").shouldBe(visible, Duration.ofSeconds(10)).getText();

            boolean isTopDeal = true;

            String priceString = element.$("div.price-discount__price").shouldBe(visible).getText();
            int price = parseCurrencyToInt(priceString);

            products.add(new Product(name, isTopDeal, price));
        }

        return products;
    }

//    public List<Product> getListOfProducts() {
//        Selenide.sleep(2000);
//        ElementsCollection listProducts = $$("div.CatalogProducts__Wrapper-sc-1r8ct7c-0 > div");
//        List<SelenideElement> productElements = listProducts.stream().toList();
//        List<Product> products = new ArrayList<>();
//
//        for (int i = 0; i < productElements.size(); i++) {
//            SelenideElement element = productElements.get(i);
//            boolean success = false;
//            int attempts = 0;
//
//            while (!success && attempts < 3) {
//                try {
//                    element = element.shouldBe(Condition.visible, Duration.ofSeconds(10));
//
//                    String name = element.$("h3")
//                            .shouldBe(Condition.visible, Duration.ofSeconds(10)).getText();
//
//                    boolean isTopDeal = true;
//
//                    String priceString = element.$("div.price-discount__price")
//                            .shouldBe(Condition.visible).getText();
//                    String cleanedPriceString = priceString.replaceAll("[^\\d]", "");
//                    int price = parseCurrencyToInt(cleanedPriceString);
//
//                    products.add(new Product(name, isTopDeal, price));
//                    success = true;
//                } catch (StaleElementReferenceException e) {
//                    // Re-locate the element and retry
//                    element = listProducts.stream().toList().get(i);
//                    attempts++;
//                }
//            }
//
//            if (!success) {
//                throw new RuntimeException("Failed to retrieve product details after multiple attempts");
//            }
//        }
//
//        return products;
//    }

    public Product getRandomProduct() {
        List<Product> products = getListOfProducts();
        if (products.isEmpty()) {
            System.out.println("No random products");
            throw new IllegalStateException("No products found");
        }
        Collections.shuffle(products);
        return products.get(0);
    }

    public int getProductPrice(String productName) {
        String productPriceLabel = "//div[div[div[h3[text()='%s']]]]//div[@class='price-discount__price']";
        String priceString = $x(String.format(productPriceLabel, productName)).should(visible).getText();
        return parseCurrencyToInt(priceString);
    }

    @Step("Click on item: \"{productName}\"")
    public void clickOnProductItem(String productName) {
        String productLink = "//a[@data-view-id='product_list_item']//h3[text()='%s']";
        $x(String.format(productLink, productName)).should(visible).click();
    }

    public boolean isFilterOptionUnderCategoryHighlight(String category, String option) {
        String filterOptionUnderCategory = "//div[div[text()='%s']]//button[div[text()='%s']]";
        return Objects.requireNonNull($x(String.format(filterOptionUnderCategory, category, option)).should(visible).getAttribute("Class")).contains("ksuoUg");
    }

    public boolean isVeryCheapCheckboxChecked() {
        return veryCheapCheckbox.is(checked);
    }
}
