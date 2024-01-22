package seleniummaster.pageobjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import seleniummaster.utils.IOSActions;

/**
 * @author : user
 * @created : 22.01.2024,16:43
 * @Email :aliyeidiris@gmail.com
 **/
public class AlertViewsPage extends IOSActions {
    IOSDriver driver;

    public AlertViewsPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Text Entry'`]")
    WebElement textEntryMenu;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField")
    WebElement textEntryField;
    @iOSXCUITFindBy(accessibility = "OK")
    WebElement okButton;
    @iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
    WebElement confirmMenu;
    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH[a] 'A message'")
    WebElement message;
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Confirm'")
    WebElement confirmButton;

    public void enterText(String text){
        textEntryMenu.click();
        textEntryField.sendKeys(text);
        okButton.click();
    }
    public String getConfirmMessage(){
        confirmMenu.click();
        String a=message.getText();
        confirmButton.click();
        return a;
    }
}
