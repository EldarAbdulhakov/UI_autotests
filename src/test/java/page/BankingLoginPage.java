package page;

import io.qameta.allure.Step;
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

    @Step("Click 'Sample Form' button")
    public SampleFormPage clickSampleFormButton() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(sampleFormButton)).click();

        return new SampleFormPage(getDriver());
    }

    @Step("Click 'Bank Manager Login' button")
    public BankingManagerPage clickBankManagerLoginButton() {
        waiter.getWait5().until(ExpectedConditions.elementToBeClickable(bankManagerLoginButton)).click();

        return new BankingManagerPage(getDriver());
    }

    @Step("Click 'Customer Login' button")
    public BankingCustomerPage clickCustomerLoginButton() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(customerLoginButton)).click();

        return new BankingCustomerPage(getDriver());
    }
}
