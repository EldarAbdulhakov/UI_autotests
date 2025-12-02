package page;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.URI;
import java.util.function.Predicate;

public class HTTPGalleryPage extends BasePage {

    @FindBy(id = "displayImage")
    private WebElement displayImageButton;

    @FindBy(id = "downloadImg")
    private WebElement image;

    public HTTPGalleryPage(WebDriver driver) {
        super(driver);
        getDriver().get("https://www.httpwatch.com/httpgallery/authentication/#showExample10");
    }

    public HTTPGalleryPage clickDisplayImageButton() {
        waiter.getWait2().until(ExpectedConditions.elementToBeClickable(displayImageButton)).click();

        return this;
    }

    public HTTPGalleryPage setBasicAuthCredentials(String login, String password) {
        Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpwatch.com");
        HasAuthentication driverAuth = (HasAuthentication) getDriver();
        driverAuth.register(uriPredicate, UsernameAndPassword.of(login, password));

        return this;
    }

    public Boolean isImageDisplayed() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(image)).isDisplayed();
    }
}
