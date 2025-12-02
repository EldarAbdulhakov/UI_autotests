package tests;

import org.testng.annotations.Test;
import page.HTTPGalleryPage;
import utils.PropertyProvider;

public class BasicAuthTest extends BaseTest {

    @Test
    public void testBasicAuth() throws InterruptedException {
        final String LOGIN = PropertyProvider.getInstance().getProperty("httpwatch.login");
        final String PASSWORD = PropertyProvider.getInstance().getProperty("httpwatch.password");

        new HTTPGalleryPage(getDriver())
                .clickDisplayImageButton()
                .switchToAuthAlert()
                .enterLoginAndPasswordToAlertAndAccept(LOGIN, PASSWORD);
    }
}
