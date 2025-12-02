package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.FramesAndWindowsPage;

public class NewTabsTest extends BaseTest {

    @Test
    public void testOpenTabs() {
        FramesAndWindowsPage framesAndWindowsPage = new FramesAndWindowsPage(getDriver());

        int initialNumberOfTabs = framesAndWindowsPage
                .getNumberOfTabs();

        int finalNumberOfTabs = framesAndWindowsPage
                .switchToNewBrowserTabLinkFrame()
                .clickNewBrowserTabLink()
                .switchToWindowsDefult1Page()
                .clickNewBrowserTabLinkOfDefult1Page()
                .getNumberOfTabs();

        Assert.assertEquals(finalNumberOfTabs - initialNumberOfTabs + 1, 3);
    }
}
