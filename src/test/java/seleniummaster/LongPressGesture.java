package seleniummaster;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author : user
 * @created : 27.11.2023,13:24
 * @Email :aliyeidiris@gmail.com
 **/
public class LongPressGesture extends BaseTest{
    @Test
    public void longPressGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement targetItem=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        longPressAction(targetItem);
        String menuText=driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(menuText,"Sample menu");
       Assert.assertTrue( driver.findElement(By.id("android:id/title")).isDisplayed());
    }
}
