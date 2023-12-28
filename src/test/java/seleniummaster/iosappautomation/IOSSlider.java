package seleniummaster.iosappautomation;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author : user
 * @created : 27.12.2023,11:17
 * @Email :aliyeidiris@gmail.com
 **/
public class IOSSlider extends IOSBaseTest{
    @Test
    public void IOSSliderTest(){
        WebElement slider=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == 'AppElem'`]"));
        slider.sendKeys("0%");
        System.out.println(slider.getAttribute("value"));
        Assert.assertEquals(slider.getAttribute("value"),"%0");

        slider.sendKeys("1%");
        System.out.println(slider.getAttribute("value"));
        Assert.assertEquals(slider.getAttribute("value"),"%100");

    }
}
