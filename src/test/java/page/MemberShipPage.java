package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MemberShipPage extends BasePage {

    @FindBy(tagName = "h1")
    private WebElement title;

    public MemberShipPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get title")
    public String getTitle() {
        return waiter.getWait2().until(ExpectedConditions.visibilityOf(title)).getText();
    }
}
