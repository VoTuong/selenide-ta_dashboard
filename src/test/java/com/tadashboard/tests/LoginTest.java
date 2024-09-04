package com.tadashboard.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.TextReport;
import com.epam.reportportal.selenide.ReportPortalSelenideEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tadashboard.pages.HomePage;
import com.tadashboard.pages.LoginPage;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;

public class LoginTest {

    static {
        SelenideLogger.addListener("Report Portal logger",
                new ReportPortalSelenideEventListener().logScreenshots(false).logPageSources(false));
    }

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    String repository = "SampleRepository";  // Replace with an actual repository name
    String username = "administrator";  // Replace with a valid username
    String password = "";  // Replace with a valid password

    @BeforeClass
    public void setUp() {
        Configuration.browser = "edge";
        TextReport.onSucceededTest = false;
        TextReport.onFailedTest = true;
        Configuration.headless = false;    // Ensure the browser is not in headless mode
        log.info("Start {} TestNG tests in {}", getClass().getName(), Configuration.browser);
        open("http://localhost/TADashboard/login.jsp");
    }

//    @AfterTest
//    final void finishMethod(){
//        closeWindow();
//    }

    @AfterClass
    final void finishTestClass() {
        log.info("Finished {} TestNG tests in {}", getClass().getName(), Configuration.browser);
        closeWebDriver();

    }

    @Test(retryAnalyzer = utilities.RetryAnalyzer.class)
    public void successfulLoginTest() {
        // Arrange
        LoginPage loginPage = new LoginPage();

        // Act
        HomePage homePage = loginPage.login(repository, username, password);

        // Assert
        assertTrue(homePage.isHelpOptionDisplayed(), "Help option is not displayed.");
        assertFalse(homePage.isMainMenuDisplayed(), "Main menu is not displayed.");
    }
}
