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

    @FindBy(xpath = "//p[text()=\"You're logged in!!\"]")
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
        return getWait2().until(ExpectedConditions.visibilityOf(usernameField)).isDisplayed();
    }

    public String getUsernameValueAttribute() {
        return getWait2().until(ExpectedConditions.visibilityOf(usernameField)).getAttribute("value");
    }

    public String getPasswordValueAttribute() {
        return getWait2().until(ExpectedConditions.visibilityOf(passwordField)).getAttribute("value");
    }

    public Boolean isPasswordFieldDisplayed() {
        return getWait2().until(ExpectedConditions.visibilityOf(passwordField)).isDisplayed();
    }

    public Boolean isLoginButtonEnabled() {
        return getWait2().until(ExpectedConditions.visibilityOf(loginButton)).isEnabled();
    }

    public RegistrationLoginPage clickLoginButton() {
        getWait2().until(ExpectedConditions.visibilityOf(loginButton)).click();

        return this;
    }

    public Boolean isUsernameDescriptionDisplayed() {
        return getWait2().until(ExpectedConditions.visibilityOf(usernameDescription)).isDisplayed();
    }

    public RegistrationLoginPage enterUserName(String username) {
        getWait2().until(ExpectedConditions.visibilityOf(usernameField)).clear();
        getWait2().until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);

        return this;
    }

    public RegistrationLoginPage enterPassword(String password) {
        getWait2().until(ExpectedConditions.visibilityOf(passwordField)).clear();
        getWait2().until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);

        return this;
    }

    public RegistrationLoginPage enterUserNameDescription(String description) {
        getWait2().until(ExpectedConditions.visibilityOf(usernameDescription)).clear();
        getWait2().until(ExpectedConditions.visibilityOf(usernameDescription)).sendKeys(description);

        return this;
    }

    public Boolean isSuccessAuthMessageDisplayed() {
        return getWait2().until(ExpectedConditions.visibilityOf(successAuthMessage)).isDisplayed();
    }

    public String getInvalidAuthMessage() {
        return getWait2().until(ExpectedConditions.visibilityOf(invalidAuthMessage)).getText();
    }

    public RegistrationLoginPage clickLogoutButton() {
        getWait5().until(ExpectedConditions.elementToBeClickable(logoutButton)).click();

        return this;
    }
}
