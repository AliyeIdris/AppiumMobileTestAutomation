package seleniummaster;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
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
        options.setChromedriverExecutable("/Users/user/MyApplications/chromedriver");
        //options.setApp("/Users/user/IdeaProjects/SamsungA51Application/src/test/java/seleniummaster/resources/ApiDemos-debug.apk");
        options.setApp("/Users/user/IdeaProjects/SamsungA51Application/src/test/java/seleniummaster/resources/General-Store.apk");
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

    //when where to scroll is known prior:
    public void scrollToElement(String elementText){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"));"));
    }
    //when No prior idea
    public  void scrollByCoordinates(){
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("mobile: scrollGesture", ImmutableMap.of("left", 200, "top", 200,
                            "width", 400, "height", 400, "direction", "down", "percent", 3.0));
        }while (canScrollMore);
    }
    public void swipeAction(WebElement element,String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }
    public void dragDropAction(WebElement element,int endX, int endY){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY
        ));
    }
    public Double getFormattedAmount(String amount){
        return Double.parseDouble(amount.substring(1));

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
