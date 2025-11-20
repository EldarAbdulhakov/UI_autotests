package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationLoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//input[contains(@id, '_input_username_0')]")
    private WebElement usernameDescription;

    @FindBy(xpath = "//div[@ng-view]/p[1]")
    private WebElement successAuthMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger ng-binding ng-scope']")
    private WebElement invalidAuthMessage;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutButton;

    public RegistrationLoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.way2automation.com/angularjs-protractor/registeration/#/login");
    }

    public Boolean isUsernameFieldDisplayed() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(usernameField)).isDisplayed();
    }

    public String getUsernameValueAttribute() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(usernameField)).getAttribute("value");
    }

    public String getPasswordValueAttribute() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(passwordField)).getAttribute("value");
    }

    public Boolean isPasswordFieldDisplayed() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(passwordField)).isDisplayed();
    }

    public Boolean isLoginButtonEnabled() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(loginButton)).isEnabled();
    }

    public RegistrationLoginPage clickLoginButton() {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(loginButton)).click();

        return this;
    }

    public Boolean isUsernameDescriptionDisplayed() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(usernameDescription)).isDisplayed();
    }

    public RegistrationLoginPage enterUserName(String username) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(usernameField)).clear();
        waiter.getWait2().until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);

        return this;
    }

    public RegistrationLoginPage enterPassword(String password) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(passwordField)).clear();
        waiter.getWait2().until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);

        return this;
    }

    public RegistrationLoginPage enterUserNameDescription(String description) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(usernameDescription)).clear();
        waiter.getWait2().until(ExpectedConditions.visibilityOf(usernameDescription)).sendKeys(description);

        return this;
    }

    public String getSuccessAuthMessage() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(successAuthMessage)).getText();
    }

    public String getInvalidAuthMessage() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(invalidAuthMessage)).getText();
    }

    public RegistrationLoginPage clickLogoutButton() {
        waiter.getWait5().until(ExpectedConditions.elementToBeClickable(logoutButton)).click();

        return this;
    }
}
