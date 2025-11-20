package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.RegistrationLoginPage;

public class RegistrationLoginPageTest extends BaseTest {

    final static String USERNAME = "angular";
    final static String PASSWORD = "password";
    final static String INVALID_PASSWORD = "invalid password";
    final static String USERNAME_DESCRIPTION = "username description";

    @Test
    public void testDisplayUsernameField() {
        Boolean usernameFieldDisplayed = new RegistrationLoginPage(getDriver())
                .isUsernameFieldDisplayed();

        Assert.assertTrue(usernameFieldDisplayed);
    }

    @Test
    public void testDisplayPasswordField() {
        Boolean passwordFieldDisplayed = new RegistrationLoginPage(getDriver())
                .isPasswordFieldDisplayed();

        Assert.assertTrue(passwordFieldDisplayed);
    }

    @Test
    public void testLoginButtonDisabledWithEmptyFields() {
        RegistrationLoginPage registrationLoginPage = new RegistrationLoginPage(getDriver());

        Assert.assertEquals(registrationLoginPage.getUsernameValueAttribute(), "");
        Assert.assertEquals(registrationLoginPage.getPasswordValueAttribute(), "");
        Assert.assertFalse(registrationLoginPage.isLoginButtonEnabled());
    }

    @Test
    public void testSuccessfulLogin() {
        String successMessage = new RegistrationLoginPage(getDriver())
                .enterUserName(USERNAME)
                .enterPassword(PASSWORD)
                .enterUserNameDescription(USERNAME_DESCRIPTION)
                .clickLoginButton()
                .getSuccessAuthMessage();

        Assert.assertEquals(successMessage, "You're logged in!!");
    }

    @Test
    public void testLoginWithInvalidPassword() {
        String invalidAuthMessage = new RegistrationLoginPage(getDriver())
                .enterUserName(USERNAME)
                .enterPassword(INVALID_PASSWORD)
                .enterUserNameDescription(USERNAME_DESCRIPTION)
                .clickLoginButton()
                .getInvalidAuthMessage();

        Assert.assertEquals(invalidAuthMessage, "Username or password is incorrect");
    }

    @Test
    public void testSuccessfulLogout() {
        RegistrationLoginPage registrationLoginPage = new RegistrationLoginPage(getDriver())
                .enterUserName(USERNAME)
                .enterPassword(PASSWORD)
                .enterUserNameDescription(USERNAME_DESCRIPTION)
                .clickLoginButton()
                .clickLogoutButton();

        Assert.assertTrue(registrationLoginPage.isUsernameFieldDisplayed());
        Assert.assertTrue(registrationLoginPage.isPasswordFieldDisplayed());
        Assert.assertTrue(registrationLoginPage.isUsernameDescriptionDisplayed());
    }
}
