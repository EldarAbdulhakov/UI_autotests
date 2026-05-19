package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BankingCustomerPage extends BasePage {

    @FindBy(id = "userSelect")
    private WebElement name;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public BankingCustomerPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select name")
    public BankingCustomerPage selectName(String firstAndLastNames) {
        Select selectName = new Select(waiter.getWait5().until(ExpectedConditions.visibilityOf(name)));
        selectName.selectByVisibleText(firstAndLastNames);

        return this;
    }

    @Step("Click 'Login' button")
    public BankingAccountPage clickLoginButton() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        return new BankingAccountPage(getDriver());
    }
}
