package seleniummaster.iosappautomation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
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
 * @created : 25.11.2023,18:31
 * @Email :aliyeidiris@gmail.com
 **/
public class IOSBaseTest {

    public IOSDriver driver;
    public AppiumDriverLocalService service;
    public XCUITestOptions options;
    @BeforeClass
    public void configureAppium() {
        service=new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        options=new XCUITestOptions();
        options.setDeviceName("iPhone 12 Pro");
        //options.setApp("/Users/user/Desktop/UIKitCatalog.app");
        //options.setApp("/Users/user/IdeaProjects/SamsungA51Application/src/test/resources/TestApp 3.app");
        options.setPlatformVersion("17.2");
        //Appium -Webdriver Agent -> IOS Apps
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));
        try {
            driver=new IOSDriver(new URL("http://127.0.0.1:4723"), options);
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
