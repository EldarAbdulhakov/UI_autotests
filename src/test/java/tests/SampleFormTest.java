package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BankingLoginPage;

public class SampleFormTest extends BaseTest {

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
