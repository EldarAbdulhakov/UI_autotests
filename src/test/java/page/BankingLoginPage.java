package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BankingLoginPage extends BasePage {

    @FindBy(xpath = "//a[text()='Sample Form']")
    private WebElement sampleFormButton;

    @FindBy(xpath = "//button[text()='Bank Manager Login']")
    private WebElement bankManagerLoginButton;

    @FindBy(xpath = "//button[text()='Customer Login']")
    private WebElement customerLoginButton;

    public BankingLoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
    }

    public SampleFormPage clickSampleFormButton() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(sampleFormButton)).click();

        return new SampleFormPage(getDriver());
    }

    public BankingManagerPage clickBankManagerLoginButton() {
        waiter.getWait5().until(ExpectedConditions.elementToBeClickable(bankManagerLoginButton)).click();

        return new BankingManagerPage(getDriver());
    }

    public BankingCustomerPage clickCustomerLoginButton() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(customerLoginButton)).click();

        return new BankingCustomerPage(getDriver());
    }
}
