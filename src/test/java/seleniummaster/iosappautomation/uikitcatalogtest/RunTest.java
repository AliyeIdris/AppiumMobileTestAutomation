package seleniummaster.iosappautomation.uikitcatalogtest;

import org.testng.Assert;
import org.testng.annotations.Test;
import seleniummaster.pageobjects.ios.AlertViewsPage;
import seleniummaster.utils.IOSBaseTest;

/**
 * @author : user
 * @created : 22.01.2024,16:36
 * @Email :aliyeidiris@gmail.com
 **/
public class RunTest extends IOSBaseTest {
    @Test
    public void basicTest(){
        AlertViewsPage alertViewsPage=homePage.selectAlertViews();
        alertViewsPage.enterText("Hello World");
        String actualMessage=alertViewsPage.getConfirmMessage();
        Assert.assertEquals(actualMessage,"A message should be a short, complete sentence.");
    }
}
