package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FramesAndWindowsPage extends BasePage {

    @FindBy(xpath = "//iframe[@src='frames-windows/defult1.html']")
    private WebElement linkFrame;

    @FindBy(xpath = "//a[text()='New Browser Tab']")
    private WebElement newBrowserTabLink;

    public FramesAndWindowsPage(WebDriver driver) {
        super(driver);
        getDriver().get("http://way2automation.com/way2auto_jquery/frames-and-windows.php#load_box");
    }

    public FramesAndWindowsPage switchToNewBrowserTabLinkFrame() {
        waiter.getWait2().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(linkFrame));

        return this;
    }

    public FramesAndWindowsPage clickNewBrowserTabLink() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(newBrowserTabLink)).click();
        waiter.getWait2().until(ExpectedConditions.numberOfWindowsToBe(2));

        return this;
    }

    public FramesWindowsDefult1Page switchToWindowsDefult1Page() {
        String firstWindowHandle = getDriver().getWindowHandle();

        for (String handle : getDriver().getWindowHandles()) {
            if (!handle.equals(firstWindowHandle)) {
                getDriver().switchTo().window(handle);
            }
        }

        return new FramesWindowsDefult1Page(getDriver());
    }
}
