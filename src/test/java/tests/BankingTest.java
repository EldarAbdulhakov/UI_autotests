package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BankingAccountPage;
import page.BankingListTx;
import page.BankingLoginPage;
import page.BankingManagerPage;

import java.util.List;

public class BankingTest extends BaseTest {

    final static String FIRST_NAME = "Bob";
    final static String LAST_NAME = "Marley";
    final static String POST_CODE = "5986541";
    final static String AMOUNT = "100321";
    private String expectedAccountNumber;


    @Test
    public void testAddCustomer() {
        Alert customerAddAlert = new BankingLoginPage(getDriver())
                .clickBankManagerLoginButton()
                .clickAddCustomerMenu()
                .enterFirstName(FIRST_NAME)
                .enterLastName(LAST_NAME)
                .enterPostCode(POST_CODE)
                .clickAddCustomerButton()
                .switchAlert();

        Assert.assertTrue(customerAddAlert.getText().contains("Customer added successfully with customer id :"));

        customerAddAlert.accept();
    }

    @Test()
    public void testOpenAccount() {
        testAddCustomer();

        Alert accountCreateAlert = new BankingManagerPage(getDriver())
                .clickOpenAccountMenu()
                .selectCustomer(FIRST_NAME + " " + LAST_NAME)
                .selectDollarCurrency()
                .clickProcessButton()
                .switchAlert();

        expectedAccountNumber = accountCreateAlert.getText().split(":")[1].trim();

        Assert.assertTrue(accountCreateAlert.getText().contains("Account created successfully with account Number :"));

        accountCreateAlert.accept();
    }

