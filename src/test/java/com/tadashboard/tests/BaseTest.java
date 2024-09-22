package com.tadashboard.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.epam.reportportal.listeners.LogLevel;
import com.epam.reportportal.selenide.ReportPortalSelenideEventListener;
import com.epam.reportportal.service.ReportPortal;
import com.tadashboard.pages.HomePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.Date;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;
import static java.lang.invoke.MethodHandles.lookup;

public class BaseTest {

    static {
        // enable Selenide logger and attach browser logs on step failure
        SelenideLogger.addListener(
                "ReportPortal logger",
                new ReportPortalSelenideEventListener(LogLevel.INFO).enableSeleniumLogs(LogType.BROWSER, Level.FINER).logScreenshots(true).logPageSources(false)
        );
    }

    private static final Logger log = LoggerFactory.getLogger(lookup().lookupClass() );
    private static final HomePage homePage = new HomePage();

    @BeforeClass
    public void setUp() {
        Configuration.headless = false;    // Ensure the browser is not in headless mode
        log.info("Start {} TestNG tests in {}", getClass().getName(), Configuration.browser);
        open("http://localhost/TADashboard/login.jsp");
    }

    @BeforeMethod
    public void launch() {
        // Configure Selenide
        open("");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        // Additional Selenide setup if needed
    }

    @AfterMethod
    public void tearDown() {
        homePage.logout();
        log.info("Finished {} TestNG tests in {}", getClass().getName(), Configuration.browser);
        Selenide.closeWebDriver();
    }

    @AfterMethod
    public void addAttachmentOnFailure(ITestResult testResult){
        if (!testResult.isSuccess()) {
            if (WebDriverRunner.getWebDriver() instanceof TakesScreenshot) {
                File screenshot = screenshot(OutputType.FILE);
//                LoggingUtils.log(screenshot, "Test failed - Screenshot attached " + testResult.getMethod().getMethodName());
                ReportPortal.emitLog("Test failed - Screenshot attached " + testResult.getMethod().getMethodName(), "ERROR", new Date(), screenshot);
            }
        }
    }

}
