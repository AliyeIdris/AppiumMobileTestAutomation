package seleniummaster;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.testng.Assert;
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
        //tagName[@attribute='value']
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Aliye wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        //set wifi name
    }
}
