package com.auto.tiki.tests;

import com.auto.tiki.enums.LeftMenu;
import com.auto.tiki.pages.HomePage;
import com.auto.tiki.pages.ProductCategoryPage;
import com.auto.tiki.pages.ProductDetailsPage;
import com.auto.tiki.pages.ProductListPage;
import org.testng.annotations.Test;

public class Final002Tests extends BaseTest {
    HomePage homePage = new HomePage();
    ProductListPage productListPage = new ProductListPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    ProductCategoryPage productCategoryPage = new ProductCategoryPage();

    @Test(description = " Verify viewed item displays in the \"Sản phẩm đã xem\" section")
    public void TestCase002() {

        homePage.closePopupAdvertisement();
        homePage.selectLeftMenu(LeftMenu.SPORTS_OUTDOORS);

        productListPage.clickOnProductItem(productListPage.getRandomProduct().getName());

        String selectedRandomProductName = productDetailsPage.getProductTitle();
        homePage.backToPreviousPage();
        productCategoryPage.selectRandomItemContainer();

        homePage.shouldProductDisplayListRecently(selectedRandomProductName);

    }
}
