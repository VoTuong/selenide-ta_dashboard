package com.auto.tiki.tests;

import com.auto.tiki.dataproviders.DataForTestFactory;
import com.auto.tiki.enums.DoDungNhaBepCategory;
import com.auto.tiki.enums.LeftMenu;
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

public class Final002Tests extends BaseTest {
    HomePage homePage = new HomePage();
    ProductListPage productListPage = new ProductListPage();
    ProductCategoryPage productCategoryPage = new ProductCategoryPage();
    AllFiltersDialog filterDialog = new AllFiltersDialog();
    SoftAssert softAssert = new SoftAssert();
    SoftAssertions softAssertions = new SoftAssertions();


    @Test(description = "Verify user can filter search condition for product", dataProvider = "TestCase002", dataProviderClass = DataForTestFactory.class)
    public void TestCase002(String pageTitle, String expectedBreadcrumb, Filter filter) {

        homePage.selectLeftMenu(LeftMenu.DIEN_GIA_DUNG);
        productCategoryPage.selectCategoryItem(DoDungNhaBepCategory.LO_VI_SONG);

        softAssert.assertEquals(productCategoryPage.getBreadcrumbText(), expectedBreadcrumb,
                "Breadcrumb is not displayed correctly " + expectedBreadcrumb);
        softAssert.assertTrue(homePage.verifyPageTitle(pageTitle));

        productCategoryPage.clickOnAllFiltersButton();
        filterDialog.shouldAllFiltersDialogDisplayed();

        filterDialog.fillInAllFiltersDialog(filter);
        filterDialog.clickOnSeeResulFilterButton();

        List<Product> products = productListPage.getListOfProducts();

//        softAssert.assertTrue(productListPage.isFilterOptionUnderCategoryHighlight("Nhà cung cấp","Tiki Trading"),
//                "Verify that Nhà cung cấp: Tiki Trading is highlight");
//        softAssert.assertTrue(productListPage.isVeryCheapCheckboxChecked(),
//                "Verify that TOP DEAL Siêu Rẻ is checked");
        softAssertions.assertThat(products).allMatch(product -> product.getName().contains("Lò vi Sóng"),
                " Verify that the name of all displayed items in the result grid contains Lò Vi Sóng");
        softAssertions.assertThat(products).allMatch(product -> product.getPrice() >= filter.getMinimumPrice() && product.getPrice() <= filter.getMaximumPrice(),
                "Verify that the price of all displayed items in the result grid is within the range 1.000.000đ - 1.700.000đ");

        softAssertions.assertAll();
        softAssert.assertAll();
    }
}
