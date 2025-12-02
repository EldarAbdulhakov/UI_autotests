package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FramesWindowsDefult1Page extends BasePage {

    @FindBy(xpath = "//a[text()='New Browser Tab']")
    private WebElement newBrowserTabDefult1PageLink;

    public FramesWindowsDefult1Page(WebDriver driver) {
        super(driver);
    }

    public FramesWindowsDefult1Page clickNewBrowserTabLinkOfDefult1Page() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(newBrowserTabDefult1PageLink)).click();


        return this;
    }

    public int getNumberOfTabs() {
        return getDriver().getWindowHandles().size();
    }
}
