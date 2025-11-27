package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage extends BasePage {

    @FindBy(id = "form-field-name")
    private WebElement nameField;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        getDriver().get("https://www.way2automation.com/contact-us/");
    }

    public ContactUsPage clickNameField() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(nameField)).click();

        return this;
    }

    public ContactUsPage removeFocusFromNameField() {
        js.removeFocusJS(nameField);

        return this;
    }

    public Boolean isNameFieldFocus() {
        return nameField.equals(getDriver().switchTo().activeElement());
    }

    public Boolean isPageScroll() {
        return js.isVerticalScrollJS() || js.isHorizontalScrollJS();
    }
}
