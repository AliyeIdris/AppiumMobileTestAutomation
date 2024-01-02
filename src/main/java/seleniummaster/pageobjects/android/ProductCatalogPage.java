package seleniummaster.pageobjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import seleniummaster.utils.AndroidActions;

import java.util.List;

/**
 * @author : user
 * @created : 2.01.2024,10:41
 * @Email :aliyeidiris@gmail.com
 **/
public class ProductCatalogPage extends AndroidActions {
    AndroidDriver driver;
    public ProductCatalogPage(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id ="com.androidsample.generalstore:id/productName" )
    private List<WebElement> productsNames;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private List<WebElement> addToCartButtons;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartIcon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCartLinks;
    public void addItemToCart(String productName){
        scrollToElement(productName);
        int productCount= productsNames.size();
        for(int i=0; i<productCount;i++){
            String name=productsNames.get(i).getText();
            if(name.equalsIgnoreCase(productName)){
                addToCartButtons.get(i).click();
                break;
            }
        }
    }
    public void addItemToCartByIndex(int index){
        addToCartLinks.get(index).click();
    }
    public CartPage navigateToCartPage(){
        cartIcon.click();
        return new CartPage(driver);
    }
}

