package com.tadashboard.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.TextReport;
import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            // Take screenshot on failure
            File screenshotFile = new File(Objects.requireNonNull(Selenide.screenshot("screenshot")));
            System.out.println(screenshotFile);
            String screenshotPath = screenshotFile.getPath();
//            String screenshotPath = Selenide.screenshot("screenshot");
            System.out.println(screenshotPath);
            try {
                byte[] screenshotBytes = Files.readAllBytes(Paths.get(screenshotPath));
                attachScreenshot(screenshotBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("Finished {} TestNG tests in {}", getClass().getName(), Configuration.browser);
        Selenide.closeWebDriver();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private void attachScreenshot(byte[] screenshot) {
    }

//    private final static String selenideProperties = "selenide.properties";
//
//    @BeforeClass
//    protected void setupClass() throws IOException {
//        /*
//         * Load selenide.properties file in resources
//         */
//        Properties props = new Properties();
//        InputStream inputStream = BaseTest.class
//                .getClassLoader()
//                .getResourceAsStream(selenideProperties);
//        props.load(inputStream);
//
//        if (!props.isEmpty()) {
//            for (Object propObj : props.keySet()) {
//                String prop = String.valueOf(propObj);
//
//                if (!System.getProperties().containsKey(prop)) {
//                    System.setProperty(prop, props.getProperty(prop));
//                }
//            }
//        }
//
//        logger.info("Loading selenide properties as {}", selenideProperties);
//        TextReport.onSucceededTest = false;
//        TextReport.onFailedTest = true;
//        Configuration.headless = false;    // Ensure the browser is not in headless mode
//        logger.info("Start {} TestNG tests in {}", getClass().getName(), Configuration.browser);
//        open("/");
//    }


}
