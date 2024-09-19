package utilities;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.tadashboard.constants.Constants;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;

public class AlertHelper {

    private static final Logger log = LoggerFactory.getLogger(lookup().lookupClass() );

//    /**
//     * To click on the 'Cancel' button of the alert.
//     */
//    public static void dismissAlert() {
//        if (isAlertPresent())
//            Selenide.dismiss();
//    }

//    /**
//     * To click on the 'OK' button of the alert.
//     */
//    public static void confirmAlert() {
//        waitForAlertVisible();
//        Selenide.confirm();
//    }

    /**
     * To get the alert message.
     */
    public static String getTextAlert() {
        waitForAlertVisible();
        String alertText = Selenide.switchTo().alert().getText();
        log.info("The alert message gotten: {}", alertText);
        return alertText;
    }

    /**
     * To wait for the alert appear.
     */
    public static void waitForAlertVisible() {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(Constants.SHORT_TIME));
        wait.until(ExpectedConditions.alertIsPresent());
    }

//    public static boolean isAlertPresent() {
//        try {
//            waitForAlertVisible();
//            Selenide.switchTo().alert();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

}
