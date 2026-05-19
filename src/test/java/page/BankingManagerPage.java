package page;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BankingManagerPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(), 'Add Customer')]")
    private WebElement addCustomerMenu;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement postCodeField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addCustomerButton;

    @FindBy(xpath = "//button[contains(text(), 'Open Account')]")
    private WebElement openAccountMenu;

    @FindBy(id = "userSelect")
    private WebElement userSelect;

    @FindBy(id = "currency")
    private WebElement currencySelect;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement processButton;

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    private WebElement customersMenu;

    public BankingManagerPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Add Customer' menu")
    public BankingManagerPage clickAddCustomerMenu() {
        waiter.getWait5().until(ExpectedConditions.elementToBeClickable((addCustomerMenu))).click();

        return this;
    }

    @Step("Enter first name")
    public BankingManagerPage enterFirstName(String firstName) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(firstName);

        return this;
    }

    @Step("Enter last name")
    public BankingManagerPage enterLastName(String lastName) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(lastNameField)).sendKeys(lastName);

        return this;
    }

    @Step("Enter post code")
    public BankingManagerPage enterPostCode(String postCode) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(postCodeField)).sendKeys(postCode);

        return this;
    }

    @Step("Click 'Add Customer' button")
    public BankingManagerPage clickAddCustomerButton() {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(addCustomerButton)).click();

        return this;
    }

    @Step("Switch alert")
    public Alert switchAlert() {
        return getDriver().switchTo().alert();
    }

    @Step("Click 'Open Account' menu")
    public BankingManagerPage clickOpenAccountMenu() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(openAccountMenu)).click();

        return this;
    }

    @Step("Select customer")
    public BankingManagerPage selectCustomer(String firstAndLastNames) {
        Select selectCustomer = new Select(waiter.getWait5().until(ExpectedConditions.visibilityOf(userSelect)));
        selectCustomer.selectByVisibleText(firstAndLastNames);

        return this;
    }

    @Step("Select 'Dollar' currency")
    public BankingManagerPage selectDollarCurrency() {
        Select selectCustomer = new Select(waiter.getWait2().until(ExpectedConditions.visibilityOf(currencySelect)));
        selectCustomer.selectByValue("Dollar");

        return this;
    }

    @Step("Click 'Process' button")
    public BankingManagerPage clickProcessButton() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(processButton)).click();

        return this;
    }

    @Step("Click 'Customers' menu")
    public BankingManagerPage clickCustomersMenu() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(customersMenu)).click();

        return this;
    }

    @Step("Enter search customer")
    public BankingManagerPage enterSearchCustomer(String firstName) {
        waiter.getWait2().until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@type='text']")))
                .sendKeys(firstName);

        return this;
    }

    @Step("Verify customer find")
    public BankingManagerPage verifyCustomerFind(String firstName, String lastName) {
        waiter.getWait2().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//tr[td[1][text()='%s'] and td[2][text()='%s']]".formatted(firstName, lastName))));

        return this;
    }

    @Step("Click 'Delete' customer button")
    public BankingManagerPage clickCustomerFindDeleteButton(String firstName, String lastName) {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//tr[td[1][text()='%s'] and td[2][text()='%s']]//button[text()='Delete']"
                                .formatted(firstName, lastName))))
                .click();

        return this;
    }

    @Step("Is customer absent")
    public Boolean isCustomerAbsent(String firstName, String lastName) {
        return waiter.getWait2().until(driver -> getDriver().findElements(
                By.xpath("//tr[td[1][text()='%s'] and td[2][text()='%s']]"
                        .formatted(firstName, lastName)))).isEmpty();
    }
}
