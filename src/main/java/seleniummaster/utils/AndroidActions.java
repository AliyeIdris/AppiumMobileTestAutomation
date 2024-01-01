package seleniummaster.utils;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

/**
 * @author : user
 * @created : 2.01.2024,00:38
 * @Email :aliyeidiris@gmail.com
 **/
public class AndroidActions {
    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;
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
}
