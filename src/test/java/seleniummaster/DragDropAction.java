package seleniummaster;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author : user
 * @created : 6.12.2023,16:54
 * @Email :aliyeidiris@gmail.com
 **/
public class DragDropAction extends BaseTest{
    @Test
    public void DragDropTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
       WebElement source= driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
       dragDropAction(source,621,555);
        String result=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result,"Dropped!");
    }
}
