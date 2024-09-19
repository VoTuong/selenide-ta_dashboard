package com.tadashboard.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.TextReport;
import com.epam.reportportal.listeners.LogLevel;
import com.epam.reportportal.service.ReportPortal;
import com.tadashboard.pages.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.Date;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.invoke.MethodHandles.lookup;

/**
 * BaseTest class
 * <br/>
 *
 * @author ngoanh2n
 */

public abstract class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(lookup().lookupClass() );
    private static final HomePage homePage = new HomePage();

    @BeforeClass
    public void setUp() {
        TextReport.onSucceededTest = false;
        TextReport.onFailedTest = true;
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
    public void cleanUp() {
        homePage.logout();
    }

    @AfterClass
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            File screenshotFile = new File((Objects.requireNonNull(Selenide.screenshot("screenshot"))));
            System.out.println(screenshotFile);
            String screenshotPath = screenshotFile.getPath();
                ReportPortal.emitLog("message", LogLevel.FATAL.name(), new Date(), new File(screenshotPath.replaceFirst("(?i)^file:[/\\\\]+", "")));

        }
        log.info("Finished {} TestNG tests in {}", getClass().getName(), Configuration.browser);
        Selenide.closeWebDriver();
    }



}
