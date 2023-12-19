package seleniummaster.generalstoreapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniummaster.BaseTest;

import java.time.Duration;

/**
 * @author : user
 * @created : 8.12.2023,12:08
 * @Email :aliyeidiris@gmail.com
 **/
public class AddProductToCart extends BaseTest {
    @Test
    public void addToCart(){
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Aliye Idris");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        scrollToElement("Argentina");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        scrollToElement("Jordan 6 Rings");
       // driver.findElement(By.xpath("//android.widget.TextView[@text='Jordan 6 Rings']")).click();
        int productCount=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0; i<productCount;i++){
            String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName"))
                    .get(i).getText();
            if(productName.equalsIgnoreCase("Jordan 6 Rings")){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        WebElement cartTitle=driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(cartTitle,"text","Cart"));
        String addedProduct=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(addedProduct,"Jordan 6 Rings");
    }
}
