package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HTTPGalleryPage;
import utils.PropertyProvider;

public class BasicAuthTest extends BaseTest {

    @Test
    public void testBasicAuth() {
        final String LOGIN = PropertyProvider.getInstance().getProperty("httpwatch.login");
        final String PASSWORD = PropertyProvider.getInstance().getProperty("httpwatch.password");

        Boolean isAuthImageDisplayed = new HTTPGalleryPage(getDriver())
                .setBasicAuthCredentials(LOGIN, PASSWORD)
                .clickDisplayImageButton()
                .isImageDisplayed();

        Assert.assertTrue(isAuthImageDisplayed, "Authorization failed");
    }
}
