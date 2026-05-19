package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertPage extends BasePage {

    private Alert alert;

    @FindBy(xpath = "//a[text()='Input Alert']")
    private WebElement inputAlertMenu;

    @FindBy(xpath = "//button[text()='Click the button to demonstrate the Input box.']")
    private WebElement demonstrateInputBoxButton;

    @FindBy(xpath = "//iframe[@src='alert/input-alert.html']")
    private WebElement inputBoxFrame;

    @FindBy(id = "demo")
    private WebElement inputBoxField;

    public AlertPage(WebDriver driver) {
        super(driver);
        getDriver().get("http://way2automation.com/way2auto_jquery/alert.php#load_box");
    }

    public AlertPage clickInputAlert() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(inputAlertMenu)).click();

        return this;
    }

    public AlertPage clickInputBoxButton() {
        demonstrateInputBoxButton.click();

        return this;
    }

    public AlertPage switchToInputBoxFrame() {
        getDriver().switchTo().frame(inputBoxFrame);

        return this;
    }

    public AlertPage switchToAlert() {
        alert = waiter.getWait2().until(ExpectedConditions.alertIsPresent());

        return this;
    }

    public AlertPage enterTextToAlertAndAccept(String text) {
        alert.sendKeys(text);
        alert.accept();

        return this;
    }

    public String getInputBox() {
        return inputBoxField.getText();
    }
}
