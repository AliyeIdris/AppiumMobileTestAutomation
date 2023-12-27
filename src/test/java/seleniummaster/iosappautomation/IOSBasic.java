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

        //xpath is very slow in ios,so iosClassChain is the better option
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Text Entry'`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField")).sendKeys("Hello");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();

        //3 ways to write IOSPredicateString
        //driver.findElement(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND value=='Confirm / Cancel'"));
        driver.findElement(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
        //driver.findElement(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND value ENDSWITH[c] 'cancel'"));

        String text=driver.findElement(AppiumBy.iOSNsPredicateString("value BEGINSWITH[a] 'A message'")).getText();
        System.out.println(text);

        driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm'")).click();




    }
}
