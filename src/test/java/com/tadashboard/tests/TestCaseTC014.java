package com.tadashboard.tests;

import com.google.gson.JsonObject;
import com.tadashboard.dataprovider.UserDataProviderFactory;
import com.tadashboard.enums.Repository;
import com.tadashboard.model.page.Page;
import com.tadashboard.model.user.User;
import com.tadashboard.pages.HomePage;
import com.tadashboard.pages.LoginPage;
import com.tadashboard.pages.PagePrompt;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.FileUtils;
import utilities.JsonUtils;

import static com.tadashboard.constants.Constants.DATA_PATH_ROOT;

public class TestCaseTC014 extends BaseTest{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    PagePrompt pagePrompt = new PagePrompt();
    private Page createdPage;

    private static final String pageJSONPath = FileUtils.getCurrentDir() + DATA_PATH_ROOT + "pages.json";
    private static final JsonObject pageDataObject = JsonUtils.getJsonObjects(pageJSONPath);

    @DataProvider(name = "DA_MP_TC014")
    public static Object[][] dataForTC014() {
        User validUser = (User) UserDataProviderFactory.validUser()[0][0];
        User validUser2 = (User) UserDataProviderFactory.validUser2()[0][0];
        JsonObject pageData = pageDataObject.getAsJsonObject("PUBLIC_PAGE");

        Page publicPage = JsonUtils.convertJsonToObjects(pageData, Page.class);
        return new Object[][]{
                {validUser, validUser2, publicPage}
        };
    }

    @Test(testName = "DA_MP_TC014: Verify that 'Public' pages can be visible and accessed by all users of working repository", dataProvider = "DA_MP_TC014")
    public void DA_MP_TC014(User validUser, User validUser2, Page pagePublic) {
        this.createdPage = pagePublic;

        loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), validUser);

        pagePrompt.createPage(pagePublic);

        homePage.logout();

        loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), validUser2);

        Assert.assertTrue(homePage.isPageExisted(pagePublic.getPageName()), "Verify " + pagePublic.getPageName() + " page is displayed with another valid user");
    }

    @AfterMethod
    public void clearCreatedPage(ITestResult result){
        if (createdPage != null) {
            homePage.deletePage(createdPage);
        }
    }
}
