package com.tadashboard.tests;


import com.tadashboard.enums.Message;
import com.tadashboard.enums.Repository;
import com.tadashboard.pages.HomePage;
import com.tadashboard.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AlertHelper;


public class LoginTest extends BaseTest{

    String username = "administrator";  // Replace with a valid username
    String password = "";  // Replace with a valid password

    @Test(retryAnalyzer = utilities.RetryAnalyzer.class)
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();

        HomePage homePage = loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), username, password);

        Assert.assertTrue(homePage.isMainMenuDisplayed(), "Main Menu is not displayed.");
    }

    @Test(retryAnalyzer = utilities.RetryAnalyzer.class)
    public void failToLoginTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), "abc", password);

        Assert.assertEquals(AlertHelper.getTextAlert(), Message.LOGIN_INVALID_INFO_ERROR_MESSAGE.getValue(), "Dashboard Error message " + "\"" + Message.LOGIN_INVALID_INFO_ERROR_MESSAGE + "\"" + " appears");
    }

}
