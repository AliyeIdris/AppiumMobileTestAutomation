package seleniummaster.iosappautomation;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : user
 * @created : 27.12.2023,11:17
 * @Email :aliyeidiris@gmail.com
 **/
public class IOSLongPress extends IOSBaseTest{
    @Test
    public void longPressTest(){
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
        WebElement element=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Increment'`][3]"));
        Map<String,Object> params=new HashMap<>();
        params.put("element", ((RemoteWebElement)element).getId());
        params.put("duration",5);
        driver.executeScript("mobile:touchAndHold",params);
    }
}
