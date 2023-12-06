package seleniummaster.project1;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author : user
 * @created : 6.12.2023,17:47
 * @Email :aliyeidiris@gmail.com
 **/
public class TestRunner extends BasePage{
    @Test
    public void goToMainPage(){
            driver.findElement(AppiumBy.accessibilityId("App")).click();
            driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
    }
    @Test(dependsOnMethods = "goToMainPage")
    public void listDialogTest(){
        driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Command two']")).click();
        String resultMessage=driver.findElement(By.id("android:id/message")).getText();
        Assert.assertEquals(resultMessage,"You selected: 1 , Command two");
    }
    @Test(dependsOnMethods = "goToMainPage")
    public void singleChoiceTest(){
        WebElement singleChoiceList=driver.findElement(AppiumBy.accessibilityId("Single choice list"));
        singleChoiceList.click();
        WebElement trafficButton=driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Traffic']"));
        Assert.assertEquals(trafficButton.getAttribute("checked"),"false");
        trafficButton.click();
        driver.findElement(By.id("android:id/button1")).click();
        //singleChoiceList.click();
        //Assert.assertEquals(trafficButton.getAttribute("checked"),"true");
    }
    @Test(dependsOnMethods = "goToMainPage")
    public void textEntryTest(){
        driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
        driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Aliye");
        driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("123456");
        driver.findElement(By.id("android:id/button1")).click();
    }
}
