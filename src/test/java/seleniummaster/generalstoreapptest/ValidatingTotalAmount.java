package seleniummaster.generalstoreapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniummaster.BaseTest;

import java.time.Duration;
import java.util.List;

/**
 * @author : user
 * @created : 8.12.2023,12:08
 * @Email :aliyeidiris@gmail.com
 **/
public class ValidatingTotalAmount extends BaseTest {
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
    }
}
