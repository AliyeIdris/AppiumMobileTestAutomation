package seleniummaster.androidappautomation.generalstoreapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author : user
 * @created : 23.12.2023,14:59
 * @Email :aliyeidiris@gmail.com
 **/
public class MobileBrowserTest extends BrowserBaseTest{
    @Test
    public void browserTest(){
//        driver.get("http://www.google.com");
//        System.out.println(driver.getTitle());
//        driver.findElement(By.name("q")).sendKeys("Samsung Mobile");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        driver.findElement(By.cssSelector("a[routerlink='/products']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)","");
        String text=driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
        Assert.assertEquals(text,"Devops");
    }
}
