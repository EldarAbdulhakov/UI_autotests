package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HTTPGalleryPage extends BasePage {

    private Alert alert;

    @FindBy(id = "displayImage")
    private WebElement displayImageButton;
//
//    @FindBy(xpath = "")
//    private WebElement ;
//
//    @FindBy(xpath = "")
//    private WebElement ;
//
//    @FindBy(xpath = "")
//    private WebElement ;

    public HTTPGalleryPage(WebDriver driver) {
        super(driver);
        getDriver().get("https://www.httpwatch.com/httpgallery/authentication/#showExample10");
    }

    public HTTPGalleryPage clickDisplayImageButton() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(displayImageButton)).click();

        return this;
    }

    public HTTPGalleryPage switchToAuthAlert() {
        alert = waiter.getWait5().until(ExpectedConditions.alertIsPresent());

        return this;
    }

    public HTTPGalleryPage enterLoginAndPasswordToAlertAndAccept(String login, String password) throws InterruptedException {

        DevTools devTools = getDriver().;
        devTools.createSession();

        Thread.sleep(2000);

        return this;
    }
}
