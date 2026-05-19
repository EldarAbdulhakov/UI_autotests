package page;

import io.qameta.allure.Step;
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

    @Step("Is user name field displayed")
    public Boolean isUsernameFieldDisplayed() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(usernameField)).isDisplayed();
    }

    @Step("Get user name value attribute")
    public String getUsernameValueAttribute() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(usernameField)).getAttribute("value");
    }

    @Step("Get password value attribute")
    public String getPasswordValueAttribute() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(passwordField)).getAttribute("value");
    }

    @Step("Is password field displayed")
    public Boolean isPasswordFieldDisplayed() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(passwordField)).isDisplayed();
    }

    @Step("Is 'Login' button enabled")
    public Boolean isLoginButtonEnabled() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(loginButton)).isEnabled();
    }

    @Step("Click 'Login' button")
    public RegistrationLoginPage clickLoginButton() {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(loginButton)).click();

        return this;
    }

    @Step("Is user name description displayed")
    public Boolean isUsernameDescriptionDisplayed() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(usernameDescription)).isDisplayed();
    }

    @Step("Enter user name")
    public RegistrationLoginPage enterUserName(String username) {
        waiter.getWait5().until(ExpectedConditions.visibilityOf(usernameField)).clear();
        waiter.getWait2().until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);

        return this;
    }

    @Step("Enter password")
    public RegistrationLoginPage enterPassword(String password) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(passwordField)).clear();
        waiter.getWait2().until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);

        return this;
    }

    @Step("Enter user name description")
    public RegistrationLoginPage enterUserNameDescription(String description) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(usernameDescription)).clear();
        waiter.getWait2().until(ExpectedConditions.visibilityOf(usernameDescription)).sendKeys(description);

        return this;
    }

    @Step("Get 'You're logged in!!' message")
    public String getSuccessAuthMessage() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(successAuthMessage)).getText();
    }

    @Step("Get 'Username or password is incorrect' message")
    public String getInvalidAuthMessage() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(invalidAuthMessage)).getText();
    }

    @Step("Click 'Logout' button")
    public RegistrationLoginPage clickLogoutButton() {
        waiter.getWait5().until(ExpectedConditions.elementToBeClickable(logoutButton)).click();

        return this;
    }

    @Step("Get any authorisation message")
    public String getAnyAuthMessage() {
        return waiter.getWait5().until(driver -> {
            try {
                if (successAuthMessage.isDisplayed()) {
                    return successAuthMessage.getText();
                }
            } catch (Exception ignored) {}

            try {
                if (invalidAuthMessage.isDisplayed()) {
                    return invalidAuthMessage.getText();
                }
            } catch (Exception ignored) {}

            return null;
        });
    }
}
