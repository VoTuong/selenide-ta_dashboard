package com.tadashboard.tests;

import com.tadashboard.dataprovider.TestDataProviders;
import com.tadashboard.enums.Repository;
import com.tadashboard.model.page.Page;
import com.tadashboard.model.user.User;
import com.tadashboard.pages.HomePage;
import com.tadashboard.pages.LoginPage;
import com.tadashboard.pages.PagePrompt;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCaseTC014 extends BaseTest{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    PagePrompt pagePrompt = new PagePrompt();
    private Page createdPage;
    private User adminUser;


    @Test(testName = "DA_MP_TC014: Verify that 'Public' pages can be visible and accessed by all users of working repository",
            dataProvider = "DA_MP_TC014", dataProviderClass = TestDataProviders.class)
    public void DA_MP_TC014(User validUser, User validUser2, Page pagePublic) {
        this.createdPage = pagePublic;
        this.adminUser = validUser;

        loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), validUser);

        pagePrompt.createPage(pagePublic);

        homePage.logout();

        loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), validUser2);

        homePage.shouldPageBeExisted(pagePublic.getPageName());
    }

    @AfterMethod
    public void clearCreatedPage(ITestResult result){
        homePage.logout();
        loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), adminUser);
        if (createdPage != null) {
            homePage.deletePage(createdPage);
        }
    }
}
