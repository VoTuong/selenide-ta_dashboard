package org.tadashboard.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.TextReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tadashboard.pages.HomePage;
import org.tadashboard.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @BeforeClass
    public void setUp() {
        Configuration.browser = "edge";
        TextReport.onSucceededTest = false;
        TextReport.onFailedTest = true;
        Configuration.headless = false;    // Ensure the browser is not in headless mode
        log.info("Start {} TestNG tests in {}", getClass().getName(), Configuration.browser);
        open("http://localhost/TADashboard/login.jsp");
    }

    @AfterClass
    final void finishTestClass() {
        log.info("Finished {} TestNG tests in {}", getClass().getName(), Configuration.browser);
    }

    @Test
    public void successfulLoginTest() {
        // Arrange
        String repository = "SampleRepository";  // Replace with an actual repository name
        String username = "administrator";  // Replace with a valid username
        String password = "";  // Replace with a valid password
        LoginPage loginPage = new LoginPage();

        // Act
        HomePage homePage = loginPage.login(repository, username, password);

        sleep(2000);

        // Assert
//        assertTrue(homePage.isHelpOptionDisplayed(), "Help option is not displayed.");
        assertTrue(homePage.isMainMenuDisplayed(), "Lab Manager option is not displayed.");
    }
}
