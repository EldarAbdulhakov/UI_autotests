package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.FramesAndWindowsPage;

public class NewTabsTest extends BaseTest {

    @Test
    public void test() {
        int numberOfOpenTabs = new FramesAndWindowsPage(getDriver())
                .switchToNewBrowserTabLinkFrame()
                .clickNewBrowserTabLink()
                .switchToWindowsDefult1Page()
                .clickNewBrowserTabDefult1Page()
                .getNumberOfTabs();

        Assert.assertEquals(numberOfOpenTabs, 3);
    }
}
