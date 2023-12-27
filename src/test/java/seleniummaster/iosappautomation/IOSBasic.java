package seleniummaster.iosappautomation;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

/**
 * @author : user
 * @created : 27.12.2023,11:17
 * @Email :aliyeidiris@gmail.com
 **/
public class IOSBasic extends IOSBaseTest{
    @Test
    public void IOSBasicsTest(){
        //xpath, classname,accessibility id, id, IOS -> iosClassChain, IOSPredicateString
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();

    }
}
