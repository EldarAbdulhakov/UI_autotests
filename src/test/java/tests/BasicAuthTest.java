package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HTTPGalleryPage;
import utils.PropertyProvider;

import java.awt.*;
import java.awt.event.KeyEvent;

public class BasicAuthTest extends BaseTest {

    @Test
    public void testBasicAuth() {
        final String LOGIN = PropertyProvider.getInstance().getProperty("httpwatch.login");
        final String PASSWORD = PropertyProvider.getInstance().getProperty("httpwatch.password");

        Boolean isAuthImageDisplayed = new HTTPGalleryPage(getDriver())
                .setBasicAuthCredentials(LOGIN, PASSWORD)
                .clickDisplayImageButton()
                .isAuthImageDisplayed();

        Assert.assertTrue(isAuthImageDisplayed, "Authorization failed");
    }

    @Test
    public void testBasicAuthFirefox() throws InterruptedException, AWTException {
        final String LOGIN = PropertyProvider.getInstance().getProperty("httpwatch.login");
        final String PASSWORD = PropertyProvider.getInstance().getProperty("httpwatch.password");

        try {
            HTTPGalleryPage hTTPGalleryPage = new HTTPGalleryPage(getDriver());
            hTTPGalleryPage.clickDisplayImageButton();

            Robot robot = new Robot();
            typeStringWithRobot(robot, LOGIN);
            robot.keyPress(KeyEvent.VK_TAB);
            typeStringWithRobot(robot, PASSWORD);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_ENTER);

            Assert.assertTrue(hTTPGalleryPage.isAuthImageDisplayed());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void typeStringWithRobot(Robot robot, String text) {
        for (char c : text.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new RuntimeException("Key code not found for character: " + c);
            }

            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
    }
}
