package seleniummaster.pageobjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import seleniummaster.utils.AndroidActions;

/**
 * @author : user
 * @created : 2.01.2024,00:17
 * @Email :aliyeidiris@gmail.com
 **/
public class FormPage extends AndroidActions {
    AndroidDriver driver;
    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    private WebElement femaleCheckbox;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
    private WebElement maleCheckbox;
    @AndroidFindBy(id = "android:id/text1")
    private WebElement countryDropDown;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;
    public void setNameField(String name){
        nameField.sendKeys();
        driver.hideKeyboard();
    }
    public void setGender(String gender){
        if (gender.contains("female"))
            femaleCheckbox.click();
        else
            maleCheckbox.click();
    }
    public void setSelectCountry(String countryName){
        countryDropDown.click();
        scrollToElement(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
    }
    public void submitForm(){
        shopButton.click();
    }
}
