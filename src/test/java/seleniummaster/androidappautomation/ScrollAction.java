package seleniummaster.androidappautomation;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author : user
 * @created : 28.11.2023,09:51
 * @Email :aliyeidiris@gmail.com
 **/
public class ScrollAction extends BaseTest{
    @Test
    public void ScrollToElement(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        String elementText="WebView";
        scrollToElement(elementText);
        WebElement webView=driver.findElement(AppiumBy.accessibilityId("WebView"));
        Assert.assertTrue(webView.isDisplayed());
    }
    @Test
    public void scrollByCoordinate(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        scrollByCoordinates();
        try {
            WebElement webView = driver.findElement(AppiumBy.accessibilityId("WebView"));
            Assert.assertEquals(webView.getText(),"WebView");
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }

    }
}
