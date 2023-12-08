package seleniummaster.ecommerceproject1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import seleniummaster.BaseTest;

/**
 * @author : user
 * @created : 8.12.2023,12:08
 * @Email :aliyeidiris@gmail.com
 **/
public class GeneralStoreAppTest extends BaseTest {
    @Test
    public void fillForm(){
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Aliye Idris");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        scrollToElement("Argentina");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
