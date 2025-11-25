package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.RegistrationLoginPage;

@Epic("User Authentication")
@Feature("Login and Logout")
public class RegistrationLoginPageTest extends BaseTest {

    final static String USERNAME = "angular";
    final static String PASSWORD = "password";
    final static String INVALID_PASSWORD = "invalid password";
    final static String USERNAME_DESCRIPTION = "username description";

    @DataProvider(name = "authData")
    public Object[][] authData() {
        return new Object[][]{
                {"angular", "password", "use", "You're logged in!!"},
                {"angular", "wrongPass", "username description", "Username or password is incorrect"},
                {"wrongUser", "password", "username description", "Username or password is incorrect"},
                {"angular", "pas", "username description", "Username or password is incorrect"},
                {"ang", "password", "username description", "Username or password is incorrect"}
        };
    }

    @DataProvider(name = "disableLoginButtonData")
    public Object[][] disableLoginButtonData() {
        return new Object[][]{
                {"", "", "username description"},
                {"", "", ""},
                {"angular", "", "username description"},
                {"", "password", "username description"},
                {"angular", "password", ""},
                {"angular", "password", "u"},
                {"angular", "password", "us"},
                {"angular", "p", "username description"},
                {"angular", "pa", "username description"},
                {"a", "password", "username description"},
                {"an", "password", "username description"}
        };
    }

    @Test(dataProvider = "authData")
    public void testAuthorization(String username, String password, String usernameDescription, String expectedMassage) {
        String authMessage = new RegistrationLoginPage(getDriver())
                .enterUserName(username)
                .enterPassword(password)
                .enterUserNameDescription(usernameDescription)
                .clickLoginButton()
                .getAnyAuthMessage();

        Assert.assertEquals(authMessage, expectedMassage);
    }

    @Test(dataProvider = "disableLoginButtonData")
    public void testLoginButtonDisabledWhenInvalidInput(String username, String password, String usernameDescription) {
        Boolean isLoginButtonEnabled = new RegistrationLoginPage(getDriver())
                .enterUserName(username)
                .enterPassword(password)
                .enterUserNameDescription(usernameDescription)
                .isLoginButtonEnabled();

        Assert.assertFalse(isLoginButtonEnabled, "Login button is enabled");
    }

    @Story("Verify Username field")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void testDisplayUsernameField() {
        Boolean usernameFieldDisplayed = new RegistrationLoginPage(getDriver())
                .isUsernameFieldDisplayed();

        Assert.assertTrue(usernameFieldDisplayed);
    }

    @Story("Verify Password field")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void testDisplayPasswordField() {
        Boolean passwordFieldDisplayed = new RegistrationLoginPage(getDriver())
                .isPasswordFieldDisplayed();

        Assert.assertTrue(passwordFieldDisplayed);
    }

    @Story("Verify Login button is disabled when Username and Password fields are empty")
    @Severity(value = SeverityLevel.MINOR)
    @Test
    public void testLoginButtonDisabledWithEmptyFields() {
        RegistrationLoginPage registrationLoginPage = new RegistrationLoginPage(getDriver());

        Assert.assertEquals(registrationLoginPage.getUsernameValueAttribute(), "");
        Assert.assertEquals(registrationLoginPage.getPasswordValueAttribute(), "");
        Assert.assertFalse(registrationLoginPage.isLoginButtonEnabled());
    }

    @Story("Verify successful login with valid username and password")
    @Severity(value = SeverityLevel.BLOCKER)
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

    @Story("Verify login fails with invalid password")
    @Severity(value = SeverityLevel.CRITICAL)
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

    @Story("Verify successful logout returns user to login form")
    @Severity(value = SeverityLevel.MINOR)
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
