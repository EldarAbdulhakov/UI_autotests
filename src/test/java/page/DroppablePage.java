package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DroppablePage extends BasePage {

    public DroppablePage(WebDriver driver) {
        super(driver);
        getDriver().get("http://way2automation.com/way2auto_jquery/droppable.php#load_box");
    }

    @FindBy(xpath = "//p[text()='Drag me to my target']")
    private WebElement dragMe;

    @FindBy(xpath = "//p[text()='Drop here']")
    private WebElement dropHere;

    @FindBy(xpath = "//iframe[@src='droppable/default.html']")
    private WebElement defaultIframe;

    @FindBy(xpath = "//div[@class='ui-widget-header ui-droppable ui-state-highlight']")
    private WebElement droppedHere;

    public DroppablePage switchToDroppableFrame() {
        waiter.getWait2().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(defaultIframe));

        return this;
    }

    public DroppablePage dragAndDrop() {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(dragMe));
        waiter.getWait2().until(ExpectedConditions.visibilityOf(dropHere));

        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(dragMe, dropHere)
                .perform();

        return this;
    }

    public String getDroppedHere() {
        return droppedHere.getText();
    }
}
