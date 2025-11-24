package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SqlExPage extends BasePage {

    @FindBy(xpath = "//input[@name='login' and @type='text']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='psw' and @type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//a[@class='none' and @href='/personal.php']")
    private WebElement userName;

    @FindBy(xpath = "//input[@type='submit' and @name='subm1']")
    private WebElement enterButton;

    public SqlExPage(WebDriver driver) {
        super(driver);
        getDriver().get("https://www.sql-ex.ru");
    }

    public SqlExPage enterLogin(String login) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(loginField)).sendKeys(login);

        return this;
    }

    public SqlExPage enterPassword(String password) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);

        return this;
    }

    public SqlExPage clickEnter() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(enterButton)).click();

        return this;
    }

    public String getUserName() {
        try {
            WebElement el = waiter.getWait5().until(ExpectedConditions.visibilityOf(userName));
            return el.getText();
        } catch (Exception e) {
            return null;
        }
    }
}
