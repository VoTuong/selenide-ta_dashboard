package com.auto.tiki.tests;

import com.auto.tiki.dataproviders.DataForTestFactory;
import com.auto.tiki.enums.FilterContainers;
import com.auto.tiki.enums.LeftMenu;
import com.auto.tiki.enums.Suppliers;
import com.auto.tiki.model.Filter;
import com.auto.tiki.model.Product;
import com.auto.tiki.pages.AllFiltersDialog;
import com.auto.tiki.pages.HomePage;
import com.auto.tiki.pages.ProductCategoryPage;
import com.auto.tiki.pages.ProductListPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Final001Tests extends BaseTest {
    HomePage homePage = new HomePage();
    ProductListPage productListPage = new ProductListPage();
    ProductCategoryPage productCategoryPage = new ProductCategoryPage();
    AllFiltersDialog filterDialog = new AllFiltersDialog();
    SoftAssert softAssert = new SoftAssert();
    SoftAssertions softAssertions = new SoftAssertions();


    @Test(description = "Verify user can filter search condition for product", dataProvider = "TestCase001", dataProviderClass = DataForTestFactory.class)
    public void TestCase001(String expectedBreadcrumb, Filter filter) {

        homePage.closePopupAdvertisement();
        homePage.selectLeftMenu(LeftMenu.BOOKSTORE_TIKI);

        softAssert.assertEquals(productCategoryPage.getBreadcrumbText(), expectedBreadcrumb,
                "Breadcrumb is not displayed correctly " + expectedBreadcrumb);

        productCategoryPage.clickOnAllFiltersButton();
        filterDialog.shouldAllFiltersDialogDisplayed();

        filterDialog.fillInAllFiltersDialog(filter);
        filterDialog.clickOnSeeResulFilterButton();

        List<Product> products = productListPage.getListOfProducts();

        softAssert.assertTrue(productListPage.isFilterOptionUnderCategoryHighlight(FilterContainers.SUPPLIER.getValue(), Suppliers.SUPPLIERS_FAHASA.getValue()),
                "Error: " + FilterContainers.SUPPLIER.getValue() +": " + Suppliers.SUPPLIERS_FAHASA.getValue() + " is not highlight");


        softAssertions.assertThat(products).allMatch(product -> product.getPrice() >= filter.getMinimumPrice() && product.getPrice() <= filter.getMaximumPrice(),
                "Error: The price of all displayed items in the result grid is not in the range 60.000đ - 140.000đ");

        softAssertions.assertAll();
        softAssert.assertAll();
    }

}
