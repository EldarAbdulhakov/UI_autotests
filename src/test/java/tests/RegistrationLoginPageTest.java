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
    public Object[][] provideAuthData() {
        return new Object[][]{
                {"angular", "password", "use", "You're logged in!!"},
                {"angular", "wrongPass", "username description", "Username or password is incorrect"},
                {"wrongUser", "password", "username description", "Username or password is incorrect"},
                {"", "", "username description", "emptyFields"},
                {"", "", "", "emptyFields"},
                {"angular", "", "username description", "emptyFields"},
                {"", "password", "username description", "emptyFields"},
                {"angular", "password", "", "emptyFields"},
                {"angular", "password", "u", "less than 3 characters"},
                {"angular", "password", "us", "less than 3 characters"},
                {"angular", "p", "username description", "less than 3 characters"},
                {"angular", "pa", "username description", "less than 3 characters"},
                {"angular", "pas", "username description", "Username or password is incorrect"},
                {"a", "password", "username description", "less than 3 characters"},
                {"an", "password", "username description", "less than 3 characters"},
                {"ang", "password", "username description", "Username or password is incorrect"}
        };
    }

    @Test(dataProvider = "authData")
    public void testAuthorization(String username, String password, String usernameDescription, String expectedMassage) {
        RegistrationLoginPage registrationLoginPage = new RegistrationLoginPage(getDriver())
                .enterUserName(username)
                .enterPassword(password)
                .enterUserNameDescription(usernameDescription);

        if (expectedMassage.equals("emptyFields") || expectedMassage.equals("less than 3 characters")) {
            Assert.assertFalse(registrationLoginPage.isLoginButtonEnabled(), "Login button is enabled");
            return;
        }

        String authMessage = registrationLoginPage
                .clickLoginButton()
                .getAnyAuthMessage();

        Assert.assertEquals(authMessage, expectedMassage);
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
