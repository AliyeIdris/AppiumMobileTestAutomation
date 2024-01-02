package seleniummaster.androidappautomation.generalstoreapptest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniummaster.androidappautomation.BaseTest;
import seleniummaster.pageobjects.android.CartPage;
import seleniummaster.pageobjects.android.FormPage;
import seleniummaster.pageobjects.android.ProductCatalogPage;

/**
 * @author : user
 * @created : 2.01.2024,10:27
 * @Email :aliyeidiris@gmail.com
 **/
public class RunTest extends BaseTest {
    FormPage formPage;
    ProductCatalogPage catalogPage;
    CartPage cartPage;
    @BeforeMethod
    public void fillForm(){
        formPage=new FormPage(driver);
        formPage.setNameField("Aliye Idris");
        formPage.setGender("Female");
        formPage.setSelectCountry("Argentina");
        catalogPage=formPage.submitForm();
    }
    @Test
    public void addSingleItemToCart(){
        catalogPage.addItemToCart("Jordan 6 Rings");
        cartPage=catalogPage.navigateToCartPage();
        cartPage.verifyCartPage();
    }
    @Test
    public void PurchaseMultipleItemTest(){
        catalogPage.addItemToCartByIndex(0);
        catalogPage.addItemToCartByIndex(0);
        cartPage=catalogPage.navigateToCartPage();
        cartPage.verifyCartPage();
        Assert.assertTrue(cartPage.verifyTotalAmount());
        cartPage.submitPurchase();
    }
    @AfterMethod
    public void goBack(){
        driver.navigate().back();
    }
}
