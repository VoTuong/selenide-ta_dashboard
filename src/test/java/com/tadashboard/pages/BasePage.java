package com.tadashboard.pages;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.epam.reportportal.selenide.ReportPortalSelenideEventListener;
import com.epam.reportportal.service.ReportPortal;

public class BasePage{
    static {
        // enable Selenide logger and attach browser logs on step failure
        SelenideLogger.addListener(
                "ReportPortal logger",
                new ReportPortalSelenideEventListener().logScreenshots(true).logPageSources(false)
        );
    }

    public static void logInfo(String message) {
        ReportPortal.emitLog(message, "INFO", new java.util.Date());
    }



}
