package seleniummaster.utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : user
 * @created : 22.01.2024,16:15
 * @Email :aliyeidiris@gmail.com
 **/
public class IOSActions {
    IOSDriver driver;

    public IOSActions(IOSDriver driver) {
        this.driver = driver;
    }
    public void longPress(WebElement element){
        Map<String,Object> params=new HashMap<>();
        params.put("element", ((RemoteWebElement)element).getId());
        params.put("duration",5);
        driver.executeScript("mobile:touchAndHold",params);
    }
    public void scroll(WebElement element){
        Map<String,Object> params=new HashMap<>();
        params.put("element",((RemoteWebElement)element).getId());
        params.put("direction","down");
        driver.executeScript("mobile:scroll",params);
    }
    public void swipe(WebElement element){
        Map<String,String> params=new HashMap<>();
        params.put("bundleId","com.apple.mobileslideshow");
        driver.executeScript("mobile:launchApp",params);

        Map<String, Object> params1 = new HashMap<>();
        params1.put("direction", "left");
        params1.put("element",((RemoteWebElement)element).getId());
        driver.executeScript("mobile:swipe", params1);
    }
}
