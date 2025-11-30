package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DroppablePage extends BasePage {

    public DroppablePage(WebDriver driver) {
        super(driver);
        getDriver().get("http://way2automation.com/way2auto_jquery/droppable.php#load_box");
    }

    @FindBy(xpath = )
    private WebElement ;

    @FindBy(xpath = )
    private WebElement ;

    @FindBy(xpath = )
    private WebElement ;

    @FindBy(xpath = )
    private WebElement ;

    @FindBy(xpath = )
    private WebElement ;

    @FindBy(xpath = )
    private WebElement ;
}
