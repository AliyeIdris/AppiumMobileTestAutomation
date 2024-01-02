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
 * @created : 2.01.2024,11:12
 * @Email :aliyeidiris@gmail.com
 **/
public class CartPage extends AndroidActions {
    AndroidDriver driver;
    public CartPage(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement cartTitleField;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    WebElement productNameField;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productPrices;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement displaySumField;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement termsButton;
    @AndroidFindBy(id = "android:id/button1")
    private WebElement button;
    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement checkBox;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement proceedButton;
    public boolean verifyCartPage(){
        waitForAttribute(cartTitleField,"text","Cart");
        return cartTitleField.isDisplayed();
    }
    public boolean verifyTotalAmount(){
        int priceCount=productPrices.size();
        double totalPrices=0;
        for(int i=0; i<priceCount;i++){
            String amountString=productPrices.get(i).getText();
            //$160.07 + $120.00
            totalPrices +=getFormattedAmount(amountString);
        }
        String displaySum=displaySumField.getText();
        Double displayFormattedSum=getFormattedAmount(displaySum);
        return  (totalPrices==displayFormattedSum);
    }
    public void submitPurchase(){
        longPressAction(termsButton);
        button.click();
        checkBox.click();
        proceedButton.click();
    }
}