    @Test
    public void testCustomerLoginInterface() {
        testOpenAccount();

        String welcome = new BankingLoginPage(getDriver())
                .clickCustomerLoginButton()
                .selectName(FIRST_NAME + " " + LAST_NAME)
                .clickLoginButton()
                .getWelcome();

        String actualAccountNumber = new BankingAccountPage(getDriver())
                .getAccountNumber();

        Assert.assertEquals(actualAccountNumber, expectedAccountNumber);
        Assert.assertEquals(welcome, "Welcome %s %s !!".formatted(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void testSuccessfulDeposit() {
        testCustomerLoginInterface();

        List<WebElement> actualAmount = new BankingAccountPage(getDriver())
                .clickDepositMenu()
                .enterAmount(AMOUNT)
                .clickDepositButton()
                .verifyDepositSuccessfulMessageIsDisplay()
                .clickTransactions()
                .getLastTransaction();

        Assert.assertEquals(actualAmount.get(0).getText(), AMOUNT);
        Assert.assertEquals(actualAmount.get(1).getText().trim(), "Credit");
    }

    @Test
    public void testUnsuccessfulDeposit() {
        final String AMOUNT = "0";

        testCustomerLoginInterface();

        List<WebElement> allAmounts = new BankingAccountPage(getDriver())
                .clickDepositMenu()
                .enterAmount(AMOUNT)
                .clickDepositButton()
                .clickTransactions()
                .getAllTransactions();

        Assert.assertTrue(allAmounts.isEmpty());
    }

    @Test
    public void testSuccessfulWithdrawal() {
        testCustomerLoginInterface();

        BankingAccountPage bankingAccountPage = new BankingAccountPage(getDriver())
                .clickDepositMenu()
                .enterAmount(AMOUNT)
                .clickDepositButton()
                .verifyDepositSuccessfulMessageIsDisplay();

        String balance = bankingAccountPage.getBalance();
        String randomAmount = bankingAccountPage.randomAmountWithinBalance(balance);

        List<WebElement> lastAmount = bankingAccountPage
                .clickWithdrawlMenu()
                .waitDepositSuccessfulMessageIsNotDisplayed()
                .enterAmount(randomAmount)
                .clickWithdrawlButton()
                .verifyTransactionSuccessfulMessageIsDisplay()
                .clickTransactions()
                .getLastTransaction();

        Assert.assertEquals(lastAmount.get(0).getText().trim(), randomAmount);
        Assert.assertEquals(lastAmount.get(1).getText().trim(), "Debit");
    }

    @Test
    public void testUnsuccessfulWithdrawal() {
        String bigAmount = "1000000";

        testCustomerLoginInterface();

        List<WebElement> lastAmount = new BankingAccountPage(getDriver())
                .clickDepositMenu()
                .enterAmount(AMOUNT)
                .clickDepositButton()
                .verifyDepositSuccessfulMessageIsDisplay()
                .clickWithdrawlMenu()
                .waitDepositSuccessfulMessageIsNotDisplayed()
                .enterAmount(bigAmount)
                .clickWithdrawlButton()
                .verifyTransactionFailedMessageIsDisplay()
                .clickTransactions()
                .getLastTransaction();

        Assert.assertNotEquals(lastAmount.get(0).getText().trim(), bigAmount);
    }

    @Test
    public void testBalanceMatchesTransactionHistory() {
        String withdrawalAmount = "100000";

        testCustomerLoginInterface();

        BankingAccountPage bankingAccountPage = new BankingAccountPage(getDriver());
        String balance = bankingAccountPage
                .clickDepositMenu()
                .enterAmount(AMOUNT)
                .clickDepositButton()
                .verifyDepositSuccessfulMessageIsDisplay()
                .clickWithdrawlMenu()
                .waitDepositSuccessfulMessageIsNotDisplayed()
                .enterAmount(withdrawalAmount)
                .clickWithdrawlButton()
                .verifyTransactionSuccessfulMessageIsDisplay()
                .getBalance();

        String calculateBalance = bankingAccountPage
                .clickTransactions()
                .calculateBalanceFromTransactions();

        Assert.assertEquals(calculateBalance, balance);
    }

    @Test
    public void testWithdrawRemainBalanceToZero() {
        testCustomerLoginInterface();

        BankingAccountPage bankingAccountPage = new BankingAccountPage(getDriver());
        String balanceAfterDeposit = bankingAccountPage
                .clickDepositMenu()
                .enterAmount(AMOUNT)
                .clickDepositButton()
                .verifyDepositSuccessfulMessageIsDisplay()
                .getBalance();

        String remainBalance = bankingAccountPage
                .clickWithdrawlMenu()
                .waitDepositSuccessfulMessageIsNotDisplayed()
                .enterAmount(balanceAfterDeposit)
                .clickWithdrawlButton()
                .verifyTransactionSuccessfulMessageIsDisplay()
                .getBalance();

        Assert.assertEquals(remainBalance, "0");
    }

    @Test
    public void testClearingTransactionHistory() {
        testCustomerLoginInterface();

        BankingAccountPage bankingAccountPage = new BankingAccountPage(getDriver());
        int transactionCount = bankingAccountPage
                .clickDepositMenu()
                .enterAmount(AMOUNT)
                .clickDepositButton()
                .clickWithdrawlMenu()
                .waitDepositSuccessfulMessageIsNotDisplayed()
                .enterAmount("321")
                .clickWithdrawlButton()
                .clickTransactions()
                .getAllTransactions()
                .size();

        Assert.assertNotEquals(transactionCount, 0);

        BankingListTx bankingListTx = new BankingListTx(getDriver());
        List<WebElement> remainingTransactionsCount = bankingListTx
                .clickResetButton()
                .getAllTransactions();

        Assert.assertTrue(remainingTransactionsCount.isEmpty());

        String balance = bankingListTx
                .clickBackButton()
                .getBalance();

        Assert.assertEquals(balance, "0");
    }

    @Test
    public void testDeleteCustomer() {
        testAddCustomer();

        Boolean customerAbsent = new BankingManagerPage(getDriver())
                .clickCustomersMenu()
                .enterSearchCustomer(FIRST_NAME)
                .verifyCustomerFind(FIRST_NAME, LAST_NAME)
                .clickCustomerFindDeleteButton(FIRST_NAME, LAST_NAME)
                .isCustomerAbsent(FIRST_NAME, LAST_NAME);

        Assert.assertTrue(customerAbsent);
    }
}
