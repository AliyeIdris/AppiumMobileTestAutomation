package seleniummaster.iosappautomation;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : user
 * @created : 27.12.2023,23:46
 * @Email :aliyeidiris@gmail.com
 **/
public class IOSScroll extends IOSBaseTest{
    @Test
    public void scrollTest(){
        WebElement element=driver.findElement(AppiumBy.iOSNsPredicateString("label=='Web View'"));
        Map<String,Object> params=new HashMap<>();
        params.put("element",((RemoteWebElement)element).getId());
        params.put("direction","down");
        driver.executeScript("mobile:scroll",params);
        element.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String text=driver.findElement(AppiumBy.iOSNsPredicateString("value BEGINSWITH 'This is HTML content inside a '")).getText();
        System.out.println(text);

        //go back to home screen
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'UIKitCatalog'`]")).click();
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();

        WebElement redColorField=driver.findElement(AppiumBy.accessibilityId("Red color component value"));
        redColorField.sendKeys("80");
        WebElement greenColorField=driver.findElement(AppiumBy.iOSNsPredicateString("label=='Green color component value'"));
        greenColorField.sendKeys("220");
        WebElement blueColorField=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`name=='Blue color component value'`]"));
        blueColorField.sendKeys("105");
        String blueColorFieldText=blueColorField.getText();
        Assert.assertEquals(blueColorFieldText,"105");


    }
}
