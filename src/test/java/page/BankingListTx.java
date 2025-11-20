package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BankingListTx extends BasePage {

    @FindBy(xpath = "//tbody/tr[last()]/td[position() > last()-2]")
    private List<WebElement> lastTransaction;

    @FindBy(xpath = "//a[contains(text(), 'Date-Time')]")
    private WebElement dateTime;

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> allTransactions;

    @FindBy(xpath = "//button[text()='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//button[text()='Back']")
    private WebElement backButton;

    public BankingListTx(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getLastTransaction() {
        return waiter.getWait5().until(ExpectedConditions.visibilityOfAllElements(lastTransaction));
    }

    public List<WebElement> getAllTransactions() {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(dateTime));

        return allTransactions;
    }

    public String calculateBalanceFromTransactions() {
        List<WebElement> allTransactions = getAllTransactions();

        int balance = 0;

        for (WebElement transaction : allTransactions) {
            String amountText = transaction.findElement(By.xpath("./td[2]")).getText().trim();
            String typeText = transaction.findElement(By.xpath("./td[3]")).getText().trim();

            int amount = Integer.parseInt(amountText);

            if (typeText.equals("Credit")) {
                balance += amount;
            } else if (typeText.equals("Debit")) {
                balance -= amount;
            }
        }

        return String.valueOf(balance);
    }

    public BankingListTx clickResetButton() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(resetButton)).click();

        return this;
    }

    public BankingAccountPage clickBackButton() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(backButton)).click();

        return new BankingAccountPage(getDriver());
    }
}
