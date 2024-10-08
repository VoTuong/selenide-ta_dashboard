package com.auto.tiki.tests;

import com.auto.tiki.dataproviders.DataForTestFactory;
import com.auto.tiki.pages.HomePage;
import com.auto.tiki.pages.ProductDetailsPage;
import com.auto.tiki.pages.ProductListPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Final001Tests extends BaseTest {
    HomePage homePage = new HomePage();
    ProductListPage productListPage = new ProductListPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    SoftAssert softAssert = new SoftAssert();


    @Test(description = "Verify the product information loaded correctly", dataProvider = "TestCase001", dataProviderClass = DataForTestFactory.class)
    public void TestCase001(String keyword, String expectedBreadcrumb, String pageTitle) {

        homePage.shouldSearchTextboxDisplayed();
        homePage.shouldSearchButtonDisplayed();

        homePage.enterValueInSearchTextBox(keyword);
        homePage.clickOnSearchButton();


        softAssert.assertEquals(productListPage.getBreadcrumbText(), expectedBreadcrumb,
                "Breadcrumb is not " + expectedBreadcrumb);
        softAssert.assertTrue(homePage.verifyPageTitle(pageTitle));

        String selectedRandomProductName = productListPage.getRandomProduct().getName();
        int selectedRandomProductPrice = productListPage.getProductPrice(selectedRandomProductName);

        productListPage.clickOnProductItem(selectedRandomProductName);

        softAssert.assertTrue(productDetailsPage.getProductTitle().contains(selectedRandomProductName),
                "The product title does not contain the selected product name: " + selectedRandomProductName);
        softAssert.assertEquals(productDetailsPage.getProductPrice(), selectedRandomProductPrice,
                "The product price does not match the expected price: " + selectedRandomProductPrice);

        softAssert.assertAll();
    }

}
