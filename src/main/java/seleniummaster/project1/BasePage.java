package seleniummaster.project1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * @author : user
 * @created : 6.12.2023,17:18
 * @Email :aliyeidiris@gmail.com
 **/
public class BasePage {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppium(){
        service=new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("Aliyeemulator");
        options.setApp("/Users/user/IdeaProjects/SamsungA51Application/src/test/java/seleniummaster/resources/ApiDemos-debug.apk");
        try {
            driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
