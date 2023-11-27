package seleniummaster;

import com.google.common.collect.ImmutableBiMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * @author : user
 * @created : 25.11.2023,18:31
 * @Email :aliyeidiris@gmail.com
 **/
public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
    public void configureAppium() {
        service=new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("Aliyeemulator");
        options.setApp("/Users/user/IdeaProjects/SamsungA51Application/src/test/java/seleniummaster/resources/ApiDemos-debug.apk");
        try {
            driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void longPressAction(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableBiMap.of("elementId", ((RemoteWebElement)element).getId(),//RemoteWebElement casting recognize both webElement and mobile element
                        "duration",2000));
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
