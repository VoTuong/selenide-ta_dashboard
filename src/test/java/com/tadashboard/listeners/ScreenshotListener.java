package com.tadashboard.listeners;


import com.codeborne.selenide.Selenide;
import com.epam.reportportal.service.ReportPortal;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import utilities.LoggingUtils;

import java.io.File;
import java.util.Date;

@Listeners({ReportPortalTestNGListener.class})
public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // Call the super method to keep ReportPortal integration
        ITestListener.super.onTestFailure(result);

        // Take a screenshot
        File screenshot = Selenide.screenshot(OutputType.FILE);

        // Log the screenshot to ReportPortal
        String message = result.getTestName() + " + " + result.getMethod().getMethodName();
        if(screenshot != null){
            LoggingUtils.log(screenshot, message);
            ReportPortal.emitLog(message, "ERROR", new Date(), screenshot);
        }
    }

}

