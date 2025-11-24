package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SqlExPage;
import utils.CookieUtils;

public class SqlExCookieTest extends BaseTest {

    @Test
    public void testExperiments1() {
        final String LOGIN = "eldar55";
        final String PASSWORD = "UzF3kyUd@4j8x6V";

        SqlExPage page = new SqlExPage(getDriver());

        if (CookieUtils.loadCookies(getDriver())) {
            getDriver().navigate().refresh();
        } else {
            page
                    .enterLogin(LOGIN)
                    .enterPassword(PASSWORD)
                    .clickEnter();

            CookieUtils.saveCookies(getDriver());
        }

        Assert.assertEquals(page.getUserName(), "Eldar5");
    }
}
