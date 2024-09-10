package com.tadashboard.tests;

import com.tadashboard.pages.HomePage;
import com.tadashboard.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

//    static {
//        SelenideLogger.addListener("Report Portal logger",
//                new ReportPortalSelenideEventListener().logScreenshots(false).logPageSources(false));
//    }

//    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    String repository = "SampleRepository";  // Replace with an actual repository name
    String username = "administrator";  // Replace with a valid username
    String password = "";  // Replace with a valid password

    @Test(/*retryAnalyzer = utilities.RetryAnalyzer.class*/)
    public void successfulLoginTest() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage();

        HomePage homePage = loginPage.login(repository, username, password);

        softAssert.assertTrue(homePage.isHelpOptionDisplayed(), "Help Option is not displayed.");
        softAssert.assertTrue(homePage.isMainMenuDisplayed(), "Main Menu is not displayed.");
    }
}
