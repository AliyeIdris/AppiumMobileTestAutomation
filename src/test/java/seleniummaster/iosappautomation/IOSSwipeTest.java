package seleniummaster.iosappautomation;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : user
 * @created : 27.12.2023,11:17
 * @Email :aliyeidiris@gmail.com
 **/
public class IOSSwipeTest extends IOSBaseTest{
    @Test
    public void swipeTest(){
        //to uniquely identify any app, we use Bundle Id
        Map<String,String> params=new HashMap<>();
        params.put("bundleId","com.apple.mobileslideshow");
        driver.executeScript("mobile:launchApp",params);
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'All Photos'`]")).click();
        List<WebElement> allPhotos=driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        System.out.println(allPhotos.size());
        allPhotos.get(1).click();
        for(int i=0; i<allPhotos.size();i++) {
            System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
            Map<String, Object> params1 = new HashMap<>();
            params1.put("direction", "left");
            //here just swipe the center of the screen is enough, so we don't need to give which element to swipe as below
            //params1.put("element",((RemoteWebElement)element).getId());
            driver.executeScript("mobile:swipe", params1);
        }
        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Albums")).click();//cleanup
    }
}
