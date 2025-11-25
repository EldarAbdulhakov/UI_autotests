package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class BankingAccountPage extends BasePage {

    @FindBy(xpath = "//strong[contains(text(), 'Welcome')]")
    private WebElement welcome;

    @FindBy(xpath = "//div[contains(text(), 'Account Number : ')]//strong[1]")
    private WebElement accountNumber;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    private WebElement depositMenu;

    @FindBy(xpath = "//input[@placeholder='amount']")
    private WebElement amountField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement depositButton;

    @FindBy(xpath = "//span[text()='Deposit Successful']")
    private WebElement depositSuccessfulMessage;

    @FindBy(xpath = "//button[contains(text(), 'Transactions')]")
    private WebElement transactions;

    @FindBy(xpath = "//div[contains(., 'Balance :')]/strong[2]")
    private WebElement balance;

    @FindBy(xpath = "//button[contains(text(), 'Withdrawl')]")
    private WebElement withdrawlMenu;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement withdrawlButton;

    @FindBy(xpath = "//span[normalize-space()='Transaction successful']")
    private WebElement transactionSuccessfulMessage;

    @FindBy(xpath = "//span[text()='Transaction Failed. You can not withdraw amount more than the balance.']")
    private WebElement transactionFailedMessage;

    public BankingAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get 'Welcome'")
    public String getWelcome() {
        return waiter.getWait5().until(ExpectedConditions.visibilityOf(welcome)).getText();

    }

    @Step("Get account number")
    public String getAccountNumber() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(accountNumber)).getText().trim();
    }

    @Step("Click 'Deposit' menu")
    public BankingAccountPage clickDepositMenu() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(depositMenu)).click();

        return this;
    }

    @Step("pause")
    public void pause(long time) {
        Actions actions = new Actions(getDriver());
        actions.pause(time).perform();
    }

    @Step("Wait 'Deposit Successful' message is not displayed")
    public BankingAccountPage waitDepositSuccessfulMessageIsNotDisplayed() {
        waiter.getWait5().until(ExpectedConditions.invisibilityOf(depositSuccessfulMessage));

        return this;
    }

    @Step("Enter amount")
    public BankingAccountPage enterAmount(String amount) {
        waiter.getWait5().until(ExpectedConditions.visibilityOf(amountField)).sendKeys(amount);

        return this;
    }

    @Step("Click 'Deposit' button")
    public BankingAccountPage clickDepositButton() {
        depositButton.click();

        return this;
    }

    @Step("Verify 'Deposit Successful' message is display")
    public BankingAccountPage verifyDepositSuccessfulMessageIsDisplay() {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(depositSuccessfulMessage)).isDisplayed();

        return this;
    }

    @Step("Verify 'Deposit Success' message not display")
    public BankingAccountPage verifyDepositSuccessMessageNotDisplay() {
        waiter.getWait2().until(ExpectedConditions.not(ExpectedConditions.visibilityOf(depositSuccessfulMessage)));

        return this;
    }

    @Step("Click 'Transactions'")
    public BankingListTx clickTransactions() {
        pause(1500);

        waiter.getWait2().until(ExpectedConditions.elementToBeClickable((transactions))).click();

        return new BankingListTx(getDriver());
    }

    @Step("Get balance")
    public String getBalance() {
        return
                waiter.getWait5().until(ExpectedConditions.visibilityOf(balance)).getText();
    }

    @Step("Click 'Withdrawl' menu")
    public BankingAccountPage clickWithdrawlMenu() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable((withdrawlMenu))).click();

        return this;
    }

    @Step("Random amount within balance")
    public String randomAmountWithinBalance(String balance) {
        return String.valueOf(new Random().nextInt(Integer.parseInt(balance) + 1));
    }

    @Step("Click 'Withdrawl' button")
    public BankingAccountPage clickWithdrawlButton() {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(withdrawlButton)).click();

        return this;
    }

    @Step("Verify 'Transaction Successful' message is display")
    public BankingAccountPage verifyTransactionSuccessfulMessageIsDisplay() {
        waiter.getWait5().until(ExpectedConditions.visibilityOf(transactionSuccessfulMessage)).isDisplayed();

        return this;
    }

    @Step("Verify transaction failed message is display")
    public BankingAccountPage verifyTransactionFailedMessageIsDisplay() {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(transactionFailedMessage)).isDisplayed();

        return this;
    }
}
