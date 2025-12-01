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
    private WebElement draggable;

    @FindBy(xpath = "//iframe[@src='droppable/default.html']")
    private WebElement droppableFrame;

    @FindBy(id = "droppable")
    private WebElement droppable;

    public DroppablePage switchToDroppableFrame() {
        waiter.getWait2().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(droppableFrame));

        return this;
    }

    public DroppablePage dragAndDrop() {
        waiter.getWait2().until(ExpectedConditions.visibilityOf(draggable));
        waiter.getWait2().until(ExpectedConditions.visibilityOf(droppable));

        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(draggable, droppable)
                .perform();

        return this;
    }

    public String getDroppable() {
        return droppable.getText();
    }
}
