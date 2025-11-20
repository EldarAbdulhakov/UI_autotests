package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SampleFormPage extends BasePage {

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Sports']")
    private WebElement sportsCheckBox;

    @FindBy(id = "gender")
    private WebElement genderSelect;

    @FindBy(id = "about")
    private WebElement aboutYourselfField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerButton;

    @FindBy(id = "successMessage")
    private WebElement successRegisterMessage;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> hobbiesCheckboxes;

    public SampleFormPage(WebDriver driver) {
        super(driver);
    }

    public SampleFormPage enterFirstName(String firstName) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(firstName);

        return this;
    }

    public SampleFormPage enterLastName(String lastName) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(lastNameField)).sendKeys(lastName);

        return this;
    }

    public SampleFormPage enterEmail(String email) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);

        return this;
    }

    public SampleFormPage enterPassword(String password) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);

        return this;
    }

    public SampleFormPage checkSports() {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(sportsCheckBox)).click();

        return this;
    }

    public SampleFormPage selectMaleGender() {
        Select selectGender = new Select(waiter.getWait2().until(ExpectedConditions.visibilityOf(genderSelect)));
        selectGender.selectByValue("male");

        return this;
    }

    public SampleFormPage enterAboutYourselfAndLongestWordFromHobbies(String aboutYourself) {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(aboutYourselfField))
                .sendKeys(aboutYourself + longestWordFromHobbiesSection());

        return this;
    }

    public SampleFormPage clickRegisterButton() {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(registerButton)).click();

        return this;
    }

    public WebElement getSuccessRegisterMessage() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(successRegisterMessage));
    }

    public String longestWordFromHobbiesSection() {
        List<WebElement> checkboxes = waiter.getWait2().until(ExpectedConditions.visibilityOfAllElements(hobbiesCheckboxes));

        String longestWord = "";
        for (WebElement checkbox : checkboxes) {
            String valueText = checkbox.getAttribute("value");
            if (valueText.length() > longestWord.length()) {
                longestWord = valueText;
            }
        }

        return longestWord;
    }
}
