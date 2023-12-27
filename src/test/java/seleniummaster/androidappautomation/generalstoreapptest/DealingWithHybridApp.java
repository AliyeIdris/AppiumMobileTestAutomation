package seleniummaster.androidappautomation.generalstoreapptest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniummaster.androidappautomation.BaseTest;

import java.time.Duration;
import java.util.List;
import java.util.Set;

/**
 * @author : user
 * @created : 8.12.2023,12:08
 * @Email :aliyeidiris@gmail.com
 **/
public class DealingWithHybridApp extends BaseTest {
    @Test
    public void completePurchase(){
        //fill the form
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Aliye Idris");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        scrollToElement("Argentina");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        //add 2 products into the cart
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();//first add to cart link
        //because the first add to cart link is changed as "added to cart" there for only one link left on the page, so we use same index below
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();//second add to cart link,
        //driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click(); //another way to add to cart
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebElement cartTitle=driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(cartTitle,"text","Cart"));

        //validate total amount
        List<WebElement> productPrices =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int priceCount=productPrices.size();
        double totalPrices=0;
        for(int i=0; i<priceCount;i++){
            String amountString=productPrices.get(i).getText();
            //$160.07 + $120.00
            totalPrices +=getFormattedAmount(amountString);
        }
        String displaySum=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedSum=getFormattedAmount(displaySum);
        Assert.assertEquals(totalPrices,displayFormattedSum);

        WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(ele);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Hybrid app--Google page
        Set<String> contexts=driver.getContextHandles();
        for(String contextName: contexts){
            System.out.println(contextName);//to get the web view name
        }
        //switch to browser driver
        driver.context("WEBVIEW_com.androidsample.generalstore"); //chrome driver
        driver.findElement(By.name("q")).sendKeys("Iphone 13 Pro");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //switch to app driver again
        driver.context("NATIVE_APP");

    }
}
