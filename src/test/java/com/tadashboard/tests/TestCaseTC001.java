package com.tadashboard.tests;


import com.tadashboard.dataprovider.TestDataProviders;
import com.tadashboard.enums.Repository;
import com.tadashboard.model.user.User;
import com.tadashboard.pages.HomePage;
import com.tadashboard.pages.LoginPage;
import org.testng.annotations.Test;


public class TestCaseTC001 extends BaseTest{

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test(retryAnalyzer = utilities.RetryAnalyzer.class,
            dataProvider = "validUser", dataProviderClass = TestDataProviders.class)
    public void DA_LOGIN_TC001(User validUser) {

        loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), validUser);

        homePage.shouldMainMenuDisplay();
    }

}
