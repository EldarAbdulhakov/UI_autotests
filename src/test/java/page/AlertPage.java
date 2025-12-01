package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    @FindBy(xpath = "//a[text()='Input Alert']")
    private WebElement inputAlert;

    @FindBy(xpath = "//button[text()='Click the button to demonstrate the Input box.']")
    private WebElement demonstrateInputBoxButton;

//    @FindBy(xpath = "")
//    private WebElement ;
//
//    @FindBy(xpath = "")
//    private WebElement ;

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public AlertPage clickInputAlert() {
        inputAlert.click();

        return this;
    }

    public AlertPage clickDemonstrateInputBoxButton() {
        demonstrateInputBoxButton.click();

        return this;
    }

}
