package seleniummaster;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Capabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author : user
 * @created : 24.11.2023,23:19
 * @Email :aliyeidiris@gmail.com
 **/
public class AppiumBasics extends BaseTest {
    @Test
    public void wifiSettingsName() throws MalformedURLException {
        //AndroidDriver, IOSDriver
        //Appium code -> Appium server -> Mobile
        //Xpath, id, accessibilityId, classname, androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        //set wifi name
    }
}
