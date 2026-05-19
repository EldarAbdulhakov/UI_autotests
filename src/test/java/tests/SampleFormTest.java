package tests;

import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BankingLoginPage;

@Epic("User registration")
@Feature("Sample Registration Form")
public class SampleFormTest extends BaseTest {

    @Story("Register a new user through the 'Sample Form' with generated longest word from 'Hobbies' section")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void testSuccessfulRegistrationInSampleForm() {
        final String FIRST_NAME = "Petr";
        final String LAST_NAME = "Ivanov";
        final String EMAIL = "peiv@mail.com";
        final String PASSWORD = "paSs154!";
        final String ABOUT_YOURSELF = "Самое длинное слово из предложенных хобби - ";

        WebElement successRegisterMessage = new BankingLoginPage(getDriver())
                .clickSampleFormButton()
                .enterFirstName(FIRST_NAME)
                .enterLastName(LAST_NAME)
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .checkSports()
                .selectMaleGender()
                .enterAboutYourselfAndLongestWordFromHobbies(ABOUT_YOURSELF)
                .clickRegisterButton()
                .getSuccessRegisterMessage();

        Assert.assertTrue(successRegisterMessage.isDisplayed());
        Assert.assertEquals(successRegisterMessage.getText(), "User registered successfully!");
    }
}
