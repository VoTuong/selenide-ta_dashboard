package com.tadashboard.tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import com.epam.reportportal.selenide.ReportPortalSelenideEventListener;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddAttachmentTest{

    private static final By MY_NON_EXISTENT_LOCATOR = By.xpath("//button[@type='submit']");

    static {
        // enable Selenide logger and attach browser logs on step failure
        SelenideLogger.addListener(
                "ReportPortal logger",
                new ReportPortalSelenideEventListener().enableSeleniumLogs(LogType.BROWSER, Level.FINER)
        );
    }

    @Test
    public void testTitle() {
        open("https://www.example.com");
        Assert.assertEquals($(MY_NON_EXISTENT_LOCATOR).getText(), "Proceed");
    }


}
