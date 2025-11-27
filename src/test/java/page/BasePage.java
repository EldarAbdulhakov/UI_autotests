package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.JavaScriptUtils;
import utils.WaiterUtils;

public abstract class BasePage {

    private final WebDriver driver;
    protected WaiterUtils waiter;
    protected JavaScriptUtils js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WaiterUtils(driver);
        this.js = new JavaScriptUtils(driver);
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
