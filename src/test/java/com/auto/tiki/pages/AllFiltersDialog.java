package com.auto.tiki.pages;

import com.auto.tiki.enums.FilterContainers;
import com.auto.tiki.enums.Offers;
import com.auto.tiki.enums.Suppliers;
import com.auto.tiki.model.Filter;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AllFiltersDialog {

    private final SelenideElement fromPriceTextbox = $x("//input[@placeholder='Từ']");
    private final SelenideElement toPriceTextbox = $x("//input[@placeholder='Đến']");
    private final SelenideElement seeResultFilterButton = $("div.styles__StyledButton-sc-1fz54eb-6.jRxpbN");
    private final SelenideElement allFilterDialog = $x("//div[div[div[text()='Tất cả bộ lọc']] and @class='styles__StyledContentModal-sc-1fz54eb-2 kvMVpg']");

    @Step("Fill in All filters dialog")
    public void fillInAllFiltersDialog(Filter filter) {
        if (filter.getOffers() != null) selectOffer(filter);
        enterPriceRange(filter);

        if (filter.getSuppliers()!=null) selectSupplier(filter);
    }

    public void selectOffer(Filter filter) {
        if (filter.getOffers() == Offers.TOP_DEAL) {
            $x("(//div[h4[contains(text(), 'Ưu đãi')]]//span[not(text()='Siêu rẻ')])[1]").click();
        } else if (filter.getOffers() == Offers.FREE_SHIP){
            $x("(//div[h4[contains(text(), 'Ưu đãi')]]//span[not(text()='Siêu rẻ')])[2]").click();
        }
    }

    public void selectSupplier(Filter filter) {
        scrollToCategory(FilterContainers.SUPPLIER.getValue());
        clickViewMoreButton(FilterContainers.SUPPLIER.getValue());
        for (Suppliers supplier : filter.getSuppliers()) {
            clickCheckboxItem(FilterContainers.SUPPLIER.getValue(), supplier.getValue());
        }
    }

    @Step("Enter price range in Filter popup: \"{filter.minimumPrice}\" to \"{filter.maximumPrice}\"")
    private void enterPriceRange(Filter filter) {
        if (filter.getMinimumPrice() > 0) {
            fromPriceTextbox.scrollTo().setValue(String.valueOf(filter.getMinimumPrice()));
        }
        if (filter.getMaximumPrice() > 0) {
            toPriceTextbox.scrollTo().setValue(String.valueOf(filter.getMaximumPrice()));
        }
    }

    @Step("Click on See result button")
    public void clickOnSeeResulFilterButton() {
        seeResultFilterButton.should(visible).click();
        executeJavaScript("window.scrollTo(0, 0);");
    }

    private void clickViewMoreButton(String category) {
        String viewMoreButton = "//div[h4[text()='%s']]//a[text()='Xem thêm']";
        $x(String.format(viewMoreButton, category)).should(visible).click();
    }

    private void scrollToCategory(String category) {
        String groupFilterLabel = "//div[@data-view-label='%s']";
        $x(String.format(groupFilterLabel, category)).should(visible).scrollTo();
    }
    private void clickCheckboxItem(String category, String option) {
        String itemFilterCheckbox = "//div[h4[text()='%s']]//span[text()='%s']/../preceding-sibling::div//span";
        $x(String.format(itemFilterCheckbox, category, option)).should(visible).scrollTo().click();
    }

    public void shouldAllFiltersDialogDisplayed(){
        allFilterDialog.shouldBe(visible);
    }

}
