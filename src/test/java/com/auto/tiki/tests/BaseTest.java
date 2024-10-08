package com.auto.tiki.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.epam.reportportal.selenide.ReportPortalSelenideEventListener;
import com.epam.reportportal.service.ReportPortal;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utilities.PropertiesUtils;

import java.io.File;
import java.util.Date;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;
import static java.lang.invoke.MethodHandles.lookup;

public class BaseTest {
    private static final Logger log = LoggerFactory.getLogger(lookup().lookupClass());

    static {
        SelenideLogger.addListener(
                "ReportPortal logger",
                new ReportPortalSelenideEventListener().enableSeleniumLogs(LogType.BROWSER, Level.FINER).logScreenshots(true).logPageSources(false)
        );
    }

    @Parameters({"browser", "runMode"})
    @BeforeClass
    public void setUp(String browser, String runMode) {
        if ("grid".equalsIgnoreCase(runMode)) {
            Configuration.remote = "http://localhost:4444/";
        }
        switch (browser.toLowerCase()) {
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "edge":
                Configuration.browser = "edge";
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        Configuration.headless = false;
        Configuration.timeout = Long.parseLong(PropertiesUtils.getValue("TIME_OUT"));
        log.info("Start {} TestNG tests in {}", getClass().getName(), Configuration.browser);
    }

    @BeforeMethod
    public void launch() {
        open("https://tiki.vn/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        com.auto.tiki.pages.HomePage.closePopupAdvertisement();

    }

    @AfterMethod
    public void tearDown() {
        log.info("Finished {} TestNG tests in {}", getClass().getName(), Configuration.browser);
        Selenide.closeWebDriver();
    }

    @AfterMethod
    public void addAttachmentOnFailure(ITestResult testResult){
        if (!testResult.isSuccess()) {
            if (WebDriverRunner.getWebDriver() instanceof TakesScreenshot) {
                File screenshot = screenshot(OutputType.FILE);
                ReportPortal.emitLog("Test failed - Screenshot attached " + testResult.getMethod().getMethodName(), "ERROR", new Date(), screenshot);
            }
        }
    }

}
