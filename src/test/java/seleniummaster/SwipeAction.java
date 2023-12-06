package seleniummaster;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author : user
 * @created : 28.11.2023,10:53
 * @Email :aliyeidiris@gmail.com
 **/
public class SwipeAction extends BaseTest{
    @Test
            public void swipeActionTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
        //verify the first image is focused
        WebElement firstImage=driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
       Assert.assertEquals(firstImage.getAttribute("focusable") ,"true");
       //swipe
        swipeAction(firstImage,"left");
        //verify swipe successful
        Assert.assertEquals(firstImage.getAttribute("focusable") ,"false");
    }
}
