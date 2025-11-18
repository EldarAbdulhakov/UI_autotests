package page;

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

    public BankingCustomerPage selectName(String firstAndLastNames) {
        Select selectName = new Select(getWait5().until(ExpectedConditions.visibilityOf(name)));
        selectName.selectByVisibleText(firstAndLastNames);

        return this;
    }

    public BankingAccountPage clickLoginButton() {
        getWait2().until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        return new BankingAccountPage(getDriver());
    }
}
