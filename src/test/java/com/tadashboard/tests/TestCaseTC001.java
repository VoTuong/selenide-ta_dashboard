package com.tadashboard.tests;


import com.tadashboard.enums.Repository;
import com.tadashboard.pages.HomePage;
import com.tadashboard.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCaseTC001 extends BaseTest{

    String username = "administrator";  // Replace with a valid username
    String password = "";  // Replace with a valid password

    @Test(retryAnalyzer = utilities.RetryAnalyzer.class)
    public void DA_LOGIN_TC001() {
        LoginPage loginPage = new LoginPage();

        HomePage homePage = loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), username, password);

        Assert.assertTrue(homePage.isMainMenuDisplayed(), "Main Menu is not displayed.");
    }

}
