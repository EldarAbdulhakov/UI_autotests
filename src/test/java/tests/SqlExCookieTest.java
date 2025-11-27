package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SqlExPage;
import utils.CookieUtils;
import utils.PropertyProvider;

public class SqlExCookieTest extends BaseTest {

    @Test
    public void testLoginWithCookies() {
        final String LOGIN = PropertyProvider.getInstance().getProperty("sql-ex.login");
        final String PASSWORD = PropertyProvider.getInstance().getProperty("sql-ex.password");

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
