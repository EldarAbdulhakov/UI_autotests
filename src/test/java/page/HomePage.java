package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@href='https://wa.me/+919711111558']")
    private WebElement headerPhone1;

    @FindBy(xpath = "//a[@href='https://wa.me/+919711191558']")
    private WebElement headerPhone2;

    @FindBy(xpath = "//a[@href='tel:+16464800603']")
    private WebElement headerPhone3;

    @FindBy(xpath = "//a[contains(@href, 'skype')]")
    private WebElement skypeLinkWebElement;

    @FindBy(xpath = "//header//a[@href='mailto:trainer@way2automation.com']")
    private WebElement headerEmail;

    @FindBy(xpath = "//a[@aria-label='Facebook']")
    private WebElement facebookLinkWebElement;

    @FindBy(xpath = "//a[@aria-label='Facebook']//*[name()='path' and contains(@d, 'M400 32H48A48 48 0 0 0 0 80v352a48')]")
    private WebElement facebookSvg;

    @FindBy(xpath = "//a[@aria-label='Linkedin']")
    private WebElement linkedinLinkWebElement;

    @FindBy(xpath = "//a[@aria-label='Linkedin']//*[name()='path' and contains(@d, 'M416 32H31.9C14.3 32 0 46.5')]")
    private WebElement linkedinSvg;

    @FindBy(xpath = "//a[@aria-label='Google']")
    private WebElement googleLinkWebElement;

    @FindBy(xpath = "//a[@aria-label='Google']//*[name()='path' and contains(@d, 'M400 32H48C21.5 32 0 53.5 0 80v352c0')]")
    private WebElement googleSvg;

    @FindBy(xpath = "//a[@aria-label='YouTube']")
    private WebElement youtubeLinkWebElement;

    @FindBy(xpath = "//a[@aria-label='YouTube']//*[name()='path' and contains(@d, 'M549.655 124.083c-6.281-23.65-24.787-42')]")
    private WebElement youtubeSvg;

    @FindBy(xpath = "//span[contains(text(), 'Way2Automation')]")
    private WebElement footerAddress;

    @FindBy(xpath = "//a[@href='tel:9711111558']")
    private WebElement footerPhone1;

    @FindBy(xpath = "//a[@href='tel:9711191558']")
    private WebElement footerPhone2;

    @FindBy(xpath = "//div[@data-elementor-type='footer']//a[@href='mailto:trainer@way2automation.com']")
    private WebElement footerEmail1;

    @FindBy(xpath = "//a[@href='mailto:seleniumcoaching@gmail.com']")
    private WebElement footerEmail2;

    @FindBy(xpath = "//h2[contains(text(),'Way2Automation - All Rights Are Reserved')]")
    private WebElement allRightsAreReserved;

    @FindBy(xpath = "//div[contains(@class, 'lazyloaded ast-sticky-active')]")
    private WebElement menu;

    @FindBy(xpath = "//*[@id='ast-desktop-header']//*[contains(text(), 'All Courses')]")
    private WebElement allCourses;

    @FindBy(xpath = "//*[@id='menu-item-27581']//*[contains(text(), 'Lifetime Membership')]")
    private WebElement lifetimeMembershipButton;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("https://www.way2automation.com/");
    }

    public String getHeaderPhone1() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(headerPhone1)).getText();
    }

    public String getHeaderPhone2() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(headerPhone2)).getText();
    }

    public String getHeaderPhone3() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(headerPhone3)).getText();
    }

    public WebElement skypeLinkWebElement() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(skypeLinkWebElement));
    }

    public String getHeaderEmail() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(headerEmail)).getText();
    }

    public WebElement facebookLinkWebElement() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(facebookLinkWebElement));
    }

    public WebElement facebookSvg() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(facebookSvg));
    }

    public WebElement getLinkedinLinkWebElement() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(linkedinLinkWebElement));
    }

    public WebElement getLinkedinSvg() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(linkedinSvg));
    }

    public WebElement getGoogleLinkWebElement() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(googleLinkWebElement));
    }

    public WebElement getGoogleSvg() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(googleSvg));
    }

    public WebElement getYoutubeLinkWebElement() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(youtubeLinkWebElement));
    }

    public WebElement getYoutubeSvg() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(youtubeSvg));
    }

    public String getFooterAddress() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(footerAddress))
                .getText()
                .split("\n")[1]
                .trim();
    }

    public String getFooterPhone1() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(footerPhone1)).getText();
    }

    public String getFooterPhone2() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(footerPhone2)).getText();
    }

    public String getFooterEmail1() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(footerEmail1)).getText();
    }

    public String getFooterEmail2() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(footerEmail2)).getText();
    }

    public HomePage pageDownScroll() {
        new Actions(getDriver())
                .scrollToElement(waiter.getWait2().until(ExpectedConditions.visibilityOf(allRightsAreReserved)))
                .scrollByAmount(0, 100)
                .perform();

        return this;
    }

    public Boolean getDisplayedMenu() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(menu)).isDisplayed();
    }

    public HomePage moveToAllCourses() {
        new Actions(getDriver())
                .moveToElement(waiter.getWait2().until(ExpectedConditions.visibilityOf(allCourses)))
                .perform();

        return this;
    }

    public MemberShipPage clickLifetimeMembershipButton() {
        lifetimeMembershipButton.click();

        return new MemberShipPage(getDriver());
    }
}
